package com.wyp.eureka.eurekaclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HiController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/hi")
    public String gethi(){
        return "hi";
    }
    @RequestMapping("/test1")
    public String test1(){
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> System.out.println(s));
        return services.toString();
    }
    @RequestMapping("/test2")
    public String test2(){
//        List<InstanceInfo> provider = eurekaClient.getInstancesById("provider");
        String url = null;
        List<InstanceInfo> provider = eurekaClient.getInstancesByVipAddress("provider", false);
        if (provider.size()>0){
            InstanceInfo ins = provider.get(0);
            if (InstanceInfo.InstanceStatus.UP.equals(ins.getStatus())){
                url = "http://"+ins.getHostName() +":"+ins.getPort()+"/hi";
                System.out.println(url);
                RestTemplate restTemplate = new RestTemplate();
                String forObject = restTemplate.getForObject(url, String.class);
                System.out.println(forObject);
                return forObject;
            }
        }
        return url;
    }
    @RequestMapping("/test3")
    public String test3(){
//        List<InstanceInfo> provider = eurekaClient.getInstancesById("provider");
        String url = null;
        ServiceInstance ins = loadBalancerClient.choose("provider");
        url = "http://"+ins.getHost() +":"+ins.getPort()+"/hi";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;
    }


}
