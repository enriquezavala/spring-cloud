package com.theschool.springcloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // enable hystrix dashboard
public class Application {
	// visit hystrix dashboard: http://localhost:8080/hystrix
	// add client url http://localhost:8001/hystrix.stream
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
