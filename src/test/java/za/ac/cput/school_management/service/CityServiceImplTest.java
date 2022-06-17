/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.service.cityService.impl.CityServiceImpl;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {

    private final Country country = CountryFactory.build("RSA","SOUTH AFRICA");
    private final City city = CityFactory.build("012345","Durban", country);
    @Autowired
    public CityServiceImpl iCityService;

    @Order(1)
    @Test
    void save(){
        City saved = this.iCityService.save(this.city);
        assertEquals(this.city,saved);
        System.out.println(saved);

    }

    @Order(2)
    @Test
    void read(){
        Optional<City> read = this.iCityService.read(city.getId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.city,read.get())
        );
        System.out.println(read);
    }

    @Order(4)
    @Test
    void delete(){
        this.iCityService.delete(this.city);
        List<City> cityList = this.iCityService.findAll();
        assertEquals(0,cityList.size());
        System.out.println(iCityService);
    }

    @Order(3)
    @Test
    void findAll(){
        List<City> cityList = this.iCityService.findAll();
        assertEquals(1, cityList.size());
        System.out.println(cityList);
    }

}