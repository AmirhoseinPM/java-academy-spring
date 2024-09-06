package train.pooyan.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import train.pooyan.entity.CorruptedItem;
import train.pooyan.entity.Item;
import train.pooyan.repository.CorruptedItemJpaRepository;
import train.pooyan.repository.ItemJpaRepository;

@Component
public class BasicRunner {
	
	@Autowired
	ItemJpaRepository itemJpaRepository;
	
	@Autowired
	CorruptedItemJpaRepository corruptedItemJpaRepository;
	
	public void run() {
		
		Item item1 = itemJpaRepository.insert( 
				new Item("item1", "category1"));
		item1.setCategory("changed");
		item1 = itemJpaRepository.update(item1);
		
		Item item2 = itemJpaRepository.insert( 
				new Item("item2", "category2"));
				
		CorruptedItem corruptedItem = 
				corruptedItemJpaRepository.insert( 
						new CorruptedItem(item2));		
		
		printTables();
		

		itemJpaRepository.deleteById(item1.getId());
		// if we want to delete item2
		// we first need to delete corruptedItem2 
		// that related to item2
		corruptedItemJpaRepository.deleteById(corruptedItem.getId());
		// if item cascade equals ALL or REMOVE
		// item2 automatically removed
		System.out.println("all items: " + 
				itemJpaRepository.findAll()
				);

		printTables();	
		
	}

	private void printTables() {
		System.out.println("all items: " + 
					itemJpaRepository.findAll().toString()
					);
		System.out.println("all corrupted: " + 
					corruptedItemJpaRepository.findAll().toString()
					);
	}
	
}
