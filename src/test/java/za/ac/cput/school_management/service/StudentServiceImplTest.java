package za.ac.cput.school_management.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.factory.NameFactory;
import za.ac.cput.school_management.factory.StudentFactory;
import za.ac.cput.school_management.service.studentService.IStudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest
{
        Name name = NameFactory.build("Ameer", "", "Ismail");
        Student student = StudentFactory.build("Ameer123", "Ameer@gmail.com", name);


    @Autowired private IStudentService s;

    @Order(1)
    @Test
    void save()
    {
        Student created = this.s.save(this.student);
        System.out.println(created);
    }

    @Order(2)
    @Test
    void read()
    {
        Optional<Student> read = this.s.read(student.getStudentId());
        assertAll(
                () -> assertTrue(read.isPresent()), () -> assertEquals(this.student, read.get())
        );
        System.out.println(read);
    }

    @Order(3)
    @Test
    void findAll()
    {
        List<Student> listStudents = this.s.findAll();
        assertEquals(1, listStudents.size());
        System.out.println(listStudents);
    }

    @Order(4)
    @Test
    void delete()
    {
        this.s.deleteById(this.student.getStudentId());
        List<Student> ListStudent = this.s.findAll();
       assertEquals(0, ListStudent.size());
    }
}