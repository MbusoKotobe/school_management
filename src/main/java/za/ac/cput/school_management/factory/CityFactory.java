/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.helper.Helper;

public class CityFactory {

    public static City build(String  id, String name, Country country)throws IllegalArgumentException{
        Helper.checkStringParam("id",id);
        Helper.checkStringParam("name",name);
        Helper.checkIfObjectNull("Country",country);
        return new City.Builder().setId(id)
                .setName(name)
                .setCountry(country)
                .build();
    }
}