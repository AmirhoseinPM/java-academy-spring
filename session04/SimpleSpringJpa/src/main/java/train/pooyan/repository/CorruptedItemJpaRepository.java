package train.pooyan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import train.pooyan.entity.CorruptedItem;

@Repository
@Transactional
public class CorruptedItemJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public CorruptedItem findById(int id) {
		return entityManager.find(CorruptedItem.class, id);
	}
	public void deleteById(int id) {
		CorruptedItem corruptedItem = findById(id);
		entityManager.remove(corruptedItem);
	}
	public CorruptedItem update(CorruptedItem corruptedItem) {
		return entityManager.merge(corruptedItem);
	}
	public CorruptedItem insert(CorruptedItem corruptedItem) {
		return entityManager.merge(corruptedItem);
	}
	public List<CorruptedItem> findAll() {
		TypedQuery<CorruptedItem> namedQuery = entityManager.createNamedQuery( 
				"find_all_corrupted_items", CorruptedItem.class);
		return namedQuery.getResultList();
	}
}
