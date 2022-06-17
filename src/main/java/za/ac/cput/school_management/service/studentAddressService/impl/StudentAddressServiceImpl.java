package za.ac.cput.school_management.service.studentAddressService.impl;

/**
 * StudentAddressServiceImpl.java;
 * This is a StudentAddressServiceImpl class
 * @Author: Anele Aneal Tose - (216079292)
 * Date: 14 June 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.repository.IStudentAddressRepository;
import za.ac.cput.school_management.service.studentAddressService.IStudentAddressService;
import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements IStudentAddressService {
    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(IStudentAddressRepository repository){
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress){

        return  this.repository.save(studentAddress);
    }
    @Override
    public Optional<StudentAddress> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<StudentAddress> studentAddress = read(id);
        if (studentAddress.isPresent()) {
            delete(studentAddress.get());
        }
    }

}
