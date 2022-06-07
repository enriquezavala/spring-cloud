package com.theschool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope // refresh beans or application properties dynamically at runtime
@RestController // creating controller from here only for this example
public class Application {
	// to refresh the property hit http://localhost:8080/actuator/refresh
	@Value("${app.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public String getAppName() {
		return appName + " app";
	}
}
