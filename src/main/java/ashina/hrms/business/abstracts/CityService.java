package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    List<City> getAll();

    City saveCity(City city);

    void deleteCity(City city);

}
