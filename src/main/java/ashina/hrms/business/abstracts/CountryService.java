package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country saveCountry(Country country);

}
