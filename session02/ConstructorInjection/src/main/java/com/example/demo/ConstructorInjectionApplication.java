package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConstructorInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructorInjectionApplication.class, args);
		System.out.println();
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		Car bmw = context.getBean(Car.class);
		System.out.println("Car bean start...");
		bmw.start();
		System.out.println(bmw.model);
	}

}
