package za.ac.cput.school_management.service.countryService.impl;
/*
 * Zintle Magwaxaza (218109911)
 * CountryServiceImpl.java
 * Date: 14 June 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Country;
import za.ac.cput.school_management.repository.ICountryRepository;
import za.ac.cput.school_management.service.countryService.ICountryService;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {
    private final ICountryRepository repository;

    @Autowired
    public CountryServiceImpl(ICountryRepository repository){
        this.repository = repository;
    }

    @Override
    public Country save(Country country) {
      return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String s) {
       return this.repository.findById(s);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);
    }

    @Override
    public List<Country> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
     repository.deleteById(id);
     Optional<Country> country = read (id);
     if (country.isPresent()){
         delete(country.get());
     }
    }
}
