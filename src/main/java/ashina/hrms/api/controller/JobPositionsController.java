package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.JobPositionsService;
import ashina.hrms.business.abstracts.JobTitleService;
import ashina.hrms.entities.concretes.JobPositions;
import ashina.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {
    private JobTitleService jobTitleService;

    private JobPositionsService jobPositionsService;

    @Autowired
    public JobPositionsController(JobPositionsService jobPositionsService,JobTitleService jobTitleService) {
        this.jobPositionsService = jobPositionsService;
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JobPositions>> getAll(){
        List<JobPositions> jobPositions = jobPositionsService.getAll();
        return new ResponseEntity<>(jobPositions, HttpStatus.OK);
    }

    @GetMapping("/title/{id}")
    public ResponseEntity<String> getJobTitleByJobPositionId(@PathVariable int id){
        Optional<JobPositions> jobPositionsOptional = jobPositionsService.findById(id);
        if (jobPositionsOptional.isPresent()) {
            JobTitle jobTitle = jobPositionsOptional.get().getJobTitle();
            String title = jobTitle.getTitle();
            return ResponseEntity.ok(title);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addJobPosition")
    public ResponseEntity<JobPositions> addJobPosition(@RequestBody JobPositions jobPositions){
        JobTitle savedJobTitle = jobTitleService.saveJobTitle(jobPositions.getJobTitle());
        jobPositions.setJobTitle(savedJobTitle);

        JobPositions savedJobPosition = jobPositionsService.saveJobPositon(jobPositions);
        return ResponseEntity.ok(savedJobPosition);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<JobPositions> findById(@PathVariable int id){
        return jobPositionsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosition(@PathVariable int id){
        return jobPositionsService.findById(id).map(jobPosition -> {
            jobPositionsService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
