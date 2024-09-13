package train.pooyan.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(generator = "SEQUENCE")
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
							CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable( 
			name = "item_category", 
			joinColumns = @JoinColumn(name="category_id"), 
			inverseJoinColumns = @JoinColumn(name = "item_id"))
	@JsonProperty( access = Access.WRITE_ONLY)
	private Set<Item> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public void add(Item item) {
		if (items == null)
			items = new HashSet<>();
		items.add(item);
	}
}
