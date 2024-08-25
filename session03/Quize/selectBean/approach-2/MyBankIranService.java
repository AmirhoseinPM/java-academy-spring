package ir.freeland.spring.selectbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ir.freeland.spring.selectbean.service.BankiranServices;

@Component
public class MyBankIranService {
	@Autowired
	@Qualifier("edb")
	private BankiranServices bankiranServices;
	
	public BankiranServices getbankiranServices() {
		return this.bankiranServices;
	}
}
