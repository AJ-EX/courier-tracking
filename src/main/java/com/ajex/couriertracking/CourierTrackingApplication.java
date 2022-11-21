package com.ajex.couriertracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourierTrackingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourierTrackingApplication.class, args);
    }

//    @LoadBalanced
//    @Bean("loadBalancedRestTemplate")
//    public RestTemplate loadBalancedRestTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
}
