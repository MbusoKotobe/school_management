/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import domain.City;

public class CityFactory {
    public static City createCity(String  id, String name, Country country){
        City cit = new City.Builder().setId(id)
                .setName(name)
                .setCountry(country)
                .build();
        return cit;
    }
}
