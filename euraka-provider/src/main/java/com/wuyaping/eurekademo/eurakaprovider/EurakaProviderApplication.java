package com.wuyaping.eurekademo.eurakaprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurakaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurakaProviderApplication.class, args);
    }

}
