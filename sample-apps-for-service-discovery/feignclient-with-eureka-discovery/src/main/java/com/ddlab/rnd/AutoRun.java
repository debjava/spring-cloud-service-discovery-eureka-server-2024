package com.ddlab.rnd;

//import com.ddlab.rnd.client.AnotherFeignClient;
import com.ddlab.rnd.client.AnotherFeignClient;
//import com.ddlab.rnd.client.HelloWorldClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.client.SampleFeignClient;

import java.net.URI;
import java.util.List;

@Component
public class AutoRun {
	
	@Autowired
	private SampleFeignClient client;

	@Autowired
	private DiscoveryClient discoveryClient;

	private String discoveryServiceName = "sample-app3-service";

	@Autowired
	private AnotherFeignClient anotherClient;

	public void showServiceDetails() {
		discoveryClient.getServices().forEach(value -> System.out.println("Service Name: "+value));
	}

	public void invokeServiceUsingBaseURI() {
		List<ServiceInstance> list = discoveryClient.getInstances(discoveryServiceName);
		URI baseURI = null;
		if(!list.isEmpty()) {
			baseURI = list.get(0).getUri();
		}
		System.out.println("What is base URI : "+baseURI);
		URI mainUri = URI.create(baseURI.toString()+"/"+discoveryServiceName);
		String response = client.getHello(mainUri,"123");
		System.out.println("Response: "+response);
	}

	public void invokeDirectService() {
		String response = anotherClient.getHelloFromService("123");
		System.out.println("Another client Response: "+response);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("App started running ...");
//		showServiceDetails();
//		invokeServiceUsingBaseURI();
		invokeDirectService();
	}

}
