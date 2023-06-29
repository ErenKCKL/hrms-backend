package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.JobSeekerService;
import ashina.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/jobseekers")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JobSeeker>> getAll(){
        List<JobSeeker> jobSeekers = jobSeekerService.getAll();
        return new ResponseEntity<>(jobSeekers, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<JobSeeker> registerJobSeeker(@RequestBody JobSeeker jobSeeker) {
        if (jobSeekerService.existsByEmail(jobSeeker.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already registered.");
        }

        if (jobSeekerService.existsByNationalIdentity(jobSeeker.getNationalIdentity())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "National Identification Number already registered.");
        }

        JobSeeker savedJobSeeker = jobSeekerService.saveJobSeeker(jobSeeker);
        return ResponseEntity.ok(savedJobSeeker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        return jobSeekerService.findById(id).map(client -> {
            jobSeekerService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JobSeeker> findById(@PathVariable int id){
        return jobSeekerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<JobSeeker> findByEmail(@PathVariable String email){
        return jobSeekerService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/national-identity/{nationalIdentity}")
    public ResponseEntity<JobSeeker> findByNationalIdentity(@PathVariable String nationalIdentity){
        return jobSeekerService.findByNationalIdentity(nationalIdentity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/exists-by-email/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){
        boolean exists = jobSeekerService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/exists-by-national-identity/{nationalIdentity}")
    public ResponseEntity<Boolean> existsByNationalIdentity(@PathVariable String nationalIdentity){
        boolean exists = jobSeekerService.existsByNationalIdentity(nationalIdentity);
        return ResponseEntity.ok(exists);
    }






}
