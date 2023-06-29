package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.JobPostingService;
import ashina.hrms.dataAccess.abstracts.JobPostingDao;
import ashina.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public List<JobPosting> getAll() {
        return jobPostingDao.findAll();
    }

    @Override
    public JobPosting saveJobPosting(JobPosting jobPosting) {
        return jobPostingDao.save(jobPosting);
    }
}
