package za.ac.cput.school_management.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.Student;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.service.studentAddressService.IStudentAddressService;
import za.ac.cput.school_management.service.studentService.IStudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Component
public class StudentAPI {

    private final IStudentService studentService;
    private final IStudentAddressService studentAddressService;


    @Autowired
    public StudentAPI(IStudentService studentService, IStudentAddressService studentAddressService) {
        this.studentService = studentService;
        this.studentAddressService = studentAddressService;

    }

    //Question 8:
    public List<String> findStudentsInCountry(String countryId){
        try {
            List<StudentAddress> allStudentAddresses = studentAddressService.findAll();
            List<StudentAddress> filteredStudentAddress = new ArrayList<>();
            List<Student> allStudents = new ArrayList<>();
            List<String> lastNames = new ArrayList<>();

            for (var studentAddress: allStudentAddresses) {
                if (studentAddress.getAddress().getCity().getCountry().getCountryId().equalsIgnoreCase(countryId)){
                    filteredStudentAddress.add(studentAddress);
                }
            }

            filteredStudentAddress.forEach(studentAddress -> {
                allStudents.add(studentService.read(studentAddress.getStudentId()).get());
            });

            allStudents.forEach(student -> {
                lastNames.add(student.getName().getLastName());
            });

            return lastNames;

        }catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}