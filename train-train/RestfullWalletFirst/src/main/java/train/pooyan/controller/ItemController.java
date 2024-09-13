package train.pooyan.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import train.pooyan.model.Category;
import train.pooyan.model.CorruptedItem;
import train.pooyan.model.Item;
import train.pooyan.services.CategoryService;
import train.pooyan.services.CorruptedService;
import train.pooyan.services.ItemService;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	CorruptedService corruptedService;
	

	@Autowired
	CategoryService categoryService;
	
	
	
	@GetMapping(value = "/", produces = "application/xml")
	public String getAllItem() {
		
		XmlMapper mapper = new XmlMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		
		try {
			return mapper.writeValueAsString(itemService.getAll());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAllItem(@PathVariable Long id) {		
		Item item = itemService.getById(id);
		if (item == null) 
			return ResponseEntity.ok(
					new ErrorResponse("404", "NotFound", Arrays.asList("Item ID not found"))
					);
		return ResponseEntity.ok(item);
	}
	
	@PostMapping("/")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemService.createUpdate(item);
	}
	
	@DeleteMapping("/{id}")
	public void removeItem(@PathVariable Long id) {
		itemService.deleteById(id);
	}
	
	@DeleteMapping("/corrupt/{id}")
	public void removeCorrupted(@PathVariable Long id) {
		corruptedService.deleteById(id);
	}
	
	@GetMapping("/corrupt")
	public List<CorruptedItem> getAllCurroptItem() {
		return (List<CorruptedItem>) corruptedService.getAll();
	}
	
	@PostMapping(
			value = "/corrupt", 
			consumes = "application/json", 
			produces = "application/json")
	public CorruptedItem createCurroptItem(@RequestBody @Valid CorruptedItem corruptedItem) {
		return corruptedService.createUpdate(corruptedItem);
	}
	

	@DeleteMapping("/cat/{id}")
	public void removeCategoryById(@PathVariable Long id) {
		categoryService.deleteById(id);
	}
	
	@GetMapping("/cat")
	public List<Category> getAllCategories() {
		return categoryService.getAll();
	}
	
	@PostMapping("/cat")
	public Category createCategory(@RequestBody @Valid Category cat) {
		return categoryService.createUpdate(cat);
	}
		

}
