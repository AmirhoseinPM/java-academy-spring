import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public final class Person {
	@JsonInclude
	private String firstName;
	@JsonInclude
	private String lastName;	
	@JsonInclude
    @JacksonXmlElementWrapper(useWrapping = false)
	private List<String> phoneNumbers = new ArrayList<>(); 
	@JsonInclude   
    private List<Address> addresses = new ArrayList<>();

	
	public void addPhoneNumbers(String phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}	
	
    public void addAddress(String city, String local) {
    	Address address = new Address();
    	address.setCity(city);
    	address.setLocal(local);
    	addresses.add(address);    	
    }
	
	
	public List<Address> getAddreses() {
		return this.addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<String> getPhoneNumbers() {
		return this.phoneNumbers;
	}
	
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fullName) {
		this.firstName = fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + firstName + " " + lastName + ": " + "\n" +
				"phones: " + phoneNumbers.toString()  + "\n" +
				"addresses: " + addresses.toString() + ")";
	}
}
