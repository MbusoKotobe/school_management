package za.ac.cput.school_management.service.studentAddressService;

import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.service.IService;

/**
 * StudentAddress.java;
 * This is a student address domain class
 * @Author: Anele Aneal Tose - (216079292)
 * Date: 10 June 2022
 */
public interface IStudentAddressService extends IService<StudentAddress, String> {
    void deleteById(String id);
}
