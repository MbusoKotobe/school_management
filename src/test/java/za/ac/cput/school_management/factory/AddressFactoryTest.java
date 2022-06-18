package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * @author Mbuso Kotobe (218040385)
 * Entity for Address
 * Date: 10 June 2022
 * */
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
        Country country = CountryFactory.build("1CNTY1", "South Africa");
        City city = CityFactory.build("1CTY1", "Cape Town", country);

        var results = assertThrows(IllegalArgumentException.class, () -> AddressFactory.build("18", null, "412", null, "1818", city));
        var resultsTwo = assertThrows(IllegalArgumentException.class, () -> AddressFactory.build("", "Bluebell Village", "412", "Chumani Rd", "1818", city));
        var resultsThree = assertThrows(IllegalArgumentException.class, () -> AddressFactory.build("", "Bluebell Village", "412", "Chumani Rd", "1818", null));

        assertThat(results.getMessage(), containsString("Invalid value for:"));
        assertThat(resultsTwo.getMessage(), containsString("Invalid value for:"));
        assertThat(resultsThree.getMessage(), containsString("Invalid value for:"));
        assertDoesNotThrow(() -> AddressFactory.build(
            "18", "Bluebell Village", "412", "Chumani Rd", "1818",
            city
        ));
    }

}