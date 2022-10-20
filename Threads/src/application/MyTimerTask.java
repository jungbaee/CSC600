package application;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
	private Timer timer;
	private List<PrintTask> p;
	
	public MyTimerTask (Timer timer, List<PrintTask> p) {
		this.timer = timer;
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (PrintTask p : p) {
			p.stop();
		}
		
		timer.cancel();
	}
	
	
	
}
