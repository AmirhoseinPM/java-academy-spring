package ir.freeland.spring.selectbean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ir.freeland.spring.selectbean.service.BankiranServices;

@SpringBootApplication
public class SelectbeanApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext_selectbean.xml");
		MyBankIranService mybankIranService = context.getBean(MyBankIranService.class);
		BankiranServices bankiranServices = mybankIranService.getbankiranServices();
		bankiranServices.accountTransaction("136-800-384123");

	}

}
