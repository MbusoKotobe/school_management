package za.ac.cput.school_management.factory;

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
