/* IEmployeeRepositoryTest.java
Test for the IEmployeeRepository
Author: Jody Kearns (209023651)
Date: 12 June 2022 */

package za.ac.cput.school_management.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.factory.EmployeeFactory;
import za.ac.cput.school_management.factory.NameFactory;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IEmployeeRepositoryTest {
    private final Name name = NameFactory.build("Jody", "","Kearns");
    private final Employee employee = EmployeeFactory.build("209023651","209023651@mycput.ac.za", name);

    @Autowired private IEmployeeRepository repository;

    @Order(1)
    @Test
    void save(){
        Employee saved = this.repository.save(this.employee);
        assertEquals(this.employee, saved);
    }

    @Order(2)
    @Test
    void read(){
        Optional<Employee> read = this.repository.findById(this.employee.getStaffId());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.employee,read.get())
        );
    }

    @Order(4)
    @Test
    void delete(){
        this.repository.delete(this.employee);
        List<Employee> employeeList = this.repository.findAll();
        assertEquals(0,employeeList.size());
    }

    @Order(3)
    @Test
    void findAll(){
        List<Employee> employeeList = this.repository.findAll();
        assertEquals(1,employeeList.size());
    }
}