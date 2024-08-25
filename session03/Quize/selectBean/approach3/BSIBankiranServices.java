package ir.freeland.spring.selectbean.service;

import java.io.File;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component()
@Profile("bsi")
public class BSIBankiranServices implements BankiranServices {

	@Override
	public File accountTransaction(String accountNumber) {
		System.out.println("BSI");
		return new File("account-report");
	}
}