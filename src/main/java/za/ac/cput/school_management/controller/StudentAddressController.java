package za.ac.cput.school_management.controller;

/**
 * StudentAddressController.java;
 * This is a StudentAddressController class
 * @Author: Anele Aneal Tose - (216079292)
 * Date: 14 June 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.domain.StudentAddress;
import za.ac.cput.school_management.service.employeeService.IStudentAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/studentAddresss/")
@Slf4j
public class StudentAddressController {
    private final IStudentAddressService studentAddressService;

    @Autowired
    public StudentAddressController(IStudentAddressService studentAddressService){
        this.studentAddressService = studentAddressService;
    }
    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress){
        log.info("Save request: {}", studentAddress);
        StudentAddress save = studentAddressService.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id){
        log.info("Read request: {}", id);
        StudentAddress studentAddress = this.studentAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.studentAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>> findAll(){
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        return ResponseEntity.ok(studentAddressList);
    }

}
