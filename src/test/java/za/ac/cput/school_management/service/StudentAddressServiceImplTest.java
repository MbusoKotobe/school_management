package za.ac.cput.school_management.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.City;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.factory.AddressFactory;
import za.ac.cput.school_management.factory.CityFactory;
import za.ac.cput.school_management.factory.CountryFactory;
import za.ac.cput.school_management.factory.StudentAddressFactory;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.service.studentAddressService.IStudentAddressService;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {

        private final Country country = CountryFactory.build("01", "gh");
        private final City city = CityFactory.build("01", "gh", country);
        private final Address address = AddressFactory.build("20",
                "one","02", "TWO","1234", city);
        private final StudentAddress studentAddress = StudentAddressFactory.build("22", address);

    @Autowired
    private IStudentAddressService studentAddressService;

    @Order(1)
    @Test
    void save(){
        StudentAddress saved = this.studentAddressService.save(this.studentAddress);
        assertEquals(this.studentAddress, saved);
        System.out.println(saved);
    }
    @Order(2)
    @Test
    void read(){
        Optional<StudentAddress> read = this.studentAddressService.read(this.studentAddress.getStudentId());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.studentAddress,read.get())
        );
    }
    @Order(3)
    @Test
    void findAll(){
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(1,studentAddressList.size());
    }
    @Order(4)
    @Test
    void delete(){
        this.studentAddressService.deleteById(this.studentAddress.getStudentId());
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(0,studentAddressList.size());
    }
}