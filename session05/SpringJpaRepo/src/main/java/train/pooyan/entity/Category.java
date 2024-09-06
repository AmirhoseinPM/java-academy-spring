package train.pooyan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private long id;	
	private String name;
	private String location;
	
	public Category() {};
	
	public Category(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	public Category(long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
}
