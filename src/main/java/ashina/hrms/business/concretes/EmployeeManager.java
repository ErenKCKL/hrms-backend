package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.EmployeeService;
import ashina.hrms.dataAccess.abstracts.EmployeeDao;
import ashina.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return employeeDao.findByEmail(email);
    }

    @Override
    public Optional<Employee> findByNationalIdentity(String nationalIdentity) {
        return employeeDao.findByNationalIdentity(nationalIdentity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employeeDao.existsByEmail(email);
    }

    @Override
    public boolean existsByNationalIdentity(String nationalIdentity) {
        return employeeDao.existsByNationalIdentity(nationalIdentity);
    }
}
