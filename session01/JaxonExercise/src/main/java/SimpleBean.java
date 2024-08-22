import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleBean {
	@JsonProperty("Xnour")
	private int x; // XML tag name = Xnour 
	private int y;
	public SimpleBean() {
		this(1, 1);
	}
	public SimpleBean(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x: " + x + " , " + "y: " + y;
	}
}
