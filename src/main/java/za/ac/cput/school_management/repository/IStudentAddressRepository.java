package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.StudentAddress;

/**
 * StudentAddress.java;
 * IStudentAddressRepository
 * @Author: Anele Aneal Tose - (216079292)
 * Date: 10 June 2022
 */
@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, String> {

}
