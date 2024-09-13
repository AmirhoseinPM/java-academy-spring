package train.pooyan.repositories;

import org.springframework.data.repository.CrudRepository;

import train.pooyan.model.Person;

public interface PersonRepo extends CrudRepository<Person, Long>{

}
