package za.ac.cput.school_management.service.countryService;
/*
 * Zintle Magwaxaza (218109911)
 * ICountryService
 * Date: 14 June 2022
 */
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.service.IService;
import java.util.List;

public interface ICountryService extends IService<Country,String> {
    List<Country> findAll();

    void deleteById(String id);
}
