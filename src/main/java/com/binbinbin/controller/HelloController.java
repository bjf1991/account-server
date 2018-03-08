package com.binbinbin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bin on 2018/3/8.
 */
@RestController
public class HelloController {
    private final Logger log=Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/")
    public String hello(){
        ServiceInstance instance=client.getLocalServiceInstance();
        log.info("host="+instance.getHost()+" ,service_id="+instance.getServiceId());
        return "hello world";
    }
}
