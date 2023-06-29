package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.CityService;
import ashina.hrms.dataAccess.abstracts.CityDao;
import ashina.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAll() {
        return cityDao.findAll();
    }

    @Override
    public City saveCity(City city) {
        return cityDao.save(city);
    }

    @Override
    public void deleteCity(City city) {
        cityDao.delete(city);
    }
}
