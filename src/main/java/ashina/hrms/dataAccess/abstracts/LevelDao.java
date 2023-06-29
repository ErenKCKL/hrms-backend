package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelDao extends JpaRepository<Level, Integer> {

    Level findById(int id);

}
