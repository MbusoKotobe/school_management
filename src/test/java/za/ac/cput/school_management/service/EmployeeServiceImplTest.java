/* EmployeeServiceImplTest.java
Test for the EmployeeServiceImpl
Author: Jody Kearns (209023651)
Date: 13 June 2022 */

package za.ac.cput.school_management.service;

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
import za.ac.cput.school_management.service.employeeService.IEmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    private final Name name = NameFactory.build("Jody", "Middle","Kearns");
    private final Employee employee = EmployeeFactory.build("209023651","209023651@mycput.ac.za", name);

    @Autowired private IEmployeeService employeeService;

    @Order(1)
    @Test
    void save(){
        Employee saved = this.employeeService.save(this.employee);
        assertEquals(this.employee, saved);
        System.out.println(saved);
    }

    @Order(2)
    @Test
    void read(){
        Optional<Employee> read = this.employeeService.read(this.employee.getStaffId());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.employee,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll(){
        List<Employee> employeeList = this.employeeService.findAll();
        assertEquals(1,employeeList.size());
    }

    @Order(4)
    @Test
    void delete(){
        this.employeeService.deleteById(this.employee.getStaffId());
        List<Employee> employeeList = this.employeeService.findAll();
        assertEquals(0,employeeList.size());
    }
}