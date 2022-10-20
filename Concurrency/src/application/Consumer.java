package application;

import java.security.SecureRandom;
import java.util.List;

public class Consumer implements Runnable {

	private List<Integer> buffer;
	private static final SecureRandom generator = new SecureRandom();
	
	public Consumer (List<Integer> buffer) {
		this.buffer = buffer;
	}
	
	
	@Override
	public void run() {
		
		while (true) {
			/* this synchronized block of code will ensure that only the 
			 * consumer thread is being executed at this time 
			 */
			synchronized (buffer) {
				while (buffer.isEmpty()) {
					System.out.println("Buffer Empty, consumer waits");
					try {
						/*
						 * when buffer is empty, the consumer thread cannot 'remove'
						 * or take a value and would be an error.
						 * Therefore, it waits and waits for the producer thread 
						 * to 'notify' it that it has executed a block of code that
						 * would have added a new value to the buffer for this
						 * consumer thread to read
						 */
						buffer.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				
				
			}
		
			synchronized (buffer) {
				try {
					Thread.sleep(generator.nextInt(1000));
					System.out.println("Consumer reads " + buffer.remove(0));
					/* like the producer thread, the consumer must let the other threads
					 * that it has completed its block of code and is going to sleep.
					 * By notifying the other threads, this prevents the deadlock situation
					 ** 
					 */
					buffer.notifyAll();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			
			System.out.println("(CONSUMER) Buffer: " + buffer.size());
		}
		
	}

}
