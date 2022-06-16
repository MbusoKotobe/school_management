/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.service.employeeService.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.repository.ICityRepository;
import za.ac.cput.school_management.service.employeeService.ICityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService {

    private final ICityRepository repository;

    @Autowired
    public CityServiceImpl (ICityRepository repository) {
        this.repository = repository;
    }

    public City save(City city) {

        return this.repository.save(city);
    }

        public Optional<City> read(String id){

        return this.repository.read(id);
        }

        public void delete(City city){

        this.repository.delete(city);
        }
        public List<City> findAll (){

        return this.repository.findAll();
        }
        public void deleteById (String id){
        repository.deleteById(id);
        Optional<City> city = read(id);
        if (city.isPresent()){
            delete(city.get());
        }

    }
}

