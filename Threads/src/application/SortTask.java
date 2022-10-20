package application;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTask implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private List<PrintTask> printTasks = new ArrayList<PrintTask>();
	private final String taskName;
	private int sleepTime;
	private double start;
	private double end;
	private boolean run;	
	private boolean sorted;
	
	public SortTask (String taskName, List<PrintTask> printTasks) {
		this.taskName = taskName;
		this.printTasks = printTasks;
		this.sleepTime = generator.nextInt(1000);
		this.run = true;		
	}
	
	public void run() {
		while (run) {
			try {
				sleepTime = generator.nextInt(500);
				Thread.sleep(sleepTime);
				
				for (PrintTask p : printTasks) {
					p.sort();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		
	}
	
}
