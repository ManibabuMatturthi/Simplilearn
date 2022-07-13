package com.example.springbootapp.feedbackdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.example.springbootapp.feedbackdemo")
public class FeedbackdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackdemoApplication.class, args);
	}

}
