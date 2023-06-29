package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.WorkExperienceService;
import ashina.hrms.dataAccess.abstracts.WorkExperienceDao;
import ashina.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public WorkExperience saveWorkExperience(WorkExperience workExperience) {
        return workExperienceDao.save(workExperience);
    }

    @Override
    public WorkExperience findById(int id) {
        return workExperienceDao.findById(id);
    }
}
