package com.binhcodev.spring_boot_jwt_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootJwtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthApplication.class, args);
	}

	@GetMapping("/")
	public String sayHello() {
		return "Hello, World!";
	}
	

}
