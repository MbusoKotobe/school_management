/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import domain.City;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    @Test
    void createCity(){
        City cityCreated = CityFactory.createCity("012345","Cape Town",SouthAfrican);
        assertNotNull(cityCreated);
        System.out.println(cityCreated);
    }

}