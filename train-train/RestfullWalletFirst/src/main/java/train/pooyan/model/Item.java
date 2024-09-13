package train.pooyan.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private double price;

	
	@ManyToMany(cascade = { 
			CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "item_category", 
			joinColumns = @JoinColumn(name = "item_id"), 
			inverseJoinColumns =@JoinColumn(name = "category_id"))
	private Set<Category> categories;
	

	@OneToOne(mappedBy = "item", fetch = FetchType.LAZY)
	private CorruptedItem corruptedItem;
	
	public void setCorruptedItem(CorruptedItem corruptedItem) {
		this.corruptedItem = corruptedItem;
	}
	public CorruptedItem getCorruptedItem() {
		return corruptedItem;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public void add(Category category) {
		if (categories == null)
			categories = new HashSet<>();
		
		categories.add(category);
		category.add(this);
	}

}
