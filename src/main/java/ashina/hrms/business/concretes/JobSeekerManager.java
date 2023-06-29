package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.JobSeekerService;
import ashina.hrms.dataAccess.abstracts.JobSeekerDao;
import ashina.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public List<JobSeeker> getAll() {
        return jobSeekerDao.findAll();
    }

    @Override
    public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerDao.save(jobSeeker);
    }

    @Override
    public Optional<JobSeeker> findById(int id) {
        return jobSeekerDao.findById(id);
    }

    @Override
    public Optional<JobSeeker> findByEmail(String email) {
        return jobSeekerDao.findByEmail(email);
    }

    @Override
    public Optional<JobSeeker> findByNationalIdentity(String nationalIdentity) {
        return jobSeekerDao.findByNationalIdentity(nationalIdentity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jobSeekerDao.existsByEmail(email);
    }

    @Override
    public boolean existsByNationalIdentity(String nationalIdentity) {
        return jobSeekerDao.existsByNationalIdentity(nationalIdentity);
    }

    @Override
    public void deleteById(int id) {
        jobSeekerDao.deleteById(id);
    }
}
