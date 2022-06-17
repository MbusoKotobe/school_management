package za.ac.cput.school_management.service.studentService;

import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.service.IService;

import java.util.List;


public interface IStudentService extends IService<Student, String>
{
    void deleteById(String id);
}
