package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.JobPositions;
import ashina.hrms.entities.concretes.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface JobPositionsService {

    List<JobPositions> getAll();

    Optional<JobPositions> findByJobTitle(String title);

    JobPositions saveJobPositon(JobPositions jobPositions);

    void deleteById(int id);

    Optional<JobPositions> findById(int id);


}
