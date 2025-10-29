package com.pretransfer.Pre_Transfer.DAO;

import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAO {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentDAO(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<List<Student>> getAllStudents() {
        return Optional.of(studentRepository.findAll());
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> saveStudent(Student student) {
        return Optional.of(studentRepository.save(student));
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}