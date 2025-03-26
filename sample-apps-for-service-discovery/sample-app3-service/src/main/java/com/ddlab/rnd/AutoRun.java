//package com.ddlab.rnd;
//
//import com.ddlab.rnd.client.AppFeignClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import java.net.URI;
//import java.util.List;
//
//@Component
//public class AutoRun {
//
//    @Autowired
//    private AppFeignClient feignClient;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    public void invokeFeign() {
//        System.out.println("******************* RESPONSE USING FEIGN CLIENT *******************");
//        URI baseURI = URI.create("http://localhost:8081/sample-app1-service");
//        String infoText = feignClient.getInfo(baseURI);
//        System.out.println("Info Text: "+infoText);
//    }
//
//    public void invokeFeignUsingDiscovery() {
//        System.out.println("discoveryClient----->"+discoveryClient);
//        discoveryClient.getServices().forEach(value -> System.out.println("Service: "+value));
//
//        System.out.println("******************* RESPONSE USING FEIGN CLIENT *******************");
//        String serviceName = "sample-app1-service";
//        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
//        if(!instances.isEmpty()) {
//            ServiceInstance serviceInstance = instances.get(0);
//            String serviceId = serviceInstance.getServiceId();
//            System.out.println("Service Id: "+serviceId); //SAMPLE-APP1-SERVICE
//            URI rootURI = serviceInstance.getUri();
//            System.out.println("ROOT URI: "+rootURI); // http://localhost:8081
//            URI baseURI = URI.create(rootURI+"/"+serviceName);
//            System.out.println("Base URI: "+baseURI);
//            String infoText = feignClient.getInfo(baseURI);
//            System.out.println("Info Text: "+infoText);
//        }
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void run() {
//        System.out.println("Sample App3 Application started running ...");
//        invokeFeign();
//        invokeFeignUsingDiscovery();
//    }
//}
