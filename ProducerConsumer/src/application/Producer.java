package application;
import java.security.SecureRandom;

//i
public class Producer implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;
	
	public Producer (Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(generator.nextInt(100));
				sharedLocation.insertPkt();
				System.out.println("The buffer size after producer: " + 
						sharedLocation.getBufferSize());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				
			}
			
		}
		
		
	}

}
