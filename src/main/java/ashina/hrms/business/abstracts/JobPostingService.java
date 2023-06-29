package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService {

    List<JobPosting> getAll();

    JobPosting saveJobPosting(JobPosting jobPosting);

}
