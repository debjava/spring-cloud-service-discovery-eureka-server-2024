package com.ddlab.rnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringDiscoveryEurekaServerApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscoveryEurekaServerApp.class, args);
	}
}
