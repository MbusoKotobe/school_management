package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest {

    @Test
    void buildWithSuccess() throws IllegalArgumentException{
        Country country = CountryFactory.build("gsd1", "South Africa");
        City city = CityFactory.build("cty", "Cape Town", country);
        Address address = AddressFactory.build("201","Johns", "48", "Label Street", "1241", city);

        StudentAddress studentAddress = StudentAddressFactory
                .build("fghj", address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    void buildWithError() {
        Country country = CountryFactory.build("gsd1", "South Africa");
        City city = CityFactory.build("cty", "Cape Town", country);
        Address address = AddressFactory.build("201","Johns", "48", "Label Street", "1241", city);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory
                        .build(null, address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student id is required!", exceptionMessage);
    }
}
