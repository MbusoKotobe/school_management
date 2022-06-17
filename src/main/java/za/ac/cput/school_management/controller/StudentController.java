package za.ac.cput.school_management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.school_management.api.StudentAPI;
import za.ac.cput.school_management.domain.*;
import za.ac.cput.school_management.factory.*;
import za.ac.cput.school_management.service.studentService.IStudentService;
import java.util.List;

/*
Author: Ameer Ismail
student nr: 218216033
Controller: Student Controller
ADP3 June assessment Group 1
 */

@RestController
@RequestMapping("school-management/student/")
@Slf4j
public class StudentController {
    private final IStudentService studentService;
    private final StudentAPI studentAPI;

    @Autowired
    public StudentController(IStudentService studentService, StudentAPI studentAPI) {
        this.studentService = studentService;
        this.studentAPI = studentAPI;
    }

    //saving
    @PostMapping("save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        log.info("Save request:{}", student);
        Name ValidateN;
        Student ValidateS;
        try {
            ValidateN = NameFactory.build(student.getName().getFirstName(),
                    student.getName().getMiddleName(), student.getName().getLastName());

            ValidateS = StudentFactory.build(student.getStudentId(), student.getEmail(), ValidateN);
        } catch (IllegalArgumentException i) {
            log.info("Save error:{}", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student save = studentService.save(ValidateS);
        return ResponseEntity.ok(save);
    }


    //reading
    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Student student = this.studentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

    //find all
    @GetMapping("findAll")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> sList = this.studentService.findAll();

        return ResponseEntity.ok(sList);
    }

    //deleting
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete Req:{}", id);
        this.studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Question 8:
    @GetMapping("read-last-name-by-country-id/{countryId}")
    public ResponseEntity<List<String>> findStudentsInCountry(@PathVariable String countryId) {
        List<String> studentLastNamesList;
        try {
            log.info("get student last names by country id{}", countryId);
            studentLastNamesList = this.studentAPI.findStudentsInCountry(countryId);
        }catch (ResponseStatusException e){
            throw e;

        }
        return ResponseEntity.ok(studentLastNamesList);

    }
}
