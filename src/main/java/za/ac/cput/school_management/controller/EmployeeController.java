/* EmployeeController.java
Controller for the Employee
Author: Jody Kearns (209023651)
Date: 13 June 2022 */

package za.ac.cput.school_management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.api.EmployeeAPI;
import za.ac.cput.school_management.domain.Employee;
import za.ac.cput.school_management.domain.Name;
import za.ac.cput.school_management.factory.EmployeeFactory;
import za.ac.cput.school_management.factory.NameFactory;
import za.ac.cput.school_management.helper.Helper;
import za.ac.cput.school_management.service.employeeService.IEmployeeService;
import java.util.List;

@RestController
@RequestMapping("school-management/employee/")
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final EmployeeAPI employeeAPI;

    @Autowired
    public EmployeeController(IEmployeeService employeeService, EmployeeAPI employeeAPI){
        this.employeeService = employeeService;
        this.employeeAPI = employeeAPI;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info("Save request: {}", employee);
        Name validatedName;
        Employee validatedEmployee;
        try {
            validatedName = NameFactory.build(employee.getName().getFirstName(),
                    employee.getName().getMiddleName(),employee.getName().getLastName());
            validatedEmployee = EmployeeFactory.build(employee.getStaffId(),
                    employee.getEmail(), validatedName);
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee save = employeeService.save(validatedEmployee);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Employee> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Employee employee = this.employeeService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = this.employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    //Question 5:
    @GetMapping("read-by-email/{email}")
    public ResponseEntity<Name> findByEmail(@PathVariable String email){
        log.info("Read name by email request: {}", email);
        try{
            Helper.checkEmail(email);
        }catch(IllegalArgumentException e){
            log.info("Find name by email request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee employee = this.employeeService.findByEmail(email)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee.getName());
    }

    //Question 6:
    @GetMapping("read-employee-name-by-city-id/{cityId}")
    public ResponseEntity<List<Name>> findEmpByCity(@PathVariable String cityId){
        List<Name> employeeNamesList = null;
        try{
            log.info("Read employee name by city id request: {}", cityId);
            employeeNamesList = employeeAPI.findEmployeesInCity(cityId);
        }catch(ResponseStatusException e){
            throw e;//new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeNamesList);
    }
}

