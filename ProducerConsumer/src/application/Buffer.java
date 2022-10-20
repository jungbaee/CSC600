package application;

import java.util.concurrent.ArrayBlockingQueue;

public class Buffer  {

	private final ArrayBlockingQueue<Packet> buffer = new ArrayBlockingQueue<Packet>(500);
	//private boolean occupied = false;
	Packet packet = new Packet();
	private int i = 0;
	
	public Buffer() {}
	
	public void insertPkt () throws InterruptedException {
		packet.setStr(String.valueOf(i++));
		buffer.put(packet);
		System.out.println("Producer writes " + buffer.peek().toString());
	}
	
	public void removePkt() throws InterruptedException {
		if(!buffer.isEmpty())
			System.out.println("Consumer reads " + buffer.take().toString());
		
	}

	public int getBufferSize() {
		return buffer.size();
	}	
}
