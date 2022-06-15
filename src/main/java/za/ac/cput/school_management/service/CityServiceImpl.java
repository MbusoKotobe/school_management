/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.service;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.repository.ICityRepository;
import za.ac.cput.school_management.service.employeeService.ICityService;

import java.util.List;
import java.util.Optional;


public class CityServiceImpl implements ICityService {

    private final ICityRepository repository;
    private static ICityService SERVICE;

    public CityServiceImpl(ICityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }
       @Override
        public Optional<City> read(String s){
            return this.repository.findById(s);
        }
        @Override
        public void delete(City city){
            this.repository.delete(city);
        }
        public List<City> findAll (){
            return this.repository.findAll();
        }
    }

