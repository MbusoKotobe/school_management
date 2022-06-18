/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.service.cityService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.repository.ICityRepository;
import za.ac.cput.school_management.service.cityService.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    private final ICityRepository repository;

    @Autowired
    public CityServiceImpl(ICityRepository repository) {
        this.repository = repository;
    }

    public City save(City city) {

        return this.repository.save(city);
    }

    public Optional<City> read(String id) {

        return this.repository.findById(id);
    }

    public void delete(City city) {

        this.repository.delete(city);
    }

    public List<City> findAll() {

        return this.repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<City> city = read(id);
        if (city.isPresent()) {
            delete(city.get());
        }

    }
    @Override
    public List<City> findCitiesByCountry(Country country) {
        try {
            return this.repository.findCitiesByCountry(country);
        }catch (Exception e){
            System.out.println("************************************************");
            System.out.println(e);
        }
        return  null;
    }
}
