package com.pretransfer.Pre_Transfer.Controllers;

import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        Optional<List<Student>> studentsOpt = studentDAO.getAllStudents();
        if (studentsOpt.isPresent()) {
            return ResponseEntity.of(studentsOpt);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        Assert.notNull(student, "Student cannot be null");

        Optional<Student> resStudent = studentDAO.saveStudent(student);

        if (resStudent.isPresent()) {
            return ResponseEntity.of(resStudent);
        }
        return ResponseEntity.badRequest().build();
    }
}
