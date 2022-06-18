package za.ac.cput.school_management.service.employeeAddressService.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.repository.IEmployeeAddressRepository;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;

import java.util.List;
import java.util.Optional;

/**
 * @author Mbuso Kotobe (218040385)
 * EmployeeAddressServiceImpl
 * Date: 10 June 2022
 * */
@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService{

    private final IEmployeeAddressRepository repository;

    @Autowired public EmployeeAddressServiceImpl(IEmployeeAddressRepository repo)
    {
        this.repository = repo;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) throws IllegalArgumentException
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
    public void deleteById(String staffId)
    {
        Optional<EmployeeAddress> employeeAddress = read(staffId);
        employeeAddress.ifPresent(this::delete);
    }

    @Override
    public void delete(EmployeeAddress object)
    {
        repository.delete(object);
    }

}
