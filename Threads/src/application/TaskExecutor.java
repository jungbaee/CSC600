package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TaskExecutor {
	
	public static void main (String[] args) {
		
		//5mins
		final long TIME = 300000;
		
		//a.i5-10 b.100
		PrintTask task1 = new PrintTask("Task1", 100, 5.0, 10.0);
		//a.i15-20 b.200
		PrintTask task2 = new PrintTask("Task2", 200, 15.0, 20.0);
		//a.i25-30 b.300
		PrintTask task3 = new PrintTask("Task3", 400, 25.0, 30.0);
		//a.35-40 b.400... I believe this was a typo(25) in the pdf?
		PrintTask task4 = new PrintTask("Task4", 800, 35.0, 40.0);
		//a.45-50 b.500
		PrintTask task5 = new PrintTask("Task5", 1600, 45.0, 50.0);
		
		//c.
		List<PrintTask> p = new ArrayList<PrintTask>();
		p.add(task1);
		p.add(task2);
		p.add(task3);
		p.add(task4);
		p.add(task5);

		//d.
		SortTask task6 = new SortTask("Task6", p);
		
		System.out.println("Starting Exectuor");
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(task1);
		executorService.execute(task2);
		executorService.execute(task3);	
		executorService.execute(task4);
		executorService.execute(task5);
		executorService.execute(task6);
		executorService.shutdown();
		
		System.out.printf("Tasks started, main ends. %n%n");
		
		Timer timer = new Timer();
		//TimerTask tt = new TimerTask();
		timer.schedule(new MyTimerTask(timer, p), TIME);
		
		
	}
}
