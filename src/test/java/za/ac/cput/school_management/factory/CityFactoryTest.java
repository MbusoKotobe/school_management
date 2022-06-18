/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    void createCity(){
        City cityCreated = CityFactory.build("012345","Cape Town", CountryFactory.build( "South African","Namibia"));

        assertAll(
                ()-> assertFalse(cityCreated.getName().isEmpty()),
                ()-> assertFalse(cityCreated.getId().isEmpty()),
                ()-> assertNotNull(cityCreated.getCountry())
        );
        City city = CityFactory.build("012345","Cape Town", CountryFactory.build("1CNTY1","South Africa"));
        assertNotNull(cityCreated);
        System.out.println(cityCreated);


    }

    @Test
    public void completedValues(){
        City city = CityFactory.build("012345","Mpumalanga",CountryFactory.build("South African","South America"));
        System.out.println(city);
        assertNotNull(city);
    }
}