package ir.freeland.spring.selectbean.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("edb")
public class EDBBankiranServices implements BankiranServices {

	@Override
	public File accountTransaction(String accountNumber) {
		System.out.println("EDB");
		return new File("account-report");
	}
}