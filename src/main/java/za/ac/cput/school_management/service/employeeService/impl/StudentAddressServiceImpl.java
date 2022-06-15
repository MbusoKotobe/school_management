package za.ac.cput.school_management.service.employeeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.factory.StudentAddressFactory;
import za.ac.cput.school_management.repository.IStudentAddressRepository;
import za.ac.cput.school_management.service.employeeService.IStudentAddressService;

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
    public StudentAddress save(StudentAddress studentAddresss){
        StudentAddress student = StudentAddressFactory
                .build(studentAddresss.getStudentId(), studentAddresss.getAddress());
        return  this.repository.save(student);
    }
    @Override
    public Optional<StudentAddress> read(String id) {
        return this.repository.read(id);
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
