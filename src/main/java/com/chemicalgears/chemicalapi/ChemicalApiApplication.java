package com.chemicalgears.chemicalapi;

import com.chemicalgears.chemicalapi.entity.SystemInformation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ChemicalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChemicalApiApplication.class, args);
	}

	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
