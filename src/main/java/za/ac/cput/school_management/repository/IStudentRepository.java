package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.Student;

/*
Author: Ameer Ismail
student nr: 218216033
IStudentRepository
ADP3 June assessment Group 1
 */
@Repository
public interface IStudentRepository extends JpaRepository<Student, String>
{
}
