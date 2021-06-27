package com.example.webform;


import com.example.webform.controller.ControllerForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WebFormApplicationTests {

	@Autowired
	private ControllerForm controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();



	}

}
