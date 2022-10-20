package application;
import java.lang.System.Logger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.logging.Level;

public class PrintTask implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private ArrayList<Double> queue;
	private final String taskName;
	private final int sleepTime;
	private double start;
	private double end;
	private boolean run;	
	private boolean sorted;
	
	public PrintTask(String taskName, int sleepTime, double start, double end) {
		this.taskName = taskName;
		this.sleepTime = sleepTime;
		this.start = start;
		this.end = end;
		this.run = true;
		this.queue = new ArrayList<Double>();
		this.sorted = false;
	}

	@Override
	public void run() {
			while (run) {
				try {
					Thread.sleep(sleepTime);
					postNum();
					sorted = false;
					 
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
				//System.out.printf("%s done sleeping%n",taskName);				
			}
	}
		
	private synchronized void postNum() {
		if(!run) {
			return;
		} 
		double randomNum = start + (generator.nextDouble() * (end-start));
		
		System.out.println(taskName + " generated random number: " + randomNum);
		//b
		queue.add(randomNum);
		System.out.println(taskName + " queue size: " + queue.size());
		sorted = false;
	}
	
	//d
	public synchronized void sort() {
		if(!run) {
			return;
		}
		
		Collections.sort(queue);
		System.out.println(taskName + " sorted. Current queue size: " + queue.size());
	    sorted = true;
	}
	
	public final void stop(){
	      run = false;
	      System.out.println("END: " + taskName +"'s final queue size: " + queue.size() + "\n" +
	    		 taskName + " is " + (sorted ? "sorted" : "unsorted") );
	}
	   	
	
	
}
