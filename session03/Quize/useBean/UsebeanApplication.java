package ir.freeland.spring.usebean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UsebeanApplication {
  public static void main(String[] args) {
	  
	ApplicationContext context = SpringApplication.run(UsebeanApplication.class, args);
	
    InternetbankServices internetbankServices = context.getBean(InternetbankServices.class);

    internetbankServices.doCardToCard("6274.1211.6623.6810","6037.9919.1267.1343");
    }
}
