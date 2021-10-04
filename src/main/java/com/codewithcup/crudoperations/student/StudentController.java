package com.codewithcup.crudoperations.student;

import com.codewithcup.crudoperations.exceptions.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student-byEmail/{email}")
    public ResponseEntity<Optional<Student>> getStudentEmail(@PathVariable String email) {
        Optional<Student> studentByEmail = studentService.getStudentByEmail(email);
        if(studentByEmail.isPresent())
            return new ResponseEntity("This Email Address already present!!!!",HttpStatus.OK);
        else if(!studentByEmail.isPresent())
            throw new EmailNotFoundException("This Email doesn't register with our database");
        return ResponseEntity.status(400).build();

    }

    @GetMapping("/student-byName/{studentName}")
    public ResponseEntity<Student> getStudentName(@PathVariable String studentName) {
        Student studentByName = studentService.getStudentByName(studentName);
        return ResponseEntity.status(HttpStatus.OK).body(studentByName);

    }


    @PostMapping("/add-student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student student1 = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(student1);

    }
}
