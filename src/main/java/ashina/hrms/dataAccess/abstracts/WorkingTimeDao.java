package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {



}
