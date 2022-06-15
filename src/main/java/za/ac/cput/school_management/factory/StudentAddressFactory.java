package za.ac.cput.school_management.factory;
/**
 * StudentAddressRepository.java;
 * This is a student address domain class
 * @Author: Anele Aneal Tose - (216079292)
 * Date: 12 June 2022
 */

import za.ac.cput.school_management.domain.Address;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.helper.Helper;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId, Address address) throws IllegalArgumentException{
        Helper.checkStringParam("studentId", studentId);
        Helper.checkIfObjectNull("address", address);
        return new StudentAddress.Builder().setStudentId(studentId).setAddress(address)
                .build();
    }
}
