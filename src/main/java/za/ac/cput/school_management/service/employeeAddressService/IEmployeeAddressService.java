package za.ac.cput.school_management.service.employeeAddressService;

import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    List<EmployeeAddress> findAll();
    void deleteById(String employeeId);

}
