package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.studentService.IStudentService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressController controller;
    @Autowired private TestRestTemplate restTemplate;

    @Autowired private IStudentService studentService;
    private StudentAddress studentAddress;
    private Address address;
    private String baseUrl;

    private Student student;
    private Name name;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        Country country = CountryFactory.build("01", "gh");
        City city = CityFactory.build("01", "gh", country);
        this.address = AddressFactory.build("20",
                "one","02", "TWO","1005", city);
        this.studentAddress = StudentAddressFactory.build("22", address);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/student-address/";

        //Creating and saving a student to run test for Question 8:
        this.name = NameFactory.build("Ameer", "", "Ismail");
        this.student = StudentFactory.build("ameer567", "ameer567@gmail.com", name);
        this.studentService.save(student);

    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.studentAddress.getStudentId();
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(url, StudentAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.studentAddress.getStudentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(5)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<StudentAddress[]> response =
                this.restTemplate.getForEntity(url, StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }

//    Question 8:
    @Order(3)
    @Test
    void findStudentsInCountry(){
        String url = baseUrl + "read-last-name-by-country-id/" + studentAddress.getAddress().getCity().getCountry().getCountryId();
        System.out.println(url);
        ResponseEntity<String[]> response = this.restTemplate.getForEntity(url, String[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}