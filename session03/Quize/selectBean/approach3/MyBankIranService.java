package ir.freeland.spring.selectbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import ir.freeland.spring.selectbean.service.BankiranServices;

@Component
@PropertySource("classpath:application.properties")
public class MyBankIranService {
	@Autowired
	private BankiranServices bankiranServices;
	
	public BankiranServices getbankiranServices() {
		return this.bankiranServices;
	}
}
