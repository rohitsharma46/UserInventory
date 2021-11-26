package com.example.webform;

import com.example.webform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.example")
public class WebFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFormApplication.class, args);
	}

	//Story 1 completed
}
