package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Education;
import ashina.hrms.entities.concretes.JobPositions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationDao extends JpaRepository<Education, Integer> {

    Education findById(int id);
}
