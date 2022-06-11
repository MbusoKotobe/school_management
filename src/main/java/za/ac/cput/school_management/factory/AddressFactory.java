package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.helper.Helper;

import java.lang.reflect.Field;

public class AddressFactory {
    public static Address createAddress(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode, City city) throws IllegalArgumentException
    {
        validateAttributes(unitNumber, complexName, streetNumber, streetName, postalCode, city);
        return new Address.Builder().setUnitNumber(unitNumber)
                                    .setComplexName(complexName)
                                    .setStreetNumber(streetNumber)
                                    .setStreetName(streetName)
                                    .setpostalCode(postalCode)
                                    .setCity(city).build();
    }

    private static void validateAttributes(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode, City city) throws IllegalArgumentException
    {
        Helper.checkStringParam("unitNumber", unitNumber);
        Helper.checkStringParam("complexName", complexName);
        Helper.checkStringParam("streetNumber", streetNumber);
        Helper.checkStringParam("streetName", streetName);
        Helper.checkStringParam("postalCode", postalCode);
        validatePostalCode(postalCode);
        Helper.checkIfObjectIsNull(city);
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
            //TODO: Must log error properly.
            System.out.println(e.getMessage());
        }
        return "";
    }
}
