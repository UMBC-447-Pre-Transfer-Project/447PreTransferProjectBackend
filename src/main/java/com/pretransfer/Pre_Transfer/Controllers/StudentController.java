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
import java.util.UUID;

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

        if (!StringUtils.hasText(student.getId())) {
            student.setId(UUID.randomUUID().toString());
        }
        Optional<Student> resStudent = studentDAO.saveStudent(student);

        if (resStudent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resStudent.get());
    }

    @PutMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam String id) {
        Assert.hasText(id, "id cannot be null");
        studentDAO.deleteStudentById(id);
        if (studentDAO.getStudentById(id).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("Successfully Deleted");
    }
}
