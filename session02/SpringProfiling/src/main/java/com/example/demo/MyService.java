package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MyService {
	@Autowired
	Environment env;	
	SubService subService;
	
	@Autowired
	public MyService(SubService subService) {
		this.subService = subService;
	}
	
	
	
	public void serve() {
		
		System.out.println("serving....");
		System.out.println(env.acceptsProfiles("development"));
		
		if (env.acceptsProfiles("development"))
			System.out.println(
					"service running based on development environment and resources");
		
		else if (env.acceptsProfiles("test"))
			System.out.println(
					"service running based on test environment and resources");
		
		else if (env.acceptsProfiles("production"))
			System.out.println(
					"service running based on production environment and resources");
		
		subService.subServe();
	}
}
