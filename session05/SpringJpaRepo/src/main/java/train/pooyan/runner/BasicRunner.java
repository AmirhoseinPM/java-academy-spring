package train.pooyan.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import train.pooyan.entity.Category;
import train.pooyan.entity.Item;
import train.pooyan.repository.CategoryRepository;
import train.pooyan.repository.ItemJpaRepository;

@Component
public class BasicRunner {
	
	@Autowired
	ItemJpaRepository itemJpaRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public void run() {
		Category cat1 = categoryRepository.save(new Category("cat1", "loc1"));
		System.out.println(cat1);
		
		
		Item item = new Item("item1", new Category("cat", "loc"));
		item = itemJpaRepository.save(item);
		System.out.println(item);
		
		item.setCategory(new Category("itemUpdated", "itemUpdated"));
		itemJpaRepository.save(item);
		
		createMoreItems();

		Arrays.asList(itemJpaRepository.findAll())
			.stream().forEach(System.out::println);

		Arrays.asList(categoryRepository.findAll())
			.stream().forEach(System.out::println);
		
		System.out.println("==--==-=-=-=--==-=--=-=-=-=-==--==-=-");
		
		System.out.println("\n item with name item1: " +  "\n" +
						itemJpaRepository.findByName("item1"));

		System.out.println("\n item with category name cat3: " +  "\n" +
						itemJpaRepository.findByCategory_Name("cat3"));

		System.out.println("\n item with category name starts with cat: " +  "\n" +
						itemJpaRepository.findByCategory_NameStartingWith("cat"));
		
		System.out.println("\n item with category location starting with 'loc' (order by category name Descending): \n" +
				itemJpaRepository.findByCategory_LocationStartingWithOrderByCategory_NameDesc("lo"));
		
	}

	private void createMoreItems() {
		Item item1 = new Item("item1", new Category("cat2", "ox2"));
		item1 = itemJpaRepository.save(item1);
		System.out.println(item1);
		Item item2 = new Item("item1", new Category("acat3", "locZ"));
		item2 = itemJpaRepository.save(item2);
		System.out.println(item2);
		Item item3 = new Item("item1", new Category("zcat4", "log4"));
		item3 = itemJpaRepository.save(item3);
		System.out.println(item3);
		Item item4 = new Item("item1", new Category("pcat5", "loc4"));
		item4 = itemJpaRepository.save(item4);
		System.out.println(item4);
		
	}
	
}
