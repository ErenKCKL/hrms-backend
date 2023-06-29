package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.JobTitleService;
import ashina.hrms.dataAccess.abstracts.JobTitleDao;
import ashina.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return jobTitleDao.findAll();
    }

    @Override
    public JobTitle saveJobTitle(JobTitle jobTitle) {
        return jobTitleDao.save(jobTitle);
    }

    @Override
    public void deleteById(int id) {
        jobTitleDao.deleteById(id);
    }

    @Override
    public Optional<JobTitle> findById(int id) {
        return jobTitleDao.findById(id);
    }
}
