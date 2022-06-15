package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.AddressFactory;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.EmployeeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mbuso Kotobe (218040385)
 * Entity for Address
 * Date: 10 June 2022
 * */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {

    @Autowired
    private EmployeeAddressController controller;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        Country country = CountryFactory.build("1CNTY1", "South Africa");
        City city = CityFactory.build("1CTY1", "Cape Town", country);
        Address address = AddressFactory.build("18", "Bluebell Village", "412", "Chumani Rd", "1818", city);
        employeeAddress = EmployeeAddressFactory.build("EMPL1", address);
        baseUrl = "http://localhost:" + portNumber + "/" + "school-management/employee-address/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseUrl + "save";
        ResponseEntity<EmployeeAddress> response = restTemplate.postForEntity(url, employeeAddress, EmployeeAddress.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseUrl + "read/" + employeeAddress.getStaffId();
        ResponseEntity<EmployeeAddress> response = restTemplate.getForEntity(url, EmployeeAddress.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = baseUrl + "find-all";
        ResponseEntity<EmployeeAddress[]> response = restTemplate.getForEntity(url, EmployeeAddress[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length > 0)
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = baseUrl + "delete";
        restTemplate.delete(url, employeeAddress, EmployeeAddress.class);
    }

    @Test
    @Order(4)
    void deleteById()
    {
        String url = baseUrl + "delete-by-id/" + employeeAddress.getStaffId();
        ResponseEntity<EmployeeAddress> response = restTemplate.getForEntity(url, EmployeeAddress.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
    }
}