package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.JobTitleService;
import ashina.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitleController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<JobTitle>> getAll(){
        List<JobTitle> jobTitles = jobTitleService.getAll();
        return new ResponseEntity<>(jobTitles, HttpStatus.OK);
    }

    @PostMapping("/addJobTitle")
    public ResponseEntity<JobTitle> addJobTitle(@RequestBody JobTitle jobTitle){
        JobTitle savedJobTitle = jobTitleService.saveJobTitle(jobTitle);
        return ResponseEntity.ok(savedJobTitle);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<JobTitle> findById(@PathVariable int id){
        return jobTitleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobTitle(@PathVariable int id){
        return jobTitleService.findById(id).map(jobTitle -> {
            jobTitleService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
