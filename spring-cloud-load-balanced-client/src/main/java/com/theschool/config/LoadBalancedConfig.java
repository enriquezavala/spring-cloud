package com.theschool.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoadBalancedConfig {
    @Bean
    @LoadBalanced // mark a RestTemplate bean to support load balancing
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
