package za.ac.cput.school_management.service.countryService;

import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface ICountryService extends IService<Country,String> {
    List<Country> findAll();
}
