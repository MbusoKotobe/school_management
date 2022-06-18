package za.ac.cput.school_management.domain;

/**
 * StudentAddress.java;
 * This is a student address domain class
 * @Author: Anele Aneal Tose - (216079292)
 * Date: 10 June 2022
 */

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StudentAddress implements Serializable {
    @NotNull
    @Id
    private String studentId;
    @NotNull
    @Embedded
    private Address address;

    protected StudentAddress(){}
    private StudentAddress(Builder builder){
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    public String getStudentId() {
        return studentId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return studentId.equals(that.studentId) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, address);
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }
    public static class Builder{
        private String studentId;
        private Address address;

        public Builder  setStudentId(String studentId){
            this.studentId = studentId;
            return this;
        }

        public Builder setAddress(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress studentAddress){
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build(){
            return new StudentAddress(this);
        }
    }
}
