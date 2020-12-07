package com.wuyaping.erukademo.erukademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErukaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErukaDemoApplication.class, args);
    }

}
