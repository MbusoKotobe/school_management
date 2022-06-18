package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.domain.Student;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Author: Ameer Ismail
student nr: 218216033
factory Student testing
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentFactoryTest
{

    Name name = NameFactory.build("Ameer", "AI", "Ismail");

    @Order(1)
    @Test
    public void InvalidEmail()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
             StudentFactory.build("ameer23", "invalidEmail", name));
        String exception = e.getMessage();
        System.out.println(exception);
    }

    @Order(2)
    @Test
    public void NullName()
    {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
            StudentFactory.build("ameer2344", "ameer2344@gmail.com", null));
        String eMessage = e.getMessage();
        System.out.println(eMessage);
    }

    @Order(3)
    @Test
    public void ValuesSuccess()
    {
         Student student = StudentFactory.build("Ameer786", "ameer786@gmail.com", name);
         assertNotNull(student);
         System.out.println(student);
    }

}
