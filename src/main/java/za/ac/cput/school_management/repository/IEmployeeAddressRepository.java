package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.EmployeeAddress;

/**
 * @author Mbuso Kotobe (218040385)
 * IEmployeeAddressRepository
 * Date: 10 June 2022
 * */
@Repository
public interface IEmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {
}
