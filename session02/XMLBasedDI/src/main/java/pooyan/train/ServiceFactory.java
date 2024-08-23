package pooyan.train;

public class ServiceFactory {
	public Service getService(int num) {
		if (num == 1)
			return new MessageService();
		else
			return new EmailService();
	}
}
