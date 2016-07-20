package com.yvan.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("${server.basePackages}")
@SpringBootApplication
public class PracticeYvanApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticeYvanApplication.class, args);
	}
}
