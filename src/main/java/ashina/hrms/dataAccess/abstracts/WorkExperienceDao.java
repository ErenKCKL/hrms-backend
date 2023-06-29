package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Education;
import ashina.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

    WorkExperience findById(int id);

}
