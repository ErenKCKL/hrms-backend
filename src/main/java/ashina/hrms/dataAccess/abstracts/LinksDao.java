package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Links;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinksDao extends JpaRepository<Links, Integer> {

    Links findById(int id);

}
