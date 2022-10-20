package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		/* 1.i
		 * Java enables multi-threading and that means that we can utilize 
		 * different parts of the CPU concurrently. However, while this might 
		 * speed up certain processes, when producer and consumer does not 
		 * coordinate properly (or synchronize) there might be memory inconsistency. 
		 * That is the producer will attempt to produce data when the buffer is 
		 * actually full and the consumer might attempt to consume data when there 
		 * is no data in the buffer. In order to fix this issue, Java added the newer
		 *  data structure ‘ArrayBlockingQueue’ to be thread safe but we can use the 
		 *  wait() and notifyAll() methods to let each thread know when it is their 
		 *  turn to access a certain block of code which I will be demonstrating below.
		 */
		
		List <Integer> buffer = new ArrayList<>();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		System.out.println();
		executorService.execute(new Producer(buffer));
		executorService.execute(new Consumer(buffer));
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}

}
