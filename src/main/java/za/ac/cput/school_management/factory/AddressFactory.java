package za.ac.cput.school_management.factory;

import lombok.extern.slf4j.Slf4j;
import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.helper.Helper;

import java.lang.reflect.Field;


/**
 * @author Mbuso Kotobe (218040385)
 * Entity for Address
 * Date: 10 June 2022
 * */
@Slf4j
public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode, City city) throws IllegalArgumentException
    {
        unitNumber = Helper.setEmptyIfNull(unitNumber);
        complexName = Helper.setEmptyIfNull(complexName);
        validateAttributes(streetNumber, streetName, postalCode, city);
        return new Address.Builder().setUnitNumber(unitNumber)
                                    .setComplexName(complexName)
                                    .setStreetNumber(streetNumber)
                                    .setStreetName(streetName)
                                    .setPostalCode(postalCode)
                                    .setCity(city).build();
    }

    private static void validateAttributes(String streetNumber, String streetName, String postalCode, City city) throws IllegalArgumentException
    {
        Helper.checkStringParam("streetNumber", streetNumber);
        Helper.checkStringParam("streetName", streetName);
        Helper.checkStringParam("postalCode", postalCode);
        validatePostalCode(postalCode);
        Helper.checkIfObjectNull("city", city);
    }

    private static void validatePostalCode(String postalCode) throws IllegalArgumentException
    {
        checkPostalCodeLength(postalCode);
        checkNonDigitCharacters(postalCode);
    }

    private static void checkPostalCodeLength(String postalCode) throws IllegalArgumentException
    {
        if(postalCode.length() != 4)
            throw new IllegalArgumentException("Invalid postal code length");
    }

    private static void checkNonDigitCharacters(String postalCode) throws IllegalArgumentException
    {
        int count = 0;
        for (int i = 0; i < postalCode.length(); i++)
        {
            if(!Character.isDigit(postalCode.charAt(i)))
                ++count;
        }

        if(count > 0)
            throw new IllegalArgumentException("Invalid postal code, " + "'" + getFieldName() + "'" + " contains: " + count + " invalid characters");
    }

    private static String getFieldName()
    {
        try{
            Field field = Address.class.getDeclaredField("postalCode");
            return field.getName();
        }
        catch(Exception e)
        {
            log.info("getFieldName procedure: {}", e);
        }
        return "";
    }
}
