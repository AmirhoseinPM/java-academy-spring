package train.pooyan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import train.pooyan.entity.Item;

@Repository
@Transactional
public class ItemJpaRepository {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Item findById(int id) {
		return entityManager.find(Item.class, id);
	}
	public void deleteById(int id) {
		Item item = findById(id);
		entityManager.remove(item);
	}
	public Item update(Item item) {
		return entityManager.merge(item);
	}
	public Item insert(Item item) {
		return entityManager.merge(item);
	}
	public List<Item> findAll() {
		TypedQuery<Item> namedQuery = entityManager.createNamedQuery( 
				"find_all_items", Item.class);
		return namedQuery.getResultList();
	}
}
