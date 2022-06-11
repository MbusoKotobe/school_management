package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.helper.Helper;

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
        Helper.checkObjectParams(city);
    }
}
