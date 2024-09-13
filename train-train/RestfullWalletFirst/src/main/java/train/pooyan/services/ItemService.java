package train.pooyan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.pooyan.model.Category;
import train.pooyan.model.CorruptedItem;
import train.pooyan.model.Item;
import train.pooyan.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired	
	private ItemRepository repository;
	
	@Autowired
	private CorruptedService corruptedService;
	

	public Item getById(Long idLong) {
		return repository.findById(idLong).orElse(null);
	}
	
	public List<Item> getAll() {
		return (List<Item>) repository.findAll();
	}
	
	public Item createUpdate(Item item) {
		item = repository.save(item);
		for(Category cat : item.getCategories())
			cat.add(item);		
		return item;
	}
	
	
	public void deleteById(Long id) {
		Item item = getById(id);
		CorruptedItem cr = item.getCorruptedItem();
		if (cr != null)
			corruptedService.delete(cr);			
		repository.deleteById(id);
	}
	
	public void delete(Item item) {
		repository.delete(item);
	}
	
}
