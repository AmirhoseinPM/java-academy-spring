package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("production")
public class ProdSubService implements SubService {
	@Override
	public void subServe() {
		// TODO Auto-generated method stub
		System.out.println("production sub service run...");
	}
}
