package application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main (String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
//		ScheduledExecutorService executorScheduledService = Executors.newSingleThreadScheduledExecutor();
//		int consumerCounter = 0;
		
		Buffer sharedLocation = new Buffer();

		System.out.println("-----------------------------");
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		//9 additional consumers needed to balance out the producers packets
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		
		//there is about 1:10 difference between the producer sleep time and consumer blocking time
		
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		

	}
	
}
