package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Integer> {
}
