package train.pooyan.repositories;

import org.springframework.data.repository.CrudRepository;

import train.pooyan.model.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long> {

}
