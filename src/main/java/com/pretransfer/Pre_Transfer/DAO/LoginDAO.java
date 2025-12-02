package com.pretransfer.Pre_Transfer.DAO;

import com.pretransfer.Pre_Transfer.Classes.Staff;
import com.pretransfer.Pre_Transfer.Classes.Student;
import com.pretransfer.Pre_Transfer.Repository.StaffRepository;
import com.pretransfer.Pre_Transfer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class LoginDAO {

    private final StaffRepository staffRepository;

    @Autowired
    public LoginDAO(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public String login(String username, String password) {
        Optional<Staff> staffOptional = staffRepository.findByUsername(username);
        if (staffOptional.isEmpty()) {
            return "";
        }
        Staff staff = staffOptional.get();
        if (staff.getUsername().equals(username) && staff.getPassword().equals(password)) {
            return username;
        }
        return "";
    }

    public String signup(String username, String password) {
        return username;
    }
}