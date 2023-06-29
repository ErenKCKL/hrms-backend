package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.EmployerService;
import ashina.hrms.dataAccess.abstracts.EmployerDao;
import ashina.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }

    @Override
    public Employer saveEmployer(Employer employer) {
        return employerDao.save(employer);
    }

    @Override
    public void deleteById(int id) {
        employerDao.deleteById(id);
    }

    @Override
    public Optional<Employer> findById(int id) {
        return employerDao.findById(id);
    }

    @Override
    public Optional<Employer> findByEmail(String email) {
        return employerDao.findByEmail(email);
    }

    @Override
    public Optional<Employer> findByTaxNumber(String taxNumber) {
        return employerDao.findByTaxNumber(taxNumber);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employerDao.existsByEmail(email);
    }

    @Override
    public boolean existsByTaxNumber(String taxNumber) {
        return employerDao.existsByTaxNumber(taxNumber);
    }
}
