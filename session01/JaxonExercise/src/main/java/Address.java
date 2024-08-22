
public class Address {
	private String city;
	private String local;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return city + "-" + local;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
}
