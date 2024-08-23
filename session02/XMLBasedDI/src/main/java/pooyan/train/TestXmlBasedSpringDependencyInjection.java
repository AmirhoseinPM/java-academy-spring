package pooyan.train;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlBasedSpringDependencyInjection {
	
	public static void main(String[] args) {
		System.out.println("test start");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
						"classpath:applicationContext.xml");
		
		// using constructor and setter
		Client client = (Client) context.getBean("Client1");
		client.doTask();
		
		
		Client otherClient = (Client) context.getBean("Client2");
		otherClient.doTask();
		
		// using static factory method
		Client client1 = (Client) context.getBean("Client3");
		client1.doTask();

		// using instance factory method
		Client client2 = context.getBean("Client4", Client.class);
		client2.doTask();
	}
	
}
