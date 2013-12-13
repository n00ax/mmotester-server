package mmotest.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class PlayerThreadManager {
	private boolean isRunning;
	private Queue<Integer> WaitingRequest;
	private int ThreadSize;
	private ArrayList<Short> VectorPort;
	public PlayerThreadManager(){
		WaitingRequest = new LinkedList<Integer>();
		VectorPort = new ArrayList<Short>();
	}
	public void ListenThread(){
		while(isRunning==true){
			/*Handle Thread Request*/
			WaitingRequest.add(ThreadSize);
			/*END Handle Request*/
			/*Give Thread To First In Queue(FIFO)*/
			/*END GIVE Request*/
		}
	}
	public void SpawnThread(int port){
		
	}
}
