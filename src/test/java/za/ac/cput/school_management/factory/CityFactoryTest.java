/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    @Test
    void createCity(){
        City cityCreated = CityFactory.createCity("012345","Cape Town", Country "South African");

        assertAll(
                ()-> assertTrue(cityCreated.getName().isEmpty()),
                ()-> assertTrue(cityCreated.getId().isEmpty()),
                ()-> assertTrue(cityCreated.getCountry(),
        ));
        City cityCreated = CityFactory.build("012345","Cape Town", CountryFactory.build("1CNTY1","South Africa"));
        assertNotNull(cityCreated);
        System.out.println(cityCreated);


    }
@Test
    public void completedValues(){
        City city = CityFactory.createCity("012345","Mpumalanga",Country"South African");
    System.out.println(createCity();
        assertNotNull(createCity();
}
}