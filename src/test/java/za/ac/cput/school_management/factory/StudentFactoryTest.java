package za.ac.cput.school_management.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.domain.Student;
import static org.junit.jupiter.api.Assertions.*;

/*
Author: Ameer Ismail
student nr: 218216033
factory Student testing
 */

class StudentFactoryTest
{
    @Test
    void createStudent()
    {

        Name name = NameFactory.createName("Will", "Thomas", "Smith");
        Student student = StudentFactory.createStudent("Smith765", "smithw@gmail.com", name);

        Name name2 = NameFactory.createName("Jack", "Peter", "phillips");
        Student student2 = StudentFactory.createStudent("Phillips132","phillipsj@gmail.com", name2);

        assertNotNull(student);
        assertNotNull(student2);

        System.out.println(student);
        System.out.println(student2);
    }

}