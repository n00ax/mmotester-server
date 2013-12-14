package mmotest.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintWriter;

import mmotest.constants.Constants;
import mmotest.crypto.CryptManager;
import mmotest.exception.ExceptionHandler;
import mmotest.io.PrintOUT;
import mmotest.protocol.Packet;
import mmotest.protocol.Protocol;

public class PlayerThread implements Runnable{
	private int plid, plport;
	private int encryptionBlock1, encryptionBlock2, encryptionBlock3, encryptionBlock4;
	private ArrayList<Packet> PacketMap;
	private String playername, password;
	private boolean threadrunning;
	private long plip;
	private int plright;
	private byte bitbuffer[], decryptedbitbuffer[];
	private ServerSocket servSocket;
	private Socket cliSocket;
	private PrintWriter sout;
	private BufferedReader sin;
	private CryptManager crm;
	private enum PlayerRight{
		PLAYER, GM, SUPPORT , S2, ADMIN, DEV
	} //Player = Lowest DEV = Highest(USED ONLY FOR DEV SERVER)
	public PlayerThread(int port){
		plport = port;
	}
	@Override
	public void run() {
		if(plport>Constants.MAXPORT){
			PrintOUT.println("Port Allocation Err: TOO LARGE, instance "+plid);
			System.exit(1);
		}
		if(plport<Constants.MINPORT){
			PrintOUT.println("Port Allocation Err: TOO SMALL, instance "+plid);
			System.exit(1);
		}
		else{
			PrintOUT.println("Port Allocation Err: UNKNOWN, instance "+plid);
			System.exit(1);
		}
		try {
			servSocket = new ServerSocket(plport);
			cliSocket = servSocket.accept();
			sin = new BufferedReader(new InputStreamReader(cliSocket.getInputStream()));
			sout =  new PrintWriter(cliSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ExceptionHandler.HandleException(e);
		}
	}
	public void ListenNormal(){
		/*Get And Write To Buffer*/
		
		/*Decrypt Buffer*/
		decryptedbitbuffer=null;
		decryptedbitbuffer = crm.Decrypt(bitbuffer);
		while(threadrunning==true){
			switch(decryptedbitbuffer[0]){
			case Protocol.LOGIN:
				
				break;
			case Protocol.ACK:
				
				break;
			case Protocol.DEAD:
				
				break;
			case Protocol.KILL:
				
				break;
			case Protocol.MSG:
				
				break;
			}
		}
	}
}