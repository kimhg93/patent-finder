package com.finder.patent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatentFinderApplication {

	public static void main(String[] args) {
		System.setProperty("log4jdbc.log4j2.properties.file", "/config/log4jdbc.log4j2.properties");
		SpringApplication.run(PatentFinderApplication.class, args);
	}

}

