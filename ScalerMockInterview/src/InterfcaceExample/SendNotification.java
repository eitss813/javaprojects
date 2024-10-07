package InterfcaceExample;

public class SendNotification implements Notification{
	@Override
	public void sendSmas() {

		System.out.println("SMS sent");
	}

	@Override
	public void sendEmail() {
		System.out.println("Email sent");
	}
}
