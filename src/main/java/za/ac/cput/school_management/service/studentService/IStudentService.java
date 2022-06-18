package za.ac.cput.school_management.service.studentService;

import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.service.IService;

/*
Author: Ameer Ismail
student nr: 218216033
domain: Student entity
ADP3 June assessment Group 1
 */
public interface IStudentService extends IService<Student, String>
{
    void deleteById(String id);
}
