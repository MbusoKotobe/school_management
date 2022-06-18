/* EmployeeFactoryTest.java
Test for the EmployeeFactory
Author: Jody Kearns (209023651)
Date: 11 June 2022 */

package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.Name;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    Name name = NameFactory.build("Jody","Reagan","Kearns");

    @Test
    @Order(1)
    public void buildWithNullName(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.build("209023651","209023651@mycput.ac.za",null));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    @Order(2)
    public void buildWithInvalidEmail(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.build("209023651","loremIpsum",name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    @Order(3)
    public void buildWithEmptyStaffId(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                EmployeeFactory.build("","209023651@mycput.ac.za",name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }

    @Test
    @Order(4)
    public void buildWithSuccess(){
        Employee employee = EmployeeFactory.build("209023651", "209023651@mycput.ac.za",name);
        assertNotNull(employee);
        System.out.println(employee);
    }
}