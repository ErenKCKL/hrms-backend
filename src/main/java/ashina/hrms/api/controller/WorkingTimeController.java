package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.WorkingTimeService;
import ashina.hrms.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/working-times")
public class WorkingTimeController {

    private WorkingTimeService workingTimeService;

    @Autowired
    public WorkingTimeController(WorkingTimeService workingTimeService) {
        this.workingTimeService = workingTimeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<WorkingTime>> getAll(){
        List<WorkingTime> workingTimes = workingTimeService.getAll();
        return new ResponseEntity<>(workingTimes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<WorkingTime> add(@RequestBody WorkingTime workingTime){
        WorkingTime savedWorkingTime = workingTimeService.saveWorkingTime(workingTime);
        return ResponseEntity.ok(savedWorkingTime);
    }


}
