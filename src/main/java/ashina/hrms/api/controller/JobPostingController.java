package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.JobPostingService;
import ashina.hrms.entities.concretes.JobPosting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/job-posting")
public class JobPostingController {

    private JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JobPosting>> getAll(){
        List<JobPosting> jobPostings = jobPostingService.getAll();
        return new ResponseEntity<>(jobPostings, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobPosting> addJobPosting(@RequestBody JobPosting jobPosting){
        JobPosting savedJobPosting = jobPostingService.saveJobPosting(jobPosting);
        return ResponseEntity.ok(savedJobPosting);
    }

}
