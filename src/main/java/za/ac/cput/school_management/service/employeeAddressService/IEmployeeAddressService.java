package za.ac.cput.school_management.service.employeeAddressService;

import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.service.IService;

/**
 * @author Mbuso Kotobe (218040385)
 * Entity for Address
 * Date: 10 June 2022
 * */
public interface IEmployeeAddressService extends IService<EmployeeAddress, String> {
    void deleteById(String staffId);
}
