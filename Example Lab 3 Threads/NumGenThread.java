/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wk3threadslab;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Shahzad Aslam-Mir
 */
public class NumGenThread implements Runnable {
    
   private final static SecureRandom m_randgen = new SecureRandom();
   private boolean m_run;
   private final int m_sleepTime; // random sleep time for thread
   private final String m_taskName; // name of task
   private double m_start;
   private double m_end;
   //private ConcurrentLinkedQueue<Double> m_queue;
   private ArrayList<Double> m_queue;
   private boolean m_sorted;
   
   //private static double m_rand = 0.0;
   
   // constructor
   public NumGenThread(String taskName, double s, double e, int stime )
   {
      m_taskName = taskName;
      m_start = s;
      m_end = e;
      m_sleepTime = stime; // 100 millisecs
      m_run = true;
      //this.m_queue = new ConcurrentLinkedQueue<Double>();
      this.m_queue = new ArrayList<Double>();
      m_sorted = false;
   } 
   
   // method run contains the code that a thread will execute
   public void run() 
   {
       while(m_run)
       {
            try {
                Thread.sleep(m_sleepTime);         
                postNum();
                m_sorted = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(NumGenThread.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
       } 
   }
   
   private double getNum() {   
       return m_start + 
              ( m_randgen.nextDouble() * (m_end - m_start) );
   }
   
   // also Try: private void postNum(){
   private synchronized void postNum(){
       if(!m_run)
           return;
       
       m_queue.add( getNum() );
       System.out.println("Task " + m_taskName + "added " + m_queue.size());// + ": " + m_queue);
       m_sorted = false;
   }
   
   // also Try public void doSort(){
   public synchronized void doSort(){
       if(!m_run)
           return;
       
       Collections.sort(m_queue);      
       System.out.println("Task " + m_taskName + "sorted " + m_queue.size());// + ": " + m_queue);
       m_sorted = true;
   }
   
   public final void stop(){
       m_run = false;
       printStatus();
   }
   
   public void printStatus(){
       System.out.println("Task " + m_taskName +" queue size: " + m_queue.size() +
               " : " + (m_sorted ? "sorted" : "unsorted") );
   }
    
}
