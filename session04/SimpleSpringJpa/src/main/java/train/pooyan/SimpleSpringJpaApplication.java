package train.pooyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import train.pooyan.runner.BasicRunner;
import train.pooyan.runner.RunnerWithoutRepo;

@SpringBootApplication
public class SimpleSpringJpaApplication{

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(SimpleSpringJpaApplication.class, args);
				
		RunnerWithoutRepo runnerWithoutRepo = context.getBean(RunnerWithoutRepo.class);
		runnerWithoutRepo.run();

//		BasicRunner runner = context.getBean(BasicRunner.class);
//		runner.run();
	}

}
