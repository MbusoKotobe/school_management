/* IEmployeeRepository.java
Repository interface for the Employee
Author: Jody Kearns (209023651)
Date: 12 June 2022 */

package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

}