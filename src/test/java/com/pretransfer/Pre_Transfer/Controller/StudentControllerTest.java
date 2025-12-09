package com.pretransfer.Pre_Transfer.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pretransfer.Pre_Transfer.Classes.Staff;
import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.Repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class StudentControllerTest {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final MockMvc mockMvc;
    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    public StudentControllerTest(StudentRepository studentRepository, MockMvc mockMvc, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setup() {
        Student student = new Student();
        student.setId("123456");
        student.setFirstName("Jim");
        student.setLastName("Bob");
        student.setCurrentMajor("Computer Science");
        student.setCreditsCompleted(45);
        student.setIntendedMajor("Computer Science");
        student.setEmail("jimbob@gmail.com");
        student.setHighSchoolStatus("Yes");
        student.setIntendedSemester("Fall 2026");
        student.setCurrentInstitution("CCBC");
        student.setMainCampus(true);
        studentRepository.save(student);
        student.setId("123457");
        student.setFirstName("Tim");
        student.setLastName("Bab");
        student.setCurrentMajor("Mathematics");
        student.setCreditsCompleted(60);
        student.setIntendedMajor("Computer Science");
        student.setEmail("tim@gmail.com");
        student.setHighSchoolStatus("Dual Enrolled");
        student.setIntendedSemester("Fall 2027");
        student.setCurrentInstitution("Some High School");
        student.setMainCampus(true);
        studentRepository.save(student);
    }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void testGetAll_Normal() throws Exception {
        this.mockMvc.perform(get("/api/student"))
                .andExpect(status().isOk());
    }
    @Test
    void testInsertStudent_Normal() throws Exception {
        Student student = new Student();
        student.setEmail("Fake@email.com");
        student.setFirstName("Jim");
        student.setLastName("Cricket");
        this.mockMvc.perform(put("/api/student")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }
    @Test
    void testInsertStudent_Fail() throws Exception {
        this.mockMvc.perform(put("/api/student")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
    @Test
    void testDeleteStudent_Normal() throws Exception {
        this.mockMvc.perform(put("/api/student/delete")
                        .param("id", "123456"))
                .andExpect(status().isOk());
    }
    @Test
    void testDeleteStudent_Fail() throws Exception {
        this.mockMvc.perform(put("/api/student/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());
        List<Student> students = studentRepository.findAll();
        Assertions.assertEquals(2, students.size());
    }
}
