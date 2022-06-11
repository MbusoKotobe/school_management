package factory;

/*
author: Ameer Ismail
student nr: 218216033
domain class: Student.java
 */

import domain.Student;

public class StudentFactory
{
    public static Student createStudent(String studentId, String email)
    {
        Student student = new Student.Builder()
                .setStudentId(studentId)
                .setEmail(email)
                .build();
        return student;
    }
}
