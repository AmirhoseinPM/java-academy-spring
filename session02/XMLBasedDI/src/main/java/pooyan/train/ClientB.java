package pooyan.train;

public class ClientB implements Client{
	Service service;
	
	public ClientB(Service service) {
		this.service = service;
	}
	
	@Override
	public void doTask() {
		// TODO Auto-generated method stub
		System.out.print("ClientB doing with ");
		service.serve();
	}
	
	public Service getService() {
		return this.service;
	}
	public void setService(Service service) {
		this.service = service;
	}

}
