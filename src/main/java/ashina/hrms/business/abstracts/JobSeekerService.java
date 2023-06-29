package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface JobSeekerService {

    List<JobSeeker> getAll();

    JobSeeker saveJobSeeker(JobSeeker jobSeeker);

    Optional<JobSeeker> findById(int id);

    Optional<JobSeeker> findByEmail(String email);

    Optional<JobSeeker> findByNationalIdentity(String nationalIdentity);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentity(String nationalIdentity);

    void deleteById(int id);

}
