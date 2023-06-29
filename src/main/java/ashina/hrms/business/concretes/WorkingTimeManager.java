package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.WorkingTimeService;
import ashina.hrms.dataAccess.abstracts.WorkingTimeDao;
import ashina.hrms.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    private WorkingTimeDao workingTimeDao;

    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
        this.workingTimeDao = workingTimeDao;
    }

    @Override
    public List<WorkingTime> getAll() {
        return workingTimeDao.findAll();
    }

    @Override
    public WorkingTime saveWorkingTime(WorkingTime workingTime) {
        return workingTimeDao.save(workingTime);
    }
}
