package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

    Optional<JobTitle> findByTitle(String title);

    Optional<JobTitle> findById(int id);

}
