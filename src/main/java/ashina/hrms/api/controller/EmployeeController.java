package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.EmployeeService;
import ashina.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
        if (employeeService.existsByEmail(employee.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already registered.");
        }

        if (employeeService.existsByNationalIdentity(employee.getNationalIdentity())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "National Identification Number already registered.");
        }

        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        return employeeService.findById(id).map(employee -> {
            employeeService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id){
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/national-identity/{nationalIdentity}")
    public ResponseEntity<Employee> findByNationalIdentity(@PathVariable String nationalIdentity){
        return employeeService.findByNationalIdentity(nationalIdentity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> findByEmail(@PathVariable String email){
        return employeeService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/exists-by-email/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){
        boolean exists = employeeService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/exists-by-national-identity/{nationalIdentity}")
    public ResponseEntity<Boolean> existsByNationalIdentity(@PathVariable String nationalIdentity){
        boolean exists = employeeService.existsByNationalIdentity(nationalIdentity);
        return ResponseEntity.ok(exists);
    }





}
