package repository.studentRepository.impl;

/*
author: Ameer Ismail
student nr: 218216033
Repository implementation: for Student domain repo
 */


import domain.Student;
import repository.studentRepository.IStudentRepository;
import java.util.Set;

public class StudentRepositoryImpl implements IStudentRepository
{
    private static StudentRepositoryImpl repository = null;
    private Set<Student> StudentDB = null;

    private StudentRepositoryImpl getRepository()
    {
        if (repository == null)
        {
            repository = new StudentRepositoryImpl();
        }
        return this;
    }

    //crud
    // -- create
    @Override
    public Student create(Student student)
    {
        boolean created = StudentDB.add(student);
        if (!created)
        return null;

        return student;
    }

    // -- read
    @Override
    public Student read(String studentId)
    {
        Student student = StudentDB.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findAny()
                .orElse(null);
        return student;
    }

    // -- update
    @Override
    public Student update(Student student)
    {
        Student previous = read(student.getStudentId());
        if (previous != null)
        {
            StudentDB.remove(previous);
            StudentDB.add(student);
            return student;
        }
        return null;
    }

    // -- delete
    @Override
    public boolean delete(String studentId)
    {
        Student delete = read(studentId);
        if (studentId == null)
        return false;

        StudentDB.remove(delete);
        return true;
    }

    // -- get all
    @Override
    public Set<Student> getAll() {
        return StudentDB;
    }





}
