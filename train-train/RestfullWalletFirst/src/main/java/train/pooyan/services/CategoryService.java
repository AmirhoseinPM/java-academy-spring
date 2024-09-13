package train.pooyan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.pooyan.model.Category;
import train.pooyan.model.Item;
import train.pooyan.repositories.CategoryRepo;
import train.pooyan.repositories.ItemRepository;

@Service
public class CategoryService {
	
	@Autowired	
	private CategoryRepo repository;
	

	public Category getById(Long idLong) {
		return repository.findById(idLong).orElse(null);
	}
	
	public List<Category> getAll() {
		return (List<Category>) repository.findAll();
	}
	
	public Category createUpdate(Category cat) {
		return repository.save(cat);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public void delete(Category cat) {
		repository.delete(cat);
	}
	
}
