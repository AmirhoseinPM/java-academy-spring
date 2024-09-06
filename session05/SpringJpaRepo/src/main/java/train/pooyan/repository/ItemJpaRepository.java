package train.pooyan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import train.pooyan.entity.Item;

public interface ItemJpaRepository extends CrudRepository<Item, Integer> {
	List<Item> findByName(String name);
	List<Item> findByCategory_Name(String name);
	List<Item> findByCategory_NameStartingWith(String string);
	
	List<Item> findByCategory_LocationStartingWithOrderByCategory_NameDesc(String loc);
}
