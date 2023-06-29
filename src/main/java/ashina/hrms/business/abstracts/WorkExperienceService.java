package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {

    WorkExperience saveWorkExperience(WorkExperience workExperience);

    WorkExperience findById(int id);


}
