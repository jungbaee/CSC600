/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wk3threadslab;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahzad Aslam-Mir
 */
public class SorterThread implements Runnable {
    
    private final static SecureRandom m_randtime = new SecureRandom();
    private int m_sleepTime; // random sleep time for thread
    private boolean m_run = false;
    private final String m_taskName; // name of task
    private List<NumGenThread> m_threads = null;

    public SorterThread( String name, List<NumGenThread> threads )
    {
        m_taskName = name;
        m_threads = threads;  
        m_sleepTime = m_randtime.nextInt(1000);//400; //m_randtime.nextInt(5000);
        m_run = true;
    }
    
    public void run() 
   {
       while(m_run)
       {
            try {
                m_sleepTime = m_randtime.nextInt(100);
                Thread.sleep(m_sleepTime); 
                for( NumGenThread ngt : m_threads )
                    ngt.doSort();

            } catch (InterruptedException ex) {
                Logger.getLogger(NumGenThread.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
       } 
   }
    
    public final void stop(){
       m_run = false;
   }
}
