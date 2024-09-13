package train.pooyan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.pooyan.model.Wallet;
import train.pooyan.repositories.WalletRepository;

@Service
public class WalletService {

	@Autowired
	WalletRepository repo;
	
	public Wallet get(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public List<Wallet> get() {
		return (List<Wallet>) repo.findAll();
	}
	
	public Wallet create(Wallet wallet) {
		return repo.save(wallet);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
