package za.ac.cput.school_management.service;
/*
 * Zintle Magwaxaza (218109911)
 * CountryServiceImplTest
 * Date: 14 June 2022
 */

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
import za.ac.cput.school_management.service.countryService.ICountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {

    Country country = CountryFactory.build("RSA","South Africa");
    City city = CityFactory.build("CPT","CAPE TOWN", country);

    @Autowired
    private ICountryService countryService;

    @Order(1)
    @Test
    void save()
    {
        Country saved = this.countryService.save(this.country);
        assertEquals(this.country, saved);
        System.out.println(saved);
    }
    @Order(2)
    @Test
    void read (){
        Optional<Country> read = this.countryService.read(country.getCountryId());
          System.out.println(read);
            assertAll(
                    ()-> assertTrue(read.isPresent()),
                    () -> assertSame(this.country, read.get())
            );
        }
        @Order(3)
        @Test
       void findAll (){
            List<Country> countryList = this.countryService.findAll();
            System.out.println(countryList);
            assertEquals(1,countryList.size());
        }
    @Order(4)
    @Test
    void delete(){
        this.countryService.delete(this.country);
        List<Country> countryList = this.countryService.findAll();
        assertEquals(0,countryList.size());
    }
}



