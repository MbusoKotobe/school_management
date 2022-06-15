/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 15 June 2022
 */
package za.ac.cput.school_management.service.employeeService;

import za.ac.cput.school_management.domain.City;

import java.util.Optional;

public interface ICityService {
    City save(City city);

    Optional<City> read(String s);

    void delete(City city);
}
