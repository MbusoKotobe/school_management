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

import za.ac.cput.school_management.service.CityServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("School_Management")
@Slf4j
public class CityController {

    public CityServiceImpl cityServiceImpl;


    @Autowired
    public CityController(CityServiceImpl cityServiceImpl){
        this.cityServiceImpl = cityServiceImpl;
    }
    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city){
        log.info("save request: {}",city);
        City save = cityServiceImpl.save(city); // should be city here
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<City> read (@PathVariable String id){
        log.info("read request: {}",id);
        City addressType = this.cityServiceImpl.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(addressType);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("read request:{}",id);
        this.cityServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<City>> findAll(){
        List<City> city = (List<City>) this.cityServiceImpl.findAll();
        return ResponseEntity.ok(city);
    }
}
