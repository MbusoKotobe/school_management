package za.ac.cput.school_management.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.studentAddressService.IStudentAddressService;
import za.ac.cput.school_management.service.studentService.IStudentService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentAPITest {

    private final Name name = NameFactory.build("Ameer", "", "Ismail");
    private final Student student = StudentFactory.build("Ameer123", "Ameer@gmail.com", name);


    private final Country country = CountryFactory.build("01", "gh");
    private final City city = CityFactory.build("01", "gh", country);
    private final Address address = AddressFactory.build("20", "one","02",
            "TWO","1234", city);
    private final StudentAddress studentAddress = StudentAddressFactory.build("Ameer123", address);

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IStudentAddressService studentAddressService;

    @Autowired
    private StudentAPI studentAPI;

    @BeforeEach
    void setUp() {
        this.studentAddressService.save(studentAddress);
        this.studentService.save(student);
    }

    @Test
    void findStudentsInCountry() {
        List<String> studentsList = this.studentAPI.findStudentsInCountry(studentAddress.getAddress().
                getCity().getCountry().getCountryId());
        assertAll(
                () -> assertNotNull(studentsList),
                () -> assertTrue(studentsList.size()>0)
        );
    }
}