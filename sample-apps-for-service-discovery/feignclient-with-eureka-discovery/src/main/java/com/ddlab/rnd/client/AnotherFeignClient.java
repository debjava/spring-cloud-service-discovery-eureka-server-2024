package com.ddlab.rnd.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// Below is the name of the application to be invoked by Feign Client
@FeignClient(name="SAMPLE-APP3-SERVICE",path="/sample-app3-service") //path is required in case of Eureka
public interface AnotherFeignClient {

    @GetMapping("/hello/{id}")
    String getHelloFromService(@PathVariable("id") String id);
}
