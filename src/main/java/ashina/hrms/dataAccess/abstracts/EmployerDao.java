package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Optional<Employer> findById(int id);

    Optional<Employer> findByEmail(String email);

    Optional<Employer> findByTaxNumber(String taxNumber);

    boolean existsByEmail(String email);

    boolean existsByTaxNumber(String taxNumber);

}
