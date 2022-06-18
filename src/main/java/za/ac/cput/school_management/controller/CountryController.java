package za.ac.cput.school_management.controller;
/*
 * Zintle Magwaxaza (218109911)
 * CountryController.java
 * Date: 14 June 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.service.countryService.ICountryService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("school-management/country/")
@Slf4j
public class CountryController{
    private final ICountryService countryService;

    @Autowired
public CountryController(ICountryService countryService){
    this.countryService = countryService;
}

    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        log.info("Save request: {}", country );
         Country save = null;
         try{
             Country validatedCountry = CountryFactory.build(country.getCountryId(), country.getCountryName());
             save = countryService.save(validatedCountry);
         }catch(IllegalArgumentException exception)
         {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
         }
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        log.info("Read request: {}", id);
       Country country = this.countryService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }
    @DeleteMapping("delete/{country}")
    public ResponseEntity<Void> delete(@PathVariable String country) {
        log.info("Delete request{}", country);
        this.countryService.deleteById(country);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> countryList = this.countryService.findAll();
        return ResponseEntity.ok(countryList);
    }

}




