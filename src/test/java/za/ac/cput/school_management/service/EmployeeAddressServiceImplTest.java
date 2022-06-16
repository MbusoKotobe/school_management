package za.ac.cput.school_management.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.AddressFactory;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.EmployeeAddressFactory;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplTest {
    private EmployeeAddress employeeAddress = null;

    @Autowired
    private IEmployeeAddressService service;

    @BeforeEach
    void setUp()
    {
        Country country = CountryFactory.build("1CNTY1", "South Africa");
        City city = CityFactory.build("1CTY1", "Cape Town", country);
        Address address = AddressFactory.build("18", "Bluebell Village", "412", "Chumani Rd", "1818", city);

        employeeAddress = EmployeeAddressFactory.build("EMPL1", address);
    }

    @Order(1)
    @Test
    void save()
    {
        EmployeeAddress result = null;

        result = service.save(employeeAddress);

        assertEquals(employeeAddress, result);
    }

    @Order(2)
    @Test
    void read()
    {
        final Optional<EmployeeAddress> result = service.read(employeeAddress.getStaffId());

        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(employeeAddress, result.get())
        );
    }

    @Order(3)
    @Test
    void findAll()
    {
        List<EmployeeAddress> employeeAddressList = null;

        employeeAddressList = service.findAll();

        assertTrue(employeeAddressList.size() > 0);
    }
    
    @Test
    @Disabled
    void deleteById()
    {
    }

    @Order(4)
    @Test
    void delete()
    {
        List<EmployeeAddress> employeeAddressList = null;

        employeeAddressList = service.findAll();

        assertEquals(0, employeeAddressList.size());
    }
}