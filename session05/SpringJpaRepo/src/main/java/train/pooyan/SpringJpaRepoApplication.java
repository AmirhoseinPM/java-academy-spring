package train.pooyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import train.pooyan.runner.BasicRunner;

@SpringBootApplication
public class SpringJpaRepoApplication{

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(SpringJpaRepoApplication.class, args);
				
		BasicRunner runner = context.getBean(BasicRunner.class);
		runner.run();
	}

}
