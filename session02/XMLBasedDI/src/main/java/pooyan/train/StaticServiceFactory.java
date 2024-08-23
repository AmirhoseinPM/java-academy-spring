package pooyan.train;

public class StaticServiceFactory {
	public static Service getService(int num) {
		if (num == 0)
			return new MessageService();
		else
			return new EmailService();
	}
}
