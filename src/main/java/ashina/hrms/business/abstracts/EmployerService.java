package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Employer;

import java.util.List;
import java.util.Optional;

public interface EmployerService {

    List<Employer> getAll();

    Employer saveEmployer(Employer employer);

    void deleteById(int id);

    Optional<Employer> findById(int id);

    Optional<Employer> findByEmail(String email);

    Optional<Employer> findByTaxNumber(String taxNumber);

    boolean existsByEmail(String email);

    boolean existsByTaxNumber(String taxNumber);

}
