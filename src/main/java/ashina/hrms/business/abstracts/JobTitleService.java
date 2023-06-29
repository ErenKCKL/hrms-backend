package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.JobSeeker;
import ashina.hrms.entities.concretes.JobTitle;

import java.util.List;
import java.util.Optional;

public interface JobTitleService {

    List<JobTitle> getAll();

    JobTitle saveJobTitle(JobTitle jobTitle);

    void deleteById(int id);

    Optional<JobTitle> findById(int id);


}
