package ir.freeland.spring.selectbean.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("edb")
public class EDBBankiranServices implements BankiranServices {

	@Override
	public File accountTransaction(String accountNumber) {
		System.out.println("EDB");
		return new File("account-report");
	}
}