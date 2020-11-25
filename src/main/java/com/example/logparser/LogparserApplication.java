package com.example.logparser;

import com.example.logparser.service.LogParserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LogparserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogparserApplication.class, args);
		String filePath = "C:\\Users\\abhis\\Downloads\\input.csv";
		filePath = filePath.replace("\\", "/");
		try {
			LogParserService service = new LogParserService(filePath);
			System.out.println(service.getTopElements(5));
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
