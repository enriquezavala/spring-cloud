package com.theschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
// sets up a Zuul server endpoint and installs some reverse proxy filters in it,
// so it can forward requests to backend servers
@EnableZuulProxy
// the backends can be registered manually through configuration or via discovery client
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
