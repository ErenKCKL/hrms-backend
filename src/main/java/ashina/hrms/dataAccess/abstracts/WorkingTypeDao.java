package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.WorkingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer> {



}
