/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wk3threadslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahzad Aslam-Mir
 */
public class Wk3ThreadsLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // run for 1 min
        long minutes = 1;
        Timer tmr = new Timer();
               
        try
        {
            // create and name each runnable
            NumGenThread task1 = new NumGenThread("ntask1", 5.0, 10.0, 100 );
            NumGenThread task2 = new NumGenThread("ntask2", 15.0, 20.0, 200 );
            NumGenThread task3 = new NumGenThread("ntask3", 25.0, 30.0, 300 );
            NumGenThread task4 = new NumGenThread("ntask4", 35.0, 40.0, 400 );
            NumGenThread task5 = new NumGenThread("ntask5", 45.0, 50.0, 500 );

            List<NumGenThread> ths = new ArrayList<NumGenThread>();
            ths.add(task1);
            ths.add(task2);
            ths.add(task3);
            ths.add(task4);
            ths.add(task5);

            SorterThread sorter = new SorterThread("sorter", ths);

            System.out.println("Starting Executor");

            // create ExecutorService to manage threads
            ExecutorService executorService = Executors.newCachedThreadPool();

            // start the three PrintTasks
            executorService.execute(task1); // start task1
            executorService.execute(task2); // start task2
            executorService.execute(task3); // start task3
            executorService.execute(task4); // start task4
            executorService.execute(task5); // start task5
            Thread.sleep(100);
            executorService.execute(sorter);      
            executorService.shutdown(); 
            System.out.printf("Tasks started, main ends.%n%n");
            
            // now run threads for 5 mins and forcibly close them
            tmr.schedule( new TimingTask(ths,tmr), minutes*60*1000 );
            
            // sorter.stop(); // <- question students - what does this do ?
    
        }
        catch( InterruptedException ex )
        {
            Logger.getLogger(NumGenThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
