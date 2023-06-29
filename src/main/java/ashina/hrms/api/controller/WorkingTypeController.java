package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.WorkingTypeService;
import ashina.hrms.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/working-types")
public class WorkingTypeController {

    private WorkingTypeService workingTypeService;

    @Autowired
    public WorkingTypeController(WorkingTypeService workingTypeService) {
        this.workingTypeService = workingTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<WorkingType>> getAll(){
        List<WorkingType> workingTypes = workingTypeService.getAll();
        return new ResponseEntity<>(workingTypes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<WorkingType> addWorkingType(@RequestBody WorkingType workingType){
        WorkingType savedWorkingType = workingTypeService.saveWorkingType(workingType);
        return ResponseEntity.ok(savedWorkingType);
    }

}
