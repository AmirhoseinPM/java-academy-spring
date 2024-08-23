package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SpringProfilingApplication {
	
	@Autowired
	private static ConfigurableEnvironment env;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProfilingApplication.class, args);

		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(
						Config.class);
		
		MyService service = context.getBean(MyService.class);
		service.serve();
		
	}

}
