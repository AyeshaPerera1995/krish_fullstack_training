package com.ayesha.rentcloud.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//Otherwise you get an error, because your Customer is in different package(model), but your profile service is on
// different package.
@EntityScan(basePackages = "com.ayesha.rentcloud.commons.model")
@EnableResourceServer // we marked our service as Resource Server. So its responsible for protect service.
@EnableGlobalMethodSecurity(prePostEnabled = true) // enable us to use the method level security
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
