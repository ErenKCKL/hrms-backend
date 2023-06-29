package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Education;

public interface EducationService {

    Education saveEducation(Education education);

    Education findById(int id);

}
