/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CityController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private City city;


    private  String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        Country country = CountryFactory.build("01", "South Africa");
        City city = CityFactory
            .build("012345", "Cape Town",country);
        this.baseUrl = "http://localhost:" + this.port+"/schoolmanagement/city/";

    }
    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.printf(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city, City.class);
        System.out.println(response);
        assertAll(
                () ->assertEquals(HttpStatus.OK, response.getStatusCode()),
                () ->assertNotNull(response.getBody())
        );
    }
    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.city.getId();
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate.getForEntity(url,City.class);
        System.out.println(response);
        assertAll(
                () ->assertEquals(HttpStatus.OK, response.getStatusCode()),
        () ->assertNotNull(response.getBody())
        );
    }
    @Order(3)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.city.getId();
        this.restTemplate.delete(url);
    }
    @Order(4)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<City[]>response = this.restTemplate.getForEntity(url, City[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)

        );
        System.out.println(baseUrl);
    }
}