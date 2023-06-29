package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Optional<Employee> findById(int id);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByNationalIdentity(String nationalIdentity);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentity(String nationalIdentity);

}
