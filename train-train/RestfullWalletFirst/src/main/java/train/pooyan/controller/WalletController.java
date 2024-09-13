package train.pooyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import train.pooyan.model.Wallet;
import train.pooyan.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private WalletService walletService;

	@GetMapping(value = "/", produces = "application/json")
	public List<Wallet> get() {
		return walletService.get();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Wallet get(@PathVariable Long id) {
		return walletService.get(id);
	}
	
	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public Wallet create(@Valid @RequestBody Wallet wallet) {
		return walletService.create(wallet);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		walletService.deleteById(id);
	}
	
}
