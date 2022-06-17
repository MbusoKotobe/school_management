package za.ac.cput.school_management.repository;
/*
 * Zintle Magwaxaza (218109911)
 * ICountryRepository
 * Date: 14 June 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.school_management.domain.Country;
import java.util.List;


public interface ICountryRepository  extends JpaRepository <Country, String> {
    List<Country> findAll();


}
