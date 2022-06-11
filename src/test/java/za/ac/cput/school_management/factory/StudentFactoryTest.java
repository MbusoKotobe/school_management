package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Student;
import static org.junit.jupiter.api.Assertions.*;

/*
student nr: 218216033
factory Student testing
 */

class StudentFactoryTest
{
    @Test
    void createStudent()
    {

        Student student = StudentFactory.createStudent("CPUTd6a", "cput@gmail.com",  );
        assertNotNull(student);
        System.out.println(student);
    }

}