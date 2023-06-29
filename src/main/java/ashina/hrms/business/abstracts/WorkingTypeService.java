package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.WorkingType;

import java.util.List;

public interface WorkingTypeService {

    List<WorkingType> getAll();

    WorkingType saveWorkingType(WorkingType workingType);

}
