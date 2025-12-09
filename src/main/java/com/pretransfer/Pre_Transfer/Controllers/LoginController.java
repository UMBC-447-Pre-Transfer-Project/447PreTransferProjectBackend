package com.pretransfer.Pre_Transfer.Controllers;

import com.pretransfer.Pre_Transfer.DAO.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    private final LoginDAO loginDAO;

    @Autowired
    public LoginController(LoginDAO loginDAO) { this.loginDAO = loginDAO; }

    @PutMapping
    public ResponseEntity<String> login(@RequestHeader String username, @RequestHeader String password) {
        Assert.hasText(username, "username cannot be empty");
        Assert.hasText(password, "password cannot be empty");
        String res = loginDAO.login(username, password);
        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(Optional.of(res));
    }

    @PostMapping
    public Optional<String> signup(@RequestHeader String username, @RequestHeader String password) {
        Assert.hasText(username, "username cannot be empty");
        Assert.hasText(password, "password cannot be empty");
        String res = loginDAO.signup(username, password);
        if (res.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(res);
    }
}
