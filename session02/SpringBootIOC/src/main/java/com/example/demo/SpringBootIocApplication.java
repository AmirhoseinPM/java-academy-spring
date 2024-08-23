package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootIocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIocApplication.class, args);
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println();
		System.out.println("Client1 Bean initialization ");
		Client ClientBean1 = context.getBean("client1", Client.class);
		ClientBean1.doSomethings();

		System.out.println();
		System.out.println("Client2 Bean initialization ");
		Client ClientBean2 = context.getBean("client2", Client.class);
		ClientBean2.doSomethings();
	}

}
