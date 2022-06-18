/* EmployeeControllerTest.java
Test for the EmployeeController
Author: Jody Kearns (209023651)
Date: 13 June 2022 */

package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.factory.EmployeeFactory;
import za.ac.cput.school_management.factory.NameFactory;

import java.util.Arrays;

import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private EmployeeController controller;
    @Autowired private TestRestTemplate restTemplate;

    @Autowired private IEmployeeAddressService employeeAddressService;

    private Employee employee;
    private Name name;
    private String baseUrl;


    private EmployeeAddress employeeAddress;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.name = NameFactory.build("Jody", "","Kearns");
        this.employee = EmployeeFactory.build("209023651","209023651@mycput.ac.za", name);
        this.baseUrl = "http://localhost:" + this.port + "/school-management/employee/";



        //Creating/Saving Employee address in order to Test Question 6:
        Country country = CountryFactory.build("USA", "United States of America");
        City city = CityFactory.build("TX","Texas", country);
        Address address = AddressFactory.build("4395", "Bluebell Village","102","Excelsior Street","7558",city);
        this.employeeAddress = EmployeeAddressFactory.build("209023651", address);
        this.employeeAddressService.save(employeeAddress);
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate
                .postForEntity(url, this.employee, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.employee.getStaffId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(5)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.employee.getStaffId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(6)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Employee[]> response =
                this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }

    //Question 5 Test:
    @Order(3)
    @Test
    void findByEmail(){
        String url = baseUrl + "read-by-email/" + this.employee.getEmail();
        System.out.println(url);
        ResponseEntity<Name> response =
                this.restTemplate.getForEntity(url, Name.class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    //Question 6:
    @Order(4)
    @Test
    void findEmpByCity(){

        String url = baseUrl + "read-employee-name-by-city-id/" + employeeAddress.getAddress().getCity().getId();
        System.out.println(url);

        ResponseEntity<Name[]> response = this.restTemplate.getForEntity(url, Name[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertEquals(1, response.getBody())
        );
    }
}