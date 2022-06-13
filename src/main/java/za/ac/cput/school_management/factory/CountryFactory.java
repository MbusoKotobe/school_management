package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.helper.Helper;

/*
 * Zintle Magwaxaza (218109911)
 * CountryFactory.java
 * Date: 10 June 2022
 */


public class CountryFactory {
    public static Country build (String countryId, String countryName)
    {
        Helper.checkStringParam("countryId",countryId);
        Helper.checkStringParam("countryName", countryName);
        return new Country.Builder().setCountryId(countryId).setCountryName (countryName).build();
    }

}
