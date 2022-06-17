package za.ac.cput.school_management.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.service.cityService.ICityService;
import za.ac.cput.school_management.service.countryService.ICountryService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Component
public class CityAPI {

    private final ICountryService countryService;
    private final ICityService cityService;

    @Autowired
    public CityAPI(ICountryService countryService, ICityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    //Question 7:
    public List<String> findCitiesByCountry(String countryId) {
        try {
            Country country = this.countryService.read(countryId).get();
            List<City> foundCities = this.cityService.findCitiesByCountry(country);
            if(foundCities != null && foundCities.size() > 0){
                List<String> cityNameList = new ArrayList<>();
                foundCities.forEach(city -> cityNameList.add(city.getName()));
                Collections.sort(cityNameList);
                return cityNameList;
            }
        }catch (NoSuchElementException e){
            return null;
        }
        return null;
    }
}
