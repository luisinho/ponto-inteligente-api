package com.udemy.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PontointeligenteApplication {

	public static void main(String[] args) {
		String start = "spring";
		System.out.println("start travis" + start);
		SpringApplication.run(PontointeligenteApplication.class, args);
	}

}
