package com.api.solset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SolsetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolsetApplication.class, args);
	}

}
