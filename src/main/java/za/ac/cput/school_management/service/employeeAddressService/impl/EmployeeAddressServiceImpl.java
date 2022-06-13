package za.ac.cput.school_management.service.employeeAddressService.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.repository.IEmployeeAddressRepository;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService<EmployeeAddress, String> {

    private final IEmployeeAddressRepository repository;

    public EmployeeAddressServiceImpl(IEmployeeAddressRepository repo)
    {
        this.repository = repo;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress)
    {
        return repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String employeeId)
    {
        return repository.findById(employeeId);
    }

    @Override
    public List<EmployeeAddress> findAll()
    {
        return repository.findAll();
    }

    @Override
    public void deleteById(String employeeId)
    {
        Optional<EmployeeAddress> employeeAddress = read(employeeId);
        if(employeeAddress.isPresent())
            delete(employeeAddress.get());
    }

    @Override
    public void delete(EmployeeAddress object)
    {
        repository.delete(object);
    }

}
