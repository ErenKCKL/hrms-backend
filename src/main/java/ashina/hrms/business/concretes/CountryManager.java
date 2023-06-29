package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.CountryService;
import ashina.hrms.dataAccess.abstracts.CountryDao;
import ashina.hrms.entities.concretes.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryManager implements CountryService {


    private CountryDao countryDao;

    @Autowired
    public CountryManager(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> getAll() {
        return countryDao.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryDao.save(country);
    }
}
