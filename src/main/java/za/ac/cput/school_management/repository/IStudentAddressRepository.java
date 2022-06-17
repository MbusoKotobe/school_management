package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.StudentAddress;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, String> {

}
