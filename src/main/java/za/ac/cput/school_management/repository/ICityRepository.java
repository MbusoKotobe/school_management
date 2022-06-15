/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.school_management.domain.City;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City, String> {
    List<City> findByEmployeeNumber(String city);
}
