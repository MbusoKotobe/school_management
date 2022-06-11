package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Contains;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.Name;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @BeforeEach
    void setUp()
    { }

    @AfterEach
    void tearDown()
    { }

    @Test
    public void createAddressTest()
    {
        Country country = CountryFactory.createCountry("1CNTY1", "South Africa");
        City city = CityFactory.createCity("1CTY1", "Cape Town", country);

        var results = assertThrows(AssertionError.class, () -> AddressFactory.createAddress("18", null, "412", null, "1818", city));
        var resultsTwo = assertThrows(AssertionError.class, () -> AddressFactory.createAddress("", "Bluebell Village", "412", "Chumani Rd", "1818", city));
        var resultsThree = assertThrows(AssertionError.class, () -> AddressFactory.createAddress("", "Bluebell Village", "412", "Chumani Rd", "1818", null));

        assertThat(results.getMessage(), containsString("Invalid value for:"));
        assertThat(resultsTwo.getMessage(), containsString("Invalid value for:"));
        assertThat(resultsThree.getMessage(), containsString("Invalid value for:"));
        assertDoesNotThrow(() -> AddressFactory.createAddress(
            "18", "Bluebell Village", "412", "Chumani Rd", "1818",
            city
        ));
    }

}