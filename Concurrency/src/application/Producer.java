package application;

import java.security.SecureRandom;
import java.util.List;

public class Producer implements Runnable {

	private List<Integer> buffer;
	private int i = 0;
	private static final SecureRandom generator = new SecureRandom();
	
	
	public Producer (List<Integer> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run(){

		while (true) {
			/*
			 * This synchronized ensures that this block of code 
			 * only allows one thread is execute at a time
			 */
			synchronized (buffer) {
				while (!buffer.isEmpty()) {
					System.out.println("Buffer full, Producer waits");
					try {
						/*
						 * when the buffer is full, the producer thread must wait
						 * and this part of the code makes the producer thread wait
						 * indefinitely until that is Consumer thread notify this thread
						 * that it can attempt to add another number
						 */
						buffer.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				
			}
			
			synchronized (buffer) {
					buffer.add(++i);
					System.out.println("Producer adds " + i);
					if (i == 10) {
						i = 0;
					}
					
				try {
					Thread.sleep(generator.nextInt(1000));		
					/*
					 * This notifyAll or notify lets the consumer thread which might
					 * be 'waiting' that it can continue to execute its block of code
					 */
					buffer.notifyAll();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
			}
				
			}	
			System.out.println("(PRODUCER) Buffer: " + buffer.size());
		}
	}

}
