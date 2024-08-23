package pooyan.train;

public class ClientA implements Client {
	Service service;
	
	public ClientA(Service service) {
		this.service = service;
	}
	
	@Override
	public void doTask() {
		// TODO Auto-generated method stub
		System.out.print("ClientA doing with ");
		service.serve();
	}
	
	public Service getService() {
		return this.service;
	}
	public void setService(Service service) {
		this.service = service;
	}
}
