package com.pretransfer.Pre_Transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PreTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreTransferApplication.class, args);
	}

	@GetMapping("/")
	public int getNum() {
		return 20;
	}
}
