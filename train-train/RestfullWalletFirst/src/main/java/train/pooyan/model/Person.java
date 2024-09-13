package train.pooyan.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "phone number is required")
	@Pattern(regexp = "^\\d{11}$", 
			 message = "Your phone number is not valid!!")
	private String phoneNumber;

	@NotNull(message = "firstName is required")
	@Size(min = 3, max = 50 , 
		message = "last name must be between 3 and 50")
	private String firstName;

	@NotNull(message = "lastName is required")
	@Size(min = 3, max = 50 , 
			message = "last name must be between 3 and 50")
	private String lastName;

	@NotNull(message = "birtDate is required in yyyy-MM-dd format")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // yyyy-MM-dd format
	private LocalDate birtDate;

	@NotNull(message = "gender is required")
	@Pattern(regexp = "^(MALE|FEMALE|OTEHRS)$", 
					message = "gender is not accepted, choices are 'MALE', 'FEMALE' and 'OTHERS'")
	private String gender;


	
	@Pattern(regexp = "^(INCLUDED|EXCUSED|FINISHED|ABSENCE)$", 
					message= "military status entered here is not valid, choices are 'INCLUDED', 'EXCUSED', 'FINISHED', 'ABSENCE'")
	private String militaryStatus;


	@NotNull(message = "phone number is required")
	@Email(message = "Non valid email field")
	private String email;
	
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL) 
	// mapped by refers to Person field name in Wallet ManyToOne relation  
	@JsonProperty
	private Set<Wallet> wallets;
	 
	
	
	// add wallet for person in service layer
	public void addWallet(Wallet wallet) {
		if (wallets == null) {
			wallets = new HashSet<>();
		}
		wallets.add(wallet);
		wallet.setPerson(this);
	}
	
	
	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMilitaryStatus() {
		return militaryStatus;
	}

	public void setMilitaryStatus(String militaryStatus) {
		this.militaryStatus = militaryStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
	
}
