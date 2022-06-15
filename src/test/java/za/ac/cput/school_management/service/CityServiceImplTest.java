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
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.factory.CityFactory;
//import za.ac.cput.school_management.factory.NameFactory;
import za.ac.cput.school_management.service.employeeService.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {

    //private final Name name = NameFactory.build("Elvis","Ndlangamandla","Elvovo");
    private final City city = CityFactory.createCity("012345","Nelspruit","South African");

    @Autowired public ICityService iCityService;

    @Order(1)
    @Test
    void save(){
        City saved = this.iCityService.save(this.city);
        assertEquals(this.city,saved);

    }
    @Order(2)
    @Test
    void read(){
        Optional<City> read = this.iCityService.findAll();
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.city,read.get())
        );
    }
    @Order(4)
    @Test
    void delete(){
        this.iCityService.delete(this.city);
        List<City> cityList = this.iCityService.findAll();
        assertEquals(0,cityList.size());
    }
    @Order(3)
    @Test
    void findAll(){
        List<City> cityList = this.iCityService.findAll();
        assertEquals(1, cityList.size());
    }

}