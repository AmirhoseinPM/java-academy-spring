package train.pooyan.repositories;

import org.springframework.data.repository.CrudRepository;

import train.pooyan.model.CorruptedItem;

public interface CorruptedItemRepo extends CrudRepository<CorruptedItem, Long> {

}
