package za.ac.cput.school_management.domain;


/*
Author: Ameer Ismail
student nr: 218216033
domain: Student entity
ADP3 June assessment Group 1
 */

public class Student
{
    private String studentId;
    private String email;
    private Name name;

    protected Student()
    {}

    //pattern
    private Student(Builder builder)
    {
        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = builder.name;
    }

    //getters
    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }


    public Name getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student Id ='" + studentId + '\'' +
                ", email ='" + email + '\'' +
                ", name =" + name +
                '}';
    }

    // builder class
    public static class Builder
    {
        private String studentId;
        private String email;
        private Name name;


    // builder setters
    public Builder setStudentId(String studentId)
    {
        this.studentId = studentId;
        return this;
    }

    public Builder setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public Builder setName(Name name)
    {
        this.name = name;
        return this;
    }

    public Builder copy(Student student)
    {
        this.studentId = student.studentId;
        this.email = student.email;
        this.name = student.name;
        return this;
    }

    public Student build()
    {
        return new Student(this);
    }

    }
}
