package application;
import java.security.SecureRandom;


//i
public class Consumer implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;
	
	public Consumer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}

	@Override
	public void run() {

		while (true) {
			
			while (sharedLocation.getBufferSize() < 70) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException exception) {
					Thread.currentThread().interrupt();
				}
			}
			
			try {
				
				Thread.sleep(generator.nextInt(1000));
				sharedLocation.removePkt();
				System.out.println("The buffer size after consumer: " + 
						sharedLocation.getBufferSize());
			} catch (InterruptedException exception) {
				Thread.currentThread().interrupt();
				
			}

		}

	}
	
	
}
