package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
}
