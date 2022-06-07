package com.theschool.config;

import com.theschool.filters.HeadersFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ZuulConfig {

    @Bean
    public HeadersFilter getHeadersFilter() {
        return new HeadersFilter();
    }
}
