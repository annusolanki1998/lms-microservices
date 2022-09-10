package com.bridgelabz.zullapisgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableEurekaClient
public class ZullApisGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZullApisGatewayApplication.class, args);
    }

}
