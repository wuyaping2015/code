package com.wuyaping.eurekademo.eurakaprovider;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class HiController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hi")
    public String gethi(){
        return "hi! Provider";
    }
    @RequestMapping("/test1")
    public String test1(){
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> System.out.println(s));
        return "hi";
    }

}
