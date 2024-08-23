package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	// constructor DI
	@Bean
	public Service service1() {
		return new ServiceA();
	}
	
	@Bean
	public Service service2() {
		return new ServiceB();
	}

	// constructor DI
	@Bean
	public Client client1() {
		return new Client(service1());
	}
	
	// setter DI
	@Bean
	public Client client2() {
		Client client = new Client();
		client.setService(service2());
		return client;		
	}
	
}
