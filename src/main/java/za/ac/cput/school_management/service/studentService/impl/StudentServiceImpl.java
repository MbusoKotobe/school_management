package za.ac.cput.school_management.service.studentService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.repository.IStudentRepository;
import za.ac.cput.school_management.service.studentService.IStudentService;
import java.util.*;

/*
Author: Ameer Ismail
student nr: 218216033
Service: Student Service
ADP3 June assessment Group 1
 */

@Service
public class StudentServiceImpl implements IStudentService
{

    private final IStudentRepository repo;

    @Autowired
    public StudentServiceImpl(IStudentRepository repo)
    {
        this.repo = repo;
    }

    //creating a student
    @Override
    public Student save(Student student)
    {
        return this.repo.save(student);
    }

    //reading
    @Override
    public Optional<Student> read(String id)
    {
        return this.repo.findById(id);
    }

    //deleting a student from the record or database
    @Override
    public void delete(Student s)
    {
        this.repo.delete(s);
    }

    // get and list all the students
    @Override
    public List<Student> findAll()
    {
        return this.repo.findAll();
    }


    public void deleteById(String id)
    {
        repo.deleteById(id);
        Optional<Student> student = read(id);
        if (student.isPresent())
        {
            delete(student.get());
        }
    }
}

