package za.ac.cput.school_management.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;
import za.ac.cput.school_management.service.employeeService.IEmployeeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeAPITest {


    private final Country country = CountryFactory.build("1CNTY1", "South Africa");
    private final City city = CityFactory.build("1CTY1", "Cape Town", country);
    private final Address address = AddressFactory.build("18", "Bluebell Village", "412", "Chumani Rd", "1818", city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("EMPL1", address);
    private final Name name = NameFactory.build("Jody", "Lester", "Kearns");
    private final Employee employee = EmployeeFactory.build("EMPL1","jody@gmail.com",name);

    @Autowired
    private IEmployeeAddressService employeeAddressService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private EmployeeAPI employeeAPI;

    @BeforeEach
    void setUp() {
        this.employeeAddressService.save(employeeAddress);
        this.employeeService.save(employee);
    }

    @Test
    void findEmployeesInCity() {
        List<Name> employeesList =  this.employeeAPI.findEmployeesInCity(employeeAddress.getAddress().getCity().getId());
        assertAll(
                () -> assertNotNull(employeesList),
                () -> assertTrue(employeesList.size()>0)
        );
    }
}