package train.pooyan.runner;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import train.pooyan.entity.CorruptedItem;
import train.pooyan.entity.Item;

@Component
public class RunnerWithoutRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void run() {
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.getTransaction();		
		
		createItems(session, transaction);		
		createCorruptedItems(session, transaction);	
		
		updateItem2(session, transaction);

		deleteUnrelatedItem1(session, transaction);
		deleteRelatedItem4(session, transaction); // item4 not been deleted
		printItems(session, transaction);		

		//delete corrupted item and related item to it
		deleteCorruptedItem(session, transaction);		
		
		printItems(session, transaction);
		printCorruptedItems(session, transaction);
	}

	private void updateItem2(Session session, Transaction transaction) {
		transaction.begin();
		Item item = session.createQuery("from Item where id=2", 
				Item.class).getSingleResult();
		item.setCategory("category changed");
		transaction.commit();
	}

	private void deleteCorruptedItem(Session session, Transaction transaction) {
		transaction.begin();
		List<CorruptedItem> cItems = session.createQuery("from CorruptedItem", 
				CorruptedItem.class).getResultList();
		cItems = cItems.stream()
				.filter(c -> c.getItem().getId() == 4)
				.collect(Collectors.toList());
		session.remove(cItems.get(0));
		transaction.commit();
	}

	private void deleteUnrelatedItem1(Session session, Transaction transaction) {
		transaction.begin();
		Item item1 = session.createQuery("from Item where id=1", Item.class).getSingleResult();
		session.remove(item1);
		transaction.commit();
	}
	
	private void deleteRelatedItem4(Session session, Transaction transaction) {
		transaction.begin();
		Item item4 = session.createQuery("from Item where id=3", Item.class).getSingleResult();
		session.remove(item4);
		transaction.commit();
	}

	private void printCorruptedItems(Session session, Transaction transaction) {
		transaction.begin();
    	List<CorruptedItem> allCorruptedItems = session.createQuery("from CorruptedItem" , 
    			CorruptedItem.class).getResultList();
    	allCorruptedItems.stream()
    		.forEach(System.out::println); 	
    	transaction.commit();
	}

	private void printItems(Session session, Transaction transaction) {
		transaction.begin();
    	List<Item> allItems = session.createQuery("from Item" , 
    			Item.class).getResultList();
    	allItems.stream()
    		.forEach(System.out::println);    	
    	transaction.commit();
	}

	private void createCorruptedItems(Session session, Transaction transaction) {

		System.out.println();
		System.out.println();
		
		transaction.begin();
		session.persist(new CorruptedItem(
					new Item("i3", "c3")
				));
		session.persist(new CorruptedItem(
				new Item("i4", "c4")
			));
		transaction.commit();
	}

	private void createItems(Session session, Transaction transaction) {

		System.out.println();
		System.out.println();
		
		transaction.begin();
		session.persist(new Item("i1", "c1"));
		session.persist(new Item("i2", "c2"));
		transaction.commit();
	}
}
