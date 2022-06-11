package repository.studentRepository;

/*
author: Ameer Ismail
student nr: 218216033
 */

import domain.Student;
import repository.IRepository;
import java.util.Set;

public interface IStudentRepository extends IRepository<Student, String>
{
    public Set<Student> getAll();
}
