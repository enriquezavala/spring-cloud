package com.theschool;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // @HystrixCommand needs to be on service class
public class HystrixService {
    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "unknown") // specify some methods which should be processes as hystrix commands
    public String getTeachers() {
        return restTemplate.getForEntity("http://hystrix-teacher-service", String.class).getBody();
    }

    // default fallback method
    public String unknown() {
        return "unknown";
    }
}
