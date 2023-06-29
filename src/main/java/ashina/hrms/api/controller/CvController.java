package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.*;
import ashina.hrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resumes")
public class CvController {

    private CvService cvService;
    private EducationService educationService;

    private JobSeekerService jobSeekerService;

    private WorkExperienceService workExperienceService;

    private LanguageService languageService;

    private LevelService levelService;

    private LinksService linksService;

    private SkillService skillService;



    @Autowired
    public CvController(CvService cvService, EducationService educationService, JobSeekerService jobSeekerService,
                        WorkExperienceService workExperienceService,
                        LanguageService languageService, LevelService levelService,
                        LinksService linksService, SkillService skillService) {
        this.cvService = cvService;
        this.educationService = educationService;
        this.jobSeekerService = jobSeekerService;
        this.workExperienceService = workExperienceService;
        this.languageService = languageService;
        this.levelService = levelService;
        this.linksService = linksService;
        this.skillService = skillService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cv>> getAll(){
        List<Cv> resumes = cvService.getAll();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cv> add(@RequestBody Cv cv){
        Education education = educationService.findById(cv.getEducation().getId());
        cv.setEducation(education);

        Optional<JobSeeker> jobSeeker = jobSeekerService.findById(cv.getJobSeeker().getId());
        JobSeeker actualJobSeeker = jobSeeker.orElseThrow(() -> new RuntimeException("JobSeeker not found"));
        cv.setJobSeeker(actualJobSeeker);

        WorkExperience workExperience = workExperienceService.findById(cv.getWorkExperience().getId());
        cv.setWorkExperience(workExperience);

        Language language = languageService.findById(cv.getLanguage().getId());
        cv.setLanguage(language);

        Links links = linksService.findById(cv.getLinks().getId());
        cv.setLinks(links);

        Skill skill = skillService.findById(cv.getSkill().getId());
        cv.setSkill(skill);

        Cv savedCv = cvService.saveCv(cv);
        return ResponseEntity.ok(savedCv);
    }

    @PostMapping("/educations")
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education savedEducation = educationService.saveEducation(education);
        return ResponseEntity.ok(savedEducation);
    }

    @PostMapping("/jobSeekers")
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        JobSeeker savedJobSeeker = jobSeekerService.saveJobSeeker(jobSeeker);
        return ResponseEntity.ok(savedJobSeeker);
    }

    @PostMapping("/work-experience")
    public ResponseEntity<WorkExperience> createWorkExperience(@RequestBody WorkExperience workExperience) {
        WorkExperience savedWorkExperience = workExperienceService.saveWorkExperience(workExperience);
        return ResponseEntity.ok(savedWorkExperience);
    }

    @PostMapping("/language")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Level level = levelService.findById(language.getLevel().getId());
        language.setLanguage(String.valueOf(level));

        Language savedLanguage = languageService.save(language);
        return ResponseEntity.ok(savedLanguage);
    }

    @PostMapping("/level")
    public ResponseEntity<Level> createLevel(@RequestBody Level level) {
        Level savedLevel = levelService.save(level);
        return ResponseEntity.ok(savedLevel);
    }

    @PostMapping("/links")
    public ResponseEntity<Links> createLinks(@RequestBody Links links) {
        Links savedLinks = linksService.save(links);
        return ResponseEntity.ok(savedLinks);
    }

    @PostMapping("/skills")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill savedSkill = skillService.save(skill);
        return ResponseEntity.ok(savedSkill);
    }

}
