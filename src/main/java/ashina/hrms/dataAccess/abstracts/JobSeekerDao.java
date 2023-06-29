package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    Optional<JobSeeker> findByEmail(String email);

    Optional<JobSeeker> findById(int id);

    Optional<JobSeeker> findByNationalIdentity(String nationalIdentity);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentity(String nationalIdentity);


}
