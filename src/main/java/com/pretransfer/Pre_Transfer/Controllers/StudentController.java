package com.pretransfer.Pre_Transfer.Controllers;

import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Optional<List<Student>> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
