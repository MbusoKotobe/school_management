package za.ac.cput.school_management.service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.studentAddressService.IStudentAddressService;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class StudentAddressServiceImplTest {

        private final Country country = CountryFactory.build("01", "gh");
        private final City city = CityFactory.build("01", "gh", country);
        private final Address address = AddressFactory.build("20",
                "one","02", "TWO","00", city);
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