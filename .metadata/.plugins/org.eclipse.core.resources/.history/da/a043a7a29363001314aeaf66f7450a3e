package mmotest.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import mmotest.constants.Constants;
import mmotest.exception.ExceptionHandler;
import mmotest.io.PrintWriter;

public class PlayerThread {
	private int plid;
	private int encryptionBlock1, encryptionBlock2, encryptionBlock3, encryptionBlock4;
	private String playername, password;
	private long plip;
	private int plright;
	private ServerSocket servSocket;
	private Socket cliSocket;
	private enum PlayerRight{
		PLAYER, GM, SUPPORT , S2, ADMIN, DEV
	} //Player = Lowest DEV = Highest(USED ONLY FOR DEV SERVER)
	public PlayerThread(int port){
		if(port>Constants.MAXPORT){
			PrintWriter.println("Port Allocation Err: TOO LARGE, instance "+plid);
			System.exit(1);
		}
		if(port<Constants.MINPORT){
			PrintWriter.println("Port Allocation Err: TOO SMALL, instance "+plid);
			System.exit(1);
		}
		else{
			PrintWriter.println("Port Allocation Err: UNKNOWN, instance "+plid);
			System.exit(1);
		}
		try {
			servSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
		try {
			cliSocket = servSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
		
	}
	
}
