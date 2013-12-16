package mmotest.mem;

import java.net.UnknownHostException;
import java.util.Map;
import java.util.Vector;

import mmotest.constants.Constants;
import mmotest.io.PrintOUT;
import mmotest.player.CurrentPlayer;
import mmotest.player.FASTUpdate;
import mmotest.player.Player;
import mmotest.thread.ThreadTerminator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
public class GlobalMemory {
	private MongoClient primary_client;
	private DB UsrDB;
	private DB StateDB;
	private DB WorldDB;
	public GlobalMemory(){
		try {
			primary_client = new MongoClient(Constants.DBASE_IP,Constants.DBASE_PORT);
			UsrDB = primary_client.getDB(Constants.UsrDBSName);
			StateDB = primary_client.getDB(Constants.StateDBSName);
			WorldDB = primary_client.getDB((Constants.WorldDBSName));
			boolean isAuthUsr = UsrDB.authenticate(Constants.UsrDBSName, Constants.UsrDBPasswd.toCharArray());
			if(isAuthUsr==true){
				PrintOUT.println("USER::DATABASE **SUCESSFUL** :: THREAD="+Thread.currentThread().getId());
			}
			else{
				PrintOUT.println("USER::DATABASE **UNSUCESSFUL** :: THREAD="+Thread.currentThread().getId());
				new ThreadTerminator("Server Build Or Immutable Memory Error, Could Not Login Into DB,USR");
			}
			boolean isAuthState = StateDB.authenticate(Constants.StateDBSName, Constants.StateDBPasswd.toCharArray());
			if(isAuthState==true){
				PrintOUT.println("USER::DATABASE **SUCESSFUL** :: THREAD="+Thread.currentThread().getId());
			}
			else{
				PrintOUT.println("USER::DATABASE **UNSUCESSFUL** :: THREAD="+Thread.currentThread().getId());
				new ThreadTerminator("Server Build Or Immutable Memory Error, Could Not Login Into DB,USR");
			}
			if(isAuthState==true){
				PrintOUT.println("USER::DATABASE **SUCESSFUL** :: THREAD="+Thread.currentThread().getId());
			}
			else{
				PrintOUT.println("USER::DATABASE **UNSUCESSFUL** :: THREAD="+Thread.currentThread().getId());
				new ThreadTerminator("Server Build Or Immutable Memory Error, Could Not Login Into DB,USR");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public CurrentPlayer GetInitPlayer(String UsrName, String Passwd, int Block1, int Block2,
			int Block3, int Block4){
		DBCollection usr_tp_collection = UsrDB.getCollection(Constants.UsrTable);
		DBCursor usr_cursor = usr_tp_collection.find(new BasicDBObject());
		DBObject usr_data = usr_cursor.next();
		Map<String, String>usr_map = usr_data.toMap();
		if(usr_map.get(Constants.UsernameField).equals(UsrName)==true && usr_map.get(Constants.PasswordField).
				equals(Passwd)==true && usr_map.get(Constants.blockField1).equals(new Integer(Block1).toString())==true
				&& usr_map.get(Constants.blockField2).equals(new Integer(Block2).toString())==true && 
			usr_map.get(Constants.blockField3).equals(new Integer(Block3).toString())==true && usr_map.get(Constants.blockField1).
			equals(new Integer(Block4).toString())==true){
			
		}
		else{
			PrintOUT.println("Database Verification OF Either Blocks Or Credentals Failed");
			new ThreadTerminator("Invalid Login Or Bad Block");
		}
	}
	public Vector<Player> LoadPlayersInBlock(){ //Gives Request Vector(**NOT EQUALIZED**)
		
	}
	public void UpdatePlayerFAST(FASTUpdate plobj){
		DBCollection t_collect = StateDB.getCollection(plobj.toString());
		DBObject finder = new BasicDBObject();
	}
}
