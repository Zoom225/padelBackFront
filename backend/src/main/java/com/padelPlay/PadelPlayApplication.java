package com.padelPlay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PadelPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadelPlayApplication.class, args);
	}

}
