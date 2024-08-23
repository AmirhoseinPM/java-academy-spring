package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Client {
	private Service service;
	
	public void doSomethings() {
		System.out.println("Client do sth with service: ");
		service.serve();
	}

	public Client() {
	}
	
	public Client(Service service) {
		this.service = service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
}
