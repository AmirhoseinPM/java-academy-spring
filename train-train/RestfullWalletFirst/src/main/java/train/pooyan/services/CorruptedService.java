package train.pooyan.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.pooyan.model.CorruptedItem;
import train.pooyan.model.Item;
import train.pooyan.repositories.CorruptedItemRepo;
import train.pooyan.repositories.ItemRepository;

@Service
public class CorruptedService {
	
	@Autowired	
	private CorruptedItemRepo repository;
	@Autowired
	private ItemRepository itemRepo;
	

	public CorruptedItem getById(Long idLong) {
		return repository.findById(idLong).orElse(null);
	}
	
	public List<CorruptedItem> getAll() {
		return (List<CorruptedItem>) repository.findAll();
	}
	
	public CorruptedItem createUpdate(CorruptedItem corruptedItem) {
		Item item = null;
		if (corruptedItem.getItem() != null) {
			 Long itemId = corruptedItem.getItem().getId();
			 item = itemRepo.findById(itemId).orElse(null);
		}		
		corruptedItem.setItem(null);
		corruptedItem = repository.save(corruptedItem);
		if (item != null) {
			corruptedItem.setItem(item);
			item.setCorruptedItem(corruptedItem);
			itemRepo.save(item);
		}
		return corruptedItem;
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(CorruptedItem item) {
		repository.delete(item);
	}
	
}
