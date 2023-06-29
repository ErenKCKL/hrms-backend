package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.EmployerService;
import ashina.hrms.entities.concretes.Employee;
import ashina.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employer>> getAll(){
        List<Employer> employers = employerService.getAll();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Employer> registerEmployer(@RequestBody Employer employer){

        if (employerService.existsByEmail(employer.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already registered.");
        }

        if (employerService.existsByTaxNumber(employer.getTaxNumber())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Tax number already registered.");
        }

        Employer savedEmployer = employerService.saveEmployer(employer);
        return ResponseEntity.ok(savedEmployer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable int id){
        return employerService.findById(id).map(employer -> {
            employerService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employer> findById(@PathVariable int id){
        return employerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employer> findByEmail(@PathVariable String email){
        return employerService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tax-number/{taxNumber}")
    public ResponseEntity<Employer> findByTaxNumber(@PathVariable String taxNumber){
        return employerService.findByTaxNumber(taxNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/exists-by-email/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){
        boolean exists = employerService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/exists-by-tax-number/{taxNumber}")
    public ResponseEntity<Boolean> existsByTaxNumber(@PathVariable String taxNumber){
        boolean exists = employerService.existsByTaxNumber(taxNumber);
        return ResponseEntity.ok(exists);
    }



}
