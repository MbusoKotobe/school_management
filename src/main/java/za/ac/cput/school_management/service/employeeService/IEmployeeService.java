/* IEmployeeService.java
Service interface for the Employee
Author: Jody Kearns (209023651)
Date: 12 June 2022 */

package za.ac.cput.school_management.service.employeeService;

import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.service.IService;


import java.util.Optional;


public interface IEmployeeService extends IService<Employee, String> {
    void deleteById(String id);
    Optional<Employee> findByEmail(String email);
}
