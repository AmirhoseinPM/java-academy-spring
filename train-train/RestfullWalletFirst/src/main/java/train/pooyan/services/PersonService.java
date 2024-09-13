package train.pooyan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.pooyan.model.Person;
import train.pooyan.model.Wallet;
import train.pooyan.repositories.PersonRepo;

@Service
public class PersonService {
	
	@Autowired	
	private PersonRepo repository;
	

	public Person getById(Long idLong) {
		return repository.findById(idLong).orElse(null);
	}
	
	public List<Person> getAll() {
		return (List<Person>) repository.findAll();
	}
	
	public Person createUpdate(Person person) {
		person.addWallet(new Wallet());
		return repository.save(person);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Person person) {
		repository.delete(person);
	}
	
}
