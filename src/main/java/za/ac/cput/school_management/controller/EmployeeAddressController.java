package za.ac.cput.school_management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.EmployeeAddress;
import za.ac.cput.school_management.factory.EmployeeAddressFactory;
import za.ac.cput.school_management.service.employeeAddressService.IEmployeeAddressService;

import java.util.List;

/**
 * @author Mbuso Kotobe (218040385)
 * Controller for Address
 * Date: 10 June 2022
 * */
@Slf4j
@RestController
@RequestMapping("school-management/employee-address/")
public class EmployeeAddressController {

    private final IEmployeeAddressService service;

    @Autowired public EmployeeAddressController(IEmployeeAddressService service)
    {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@RequestBody EmployeeAddress employeeAddress)
    {
        EmployeeAddress employeeAddressAlt = null;
        try
        {
            employeeAddressAlt = service.save(EmployeeAddressFactory.build(
                    employeeAddress.getStaffId(),
                    employeeAddress.getAddress()
            ));
        }catch(IllegalArgumentException exception)
        {
            log.info("EmployeeAddress Save : {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(employeeAddressAlt);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String id)
    {
        EmployeeAddress employeeAddress = service.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<EmployeeAddress>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody EmployeeAddress object)
    {
        service.delete(object);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id)
    {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
