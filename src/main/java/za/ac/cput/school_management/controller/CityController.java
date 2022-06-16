/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.City;

import za.ac.cput.school_management.factory.CityFactory;

import za.ac.cput.school_management.service.employeeService.ICityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("School_Management/city/")
@Slf4j
public class CityController {

    private final ICityService cityServiceImpl;


    @Autowired
    public CityController(ICityService cityServiceImpl){
        this.cityServiceImpl = cityServiceImpl;
    }
    @PostMapping("save")
    public ResponseEntity<City> save(@RequestBody City city){
        log.info("save request: {}",city);
        City valideCity;
        try {
            valideCity = CityFactory.createCity(city.getName(),city.getId(),city.getCountry());

        }catch (IllegalArgumentException e){
            log.info("Request for errors:{}",e.getMessage());
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST);
        }
        City save = cityServiceImpl.save((valideCity));
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<City> read (@PathVariable String id){
        log.info("Read request: {}",id);
        City city = this.cityServiceImpl.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("delete request{}",id);
        this.cityServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<City>>findAll(){
        List<City> cityList =this.cityServiceImpl.findAll();
        return ResponseEntity.ok(cityList);
    }
}
