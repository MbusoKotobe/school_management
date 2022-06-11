package domain;
/**
 *   StudentAddress.java;
 *   This is a student address domain class
 *   Authour: Anele Aneal Tose - (216079292)
 *   10 June 2022
 */

import java.util.Objects;

public class StudentAddress {
    private final String id, address;
    private StudentAddress(Builder builder){
        this.id = builder.id;
        this.address = builder.address;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
    public static class Builder{
        private String id, address;

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder copy(StudentAddress studentAddress){
            this.id = studentAddress.id;
            this.address = studentAddress.address;
            return this;
        }
        public StudentAddress build(){
            return new StudentAddress(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return id.equals(that.id) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
