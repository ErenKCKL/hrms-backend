package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.JobPositionsService;
import ashina.hrms.dataAccess.abstracts.JobPositionDao;
import ashina.hrms.entities.concretes.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionsService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPositions> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public Optional<JobPositions> findByJobTitle(String title) {
        return jobPositionDao.findByJobTitle(title);
    }

    @Override
    public JobPositions saveJobPositon(JobPositions jobPositions) {
        return jobPositionDao.save(jobPositions);
    }

    @Override
    public void deleteById(int id) {
        jobPositionDao.deleteById(id);
    }

    @Override
    public Optional<JobPositions> findById(int id) {
        return jobPositionDao.findById(id);
    }
}
