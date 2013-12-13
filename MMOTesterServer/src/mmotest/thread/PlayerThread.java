package mmotest.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.io.PrintWriter;

import mmotest.constants.Constants;
import mmotest.exception.ExceptionHandler;
import mmotest.io.PrintOUT;

public class PlayerThread {
	private int plid;
	private int encryptionBlock1, encryptionBlock2, encryptionBlock3, encryptionBlock4;
	private String playername, password;
	private long plip;
	private int plright;
	private ServerSocket servSocket;
	private Socket cliSocket;
	private PrintWriter sout;
	private BufferedReader sin;
	private enum PlayerRight{
		PLAYER, GM, SUPPORT , S2, ADMIN, DEV
	} //Player = Lowest DEV = Highest(USED ONLY FOR DEV SERVER)
	public PlayerThread(int port){
		if(port>Constants.MAXPORT){
			PrintOUT.println("Port Allocation Err: TOO LARGE, instance "+plid);
			System.exit(1);
		}
		if(port<Constants.MINPORT){
			PrintOUT.println("Port Allocation Err: TOO SMALL, instance "+plid);
			System.exit(1);
		}
		else{
			PrintOUT.println("Port Allocation Err: UNKNOWN, instance "+plid);
			System.exit(1);
		}
		try {
			servSocket = new ServerSocket(port);
			cliSocket = servSocket.accept();
			sin = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));
			sout =  new PrintWriter(cliSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
	}
	
}
