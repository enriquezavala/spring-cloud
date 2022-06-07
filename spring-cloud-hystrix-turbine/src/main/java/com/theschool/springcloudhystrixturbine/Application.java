package com.theschool.springcloudhystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine // enable turbine
public class Application {
	// turbine aggregates multiple instances hystrix metrics streams, so the dashboard can display an aggregate view
	// visit hystrix dashboard: http://localhost:8080/hystrix
	// add turbine url http://localhost:3000/turbine.stream
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
