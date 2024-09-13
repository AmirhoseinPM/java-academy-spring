package train.pooyan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import train.pooyan.consume.rest.Quote;

@SpringBootApplication
public class RestfullWalletFirstApplication /* implements CommandLineRunner */{

	public static void main(String[] args) {
		SpringApplication.run(RestfullWalletFirstApplication.class, args);
	}
//	
//	@Autowired
//	RestTemplate restTemplate;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Quote quote = restTemplate.getForObject(
//				"http://localhost:8080/api/random", Quote.class);
//		System.out.println(quote.toString());
//		
//	}
}
