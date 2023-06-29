package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.WorkingTypeService;
import ashina.hrms.dataAccess.abstracts.WorkingTypeDao;
import ashina.hrms.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTypeManager implements WorkingTypeService {

    private WorkingTypeDao workingTypeDao;

    @Autowired
    public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
        this.workingTypeDao = workingTypeDao;
    }

    @Override
    public List<WorkingType> getAll() {
        return workingTypeDao.findAll();
    }

    @Override
    public WorkingType saveWorkingType(WorkingType workingType) {
        return workingTypeDao.save(workingType);
    }
}
