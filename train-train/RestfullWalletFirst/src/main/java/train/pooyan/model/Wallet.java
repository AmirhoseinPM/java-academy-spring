package train.pooyan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
					CascadeType.PERSIST, CascadeType.REFRESH}
			)
	@JoinColumn(name="person_id") // this name used in wallet table for person column name,
	@JsonProperty(access = Access.WRITE_ONLY) // this access prevent Loop in reading person object.
	private Person person; // this field name used in mappedBy parameter of OneToMany in Person table 
	
	@Min(0)
	private Double balance;
	
	
	// Constructors
	
	public Wallet() {
		balance = 0.0;
	};

	
	// getters and setters 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
