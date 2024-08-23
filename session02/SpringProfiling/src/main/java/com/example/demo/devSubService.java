package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("development")
public class devSubService implements SubService {
	@Override
	public void subServe() {
		// TODO Auto-generated method stub
		System.out.println("development sub service run");
	}
}
