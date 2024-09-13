package train.pooyan.repositories;

import org.springframework.data.repository.CrudRepository;

import train.pooyan.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
