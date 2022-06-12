/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 11 June 2022
 */
package za.ac.cput.school_management.factory;

import domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.helper.Helper;

public class CityFactory {


    public static City createCity(String  id, String name, Country country){

        Helper.checkStringParam("id",id);
        Helper.checkStringParam("name",name);
        Helper.checkStringParam("Country",country);

        return new City.Builder().setId(id)
                .setName(name)
                .setCountry(country)
                .build();

    }
}
