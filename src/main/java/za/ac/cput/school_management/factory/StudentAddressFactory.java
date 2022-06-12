package za.ac.cput.school_management.factory;

import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.helper.Helper;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId, String address) throws IllegalArgumentException{
        Helper.checkStringParam("studentId", studentId);
        Helper.checkStringParam("address", (address));
        return new StudentAddress.Builder().setStudentId(studentId).build();
    }
}
