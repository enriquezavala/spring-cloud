package com.theschool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController // creating controller from here only for this example
public class Application {
	@Value("${company.name}") // get global property from github application properties
	String companyName;
	@Value("${app.name}") // get app property from github application properties
	String appName;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public String getProperties() {
		return appName + " app by " + companyName;
	}

}
