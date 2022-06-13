/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import domain.City;

public class CityFactory {
       public static City build(String id, String name, Country country){
            Helper.checkStringParam("id", id);
            Helper.checkStringParam("name", name);
            Helper.checkIfObjectNull("country", country);

            return new City.Builder().setId(id)
                                     .setName(name)
                                     .setCountry(country)
                                     .build();
    }
}
