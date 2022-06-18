package za.ac.cput.school_management.service.employeeAddressService;

import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.service.IService;

public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    void deleteById(String staffId);
}
