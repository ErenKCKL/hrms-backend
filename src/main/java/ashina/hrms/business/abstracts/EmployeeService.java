package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAll();

    Employee saveEmployee(Employee employee);

    void deleteById(int id);

    Optional<Employee> findById(int id);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByNationalIdentity(String nationalIdentity);

    boolean existsByEmail(String email);

    boolean existsByNationalIdentity(String nationalIdentity);

}
