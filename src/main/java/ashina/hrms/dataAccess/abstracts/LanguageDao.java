package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {

    Language findById(int id);

}
