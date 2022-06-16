package za.ac.cput.school_management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
@RequestMapping("school_management/student/")
@Slf4j
public class StudentController
{
    private IStudentService studentService;

    @Autowired public StudentController(IStudentService studentService)
    {
        this.studentService = studentService;
    }

    //saving
    @PostMapping("save")
    public ResponseEntity<Student> save(@RequestBody Student student)
    {
        log.info("Save : {}", student );
        Name ValidateN;
        Student ValidateS;
        try
        {
            ValidateN = NameFactory.build(student.getName().getFirstName(),
                    student.getName().getMiddleName(), student.getName().getLastName());

            ValidateS = StudentFactory.build(student.getStudentId(), student.getEmail(), ValidateN);
        }
        catch(IllegalArgumentException i)
        {
            log.info("Save error: {}", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student save = studentService.save(ValidateS);
        return ResponseEntity.ok(save);
    }


    //reading
    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id)
    {
        log.info("Read request: {}", id);
        Student student = this.studentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

    //find all
    @GetMapping("findAll")
    public ResponseEntity<List<Student>> findAll()
    {
        List<Student> sList = this.studentService.findAll();

        return ResponseEntity.ok(sList);
    }

    //deleting
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable Student s)
    {
        log.info("Delete Req: {}", s);
        this.studentService.delete(s);
        return ResponseEntity.noContent().build();
    }


}
