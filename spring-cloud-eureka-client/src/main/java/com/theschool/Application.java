package com.theschool;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // enable discovery client
@RestController // creating controller from here only for this example
public class Application {
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String callService() {
		// gets the next possible server to process the requests from the registry information received from eureka
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-service", false);
		String baseUrl = instanceInfo.getHomePageUrl(); // gets the home page set for this instance

		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET,null, String.class);

		return response.getBody();
	}

}
