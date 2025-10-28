package com.pretransfer.Pre_Transfer.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pre-transfer")
public class PreTransferController {
    @GetMapping
    public Optional<List<String>> getAllStudents(@RequestParam String key) {
        if (StringUtils.hasText(key)) {
            return Optional.of(List.of("Student"));
        }
        return Optional.empty();
    }
}
