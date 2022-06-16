package za.ac.cput.school_management.service.studentAddressService;

import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface IStudentAddressService extends IService<StudentAddress, String> {
    void deleteById(String id);
}
