package train.pooyan.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name="find_all_corrupted_items", query = "select ci from CorruptedItem ci")
public class CorruptedItem {

	@Id
	@GeneratedValue
	private int id;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;


	public CorruptedItem() {};
	
	public CorruptedItem(int id, Item item) {
		super();
		this.id = id;
		this.item = item;
	}
	
	public CorruptedItem(Item item) {
		super();
		this.item = item;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "CorruptedItem [id=" + id + ", item=" + item + "]";
	}
	
	
}
