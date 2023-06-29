package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.CityService;
import ashina.hrms.business.abstracts.CountryService;
import ashina.hrms.entities.concretes.City;
import ashina.hrms.entities.concretes.Country;
import ashina.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private CountryService countryService;
    private CityService cityService;

    @Autowired
    public CountryController(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Country>> getAll(){
        List<Country> countries = countryService.getAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

}
