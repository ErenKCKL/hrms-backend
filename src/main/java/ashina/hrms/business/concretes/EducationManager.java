package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.EducationService;
import ashina.hrms.dataAccess.abstracts.EducationDao;
import ashina.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Education saveEducation(Education education) {
        return educationDao.save(education);
    }

    @Override
    public Education findById(int id) {
        return educationDao.findById(id);
    }


}
