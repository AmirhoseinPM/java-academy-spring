package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Car {
	private Engine engine;
	private Transmission transmission;
	public int model;
	
	@Autowired
	public Car(Engine engine,
			Transmission transmission, 
			@Value("${default.car.model:0}") int model ) {
		this.engine = engine;
		this.transmission = transmission;
		this.model = model;
	}
	
	public void start() {
		engine.doSth();
		transmission.doTransmission();
	}
	
	
}
