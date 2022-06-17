package za.ac.cput.school_management.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.service.cityService.ICityService;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;
import za.ac.cput.school_management.service.employeeService.IEmployeeService;
import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeAPI {
    private final IEmployeeAddressService employeeAddressService;
    private final IEmployeeService employeeService;
    private final ICityService cityService;

    @Autowired public EmployeeAPI(IEmployeeAddressService employeeAddressService, IEmployeeService employeeService, ICityService cityService){
        this.employeeAddressService = employeeAddressService;
        this.employeeService = employeeService;
        this.cityService = cityService;
    }

    //Question 6:
    public List<Name> findEmployeesInCity(String cityId){
        this.cityService.read(cityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<EmployeeAddress> allEmployeeAddresses = this.employeeAddressService.findAll();
        List<Employee> foundEmployees = new ArrayList<>();
        List<Name> employeeNames = new ArrayList<>();
        for (var employeeAddress : allEmployeeAddresses){
            if (employeeAddress.getAddress().getCity().getId().equalsIgnoreCase(cityId)){
                foundEmployees.add(employeeService.read(employeeAddress.getStaffId()).get());
            }
        }
        foundEmployees.forEach(employee -> employeeNames.add(employee.getName()));
        return employeeNames;
    }
}
