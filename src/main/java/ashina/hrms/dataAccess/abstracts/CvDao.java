package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDao extends JpaRepository<Cv, Integer> {

}
