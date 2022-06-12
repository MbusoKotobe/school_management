package za.ac.cput.school_management.factory;

/*
 * Zintle Magwaxaza (218109911)
 * CountryFactoryTest class.
 * Date: 11 June 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Country;
import static org.junit.jupiter.api.Assertions.*;


public class CountryFactoryTest {
    @Test
    public void build (){
        Country country = CountryFactory.build ("RSA","south africa");
        System.out.println(country);
        assertNotNull(country);
    }

    @Test
    public void buildWithError() {

     Exception exception = assertThrows(IllegalArgumentException.class, () -> CountryFactory
                .build(null ,"South Africa"));

    String exceptionMessage = exception.getMessage();
    System.out.println(exceptionMessage);
    assertSame(  "country ID is required!", exceptionMessage);

    }
}
