package com.onesoft.helloresttemplate1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class Helloresttemplate1Application {

	public static void main(String[] args) {
		SpringApplication.run(Helloresttemplate1Application.class, args);
	}
		@Bean
       	public RestTemplate template() {
			return new RestTemplate();
	}
  }
