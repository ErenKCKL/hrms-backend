package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.JobPositions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPositionDao extends JpaRepository<JobPositions, Integer> {

    Optional<JobPositions> findByJobTitle(String title);

    Optional<JobPositions> findById(int id);


}
