/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CityFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ICityRepositoryTest {
   // @SpringBootTest
   // @TestMethodOrder(MethodOrderer.OrderAnnotation)
    private final City city = CityFactory.createCity(012345,"Cape Town", Country"South Africa");

 @Autowired private ICityRepository repository;

 @Order(1)
    @Test
    void save(){
     City saved = this.repository.save(this.city);
     assertEquals(this.city, saved);
 }
 @Order(2)
    @Test
    void read() {
     Optional<City> read = this.repository.findById(this.city.getId());
     // Optional<City> readIt = this.repository.findById(this.city.getName());
     assertAll(
             () -> assertTrue(read.isPresent()),
             // ()->assertTrue(readIt.isPresent())
             () -> assertEquals(this.city, read.get())


     );
 }
     @Order(3)
     @Test
     void delete(){
         this.repository.delete(this.city);
         List<City> cityList = this.repository.findAll();
         assertEquals(0,cityList.size());
     }

    @Order(4)
    @Test
    void findAll(){
         List<City> employeeList = this.repository.findAll();
         assertEquals(1,employeeList.size());
     }

 }

}