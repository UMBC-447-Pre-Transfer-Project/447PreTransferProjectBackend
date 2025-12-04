package com.pretransfer.Pre_Transfer.Controller;

import com.pretransfer.Pre_Transfer.Classes.Staff;
import com.pretransfer.Pre_Transfer.Repository.StaffRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Resource
    private final StaffRepository staffRepository;
    private final MockMvc mockMvc;

    @Autowired
    public LoginControllerTest(StaffRepository staffRepository, MockMvc mockMvc) {
        this.staffRepository = staffRepository;
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    void setup() {
        Staff staff = new Staff();
        staff.setId("1232");
        staff.setFirstName("Jim");
        staff.setLastName("Bob");
        staff.setEmail("fake@gmail.com");
        staff.setUsername("username");
        staff.setPassword("password");
        staffRepository.save(staff);
    }

    @AfterEach
    void tearDown() {
        staffRepository.deleteAll();
    }

    @Test
    void testLogin_Normal() throws Exception {
        this.mockMvc.perform(put("/auth/login")
                        .header("username", "username")
                        .header("username", "username"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
