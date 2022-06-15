package za.ac.cput.school_management.service.countryService.impl;
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
    public List<Country> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(Country country) {
     this.repository.delete(country);
    }
}
