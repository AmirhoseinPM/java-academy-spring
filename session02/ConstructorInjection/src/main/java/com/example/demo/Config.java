package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Car.class) // or can use @ComponentScan
public class Config {
	
	@Bean("engine")
	public Engine otherMethodName() {
		return new EngineA();
	}
	@Bean
	public Transmission transmission() {
		return new TransmissionB();
	}
	
}
