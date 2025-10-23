package com.pretransfer.Pre_Transfer.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        
        return username + password;
    }

}
