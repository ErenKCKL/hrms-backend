package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.WorkingTime;

import java.util.List;

public interface WorkingTimeService {

    List<WorkingTime> getAll();

    WorkingTime saveWorkingTime(WorkingTime workingTime);


}
