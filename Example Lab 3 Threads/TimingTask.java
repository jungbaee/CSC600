/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wk3threadslab;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Shahzad Aslam-Mir
 */
public class TimingTask extends TimerTask {
    private Timer m_timer;
    private List<NumGenThread> m_threads;
    
    public TimingTask( List<NumGenThread> ths, Timer t)
    {
        m_threads = ths;
        m_timer = t;
    }
    
    public void run()
    {
        System.out.println("Shutting down threads - Time's up!");
        for( NumGenThread nt : m_threads )
            nt.stop();
        
        m_timer.cancel(); //Terminate the timer thread
    }
    
}
