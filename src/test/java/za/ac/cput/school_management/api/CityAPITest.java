package za.ac.cput.school_management.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.service.cityService.ICityService;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityAPITest {


    private final Country country = CountryFactory.build("USA", "United States Of America");
    private final City city = CityFactory.build("A12","Texas",country);

    @Autowired private ICityService cityService;
    @Autowired private CityAPI cityAPI;

    @BeforeEach
    void setUp() {
        City saved = this.cityService.save(city);
    }

    @Test
    void findCitiesByCountry() {
        List<String> citiesList =  this.cityAPI.findCitiesByCountry(country.getCountryId());
        assertAll(
                () -> assertNotNull(citiesList),
                () -> assertTrue(citiesList.size()>0)
        );

    }
}