package train.pooyan.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name="find_all_items", query = "select i from Item i")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
	
	
	public Item() {};
	
	public Item(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}
	
	public Item(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
	
}
