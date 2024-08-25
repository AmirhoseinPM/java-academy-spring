package ir.freeland.spring.selectbean;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ir.freeland.spring.selectbean.service.BankiranServices;

public class SelectbeanApplication {
	
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_selectbean.xml");
		BankiranServices  bankiranServices = context.getBean("bankIranService", BankiranServices.class);
		bankiranServices.accountTransaction("136-800-384123");
		System.out.println("---");
	}

}
