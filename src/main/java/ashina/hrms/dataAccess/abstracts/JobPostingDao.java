package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
}
