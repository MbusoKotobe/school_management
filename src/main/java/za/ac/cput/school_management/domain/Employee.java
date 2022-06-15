/* Employee.java
Entity for the Employee
Author: Jody Kearns (209023651)
Date: 10 June 2022 */

package za.ac.cput.school_management.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/* @Email - Did not use javax validator as commons validator is more thorough when checking for email validation.
* @NotNull/@NotBlank - Did not use as checks for nulls/blanks is done in the helper and Factory class.*/
@Entity
public class Employee implements Serializable {

    @Id
    private String staffId;

    private String email;

    @Embedded
    private Name name;

    protected Employee(){

    }

    private Employee(Builder builder){
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public String getStaffId() {return staffId;}

    public String getEmail() {return email;}

    public Name getName() {return name;}

    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId) && email.equals(employee.email) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, email, name);
    }

    public static class Builder{
        private String staffId, email;
        private Name name;

        public Builder staffId(String staffId){
            this.staffId = staffId;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
