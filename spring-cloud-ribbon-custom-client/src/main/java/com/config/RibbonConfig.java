package com.config; // other package to avoid this configuration in all ribbon clients

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    // override the rule for a load balancer
    @Bean
    public IRule ribbonRule() {
        return new RandomRule(); // a load balacing strategy that randomly distributes traffic amongst existing servers
    }
}
