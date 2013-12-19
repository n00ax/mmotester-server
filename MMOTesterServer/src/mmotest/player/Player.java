package mmotest.player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

import com.mongodb.BasicDBObject;

import mmotest.constants.Constants;
import mmotest.timing.Clock;

public class Player {
	private double x_coord, y_coord, z_coord, x_delta , y_delta, z_delta;
	private int model_id, player_id, alternate_movement_id, block_id, MapWidth;
	private boolean isAlive, isDead, isMoving, isWalking, isFlying, isSwimming, isOtherState;
	private String Usrname, PasswdHash;
	private int Map_Width;
	private Vector<Integer>BlocksToLoad;
	public Player(double x, double y, double z, double xdelta, double ydelta, double zdelta,
			int modelid, int playerid, int alternate_movement, int blockid, int MapWidth,
			boolean is_Alive, boolean is_Dead, boolean is_Moving, boolean is_Flying, boolean is_Swimming, boolean is_OtherState,
			String Username, String PasswordHash){
		x_coord = x;
		y_coord = y;
		z_coord = z;
		x_delta = xdelta;
		y_delta = ydelta;
		z_delta = zdelta;
		model_id = modelid;
		player_id = playerid;
		alternate_movement_id = alternate_movement;
		block_id = blockid;
		Map_Width = MapWidth;
		isAlive = is_Alive;
		isDead = is_Dead;
		isMoving = is_Moving;
		isFlying = is_Flying;
		isSwimming = is_Swimming;
		isOtherState = is_OtherState;
	}
	public void ComputeVector(){
		BlocksToLoad.set(0, block_id-(MapWidth-1));
		BlocksToLoad.set(1, block_id-MapWidth);
		BlocksToLoad.set(2, block_id-(MapWidth+1));
		BlocksToLoad.set(3, block_id-1);
		BlocksToLoad.set(4, block_id);
		BlocksToLoad.set(5, block_id+1);
		BlocksToLoad.set(6, block_id+(MapWidth-1));
		BlocksToLoad.set(7, block_id+MapWidth);
		BlocksToLoad.set(8, block_id+(MapWidth+1));
	}
	public void CheckChangeBlock(Clock clr){
		Coordinates pcoord = clr.UpdatePlayerPos(x_coord, y_coord, z_coord, x_delta, y_delta, z_delta);
		x_coord = pcoord.X;
		y_coord = pcoord.Y;
		z_coord = pcoord.Z;
		if(x_coord == 0){
			block_id = block_id-1;
		}
		else if(y_coord == 0){
			block_id = block_id+MapWidth;
		}
		else if(x_coord == Constants.BLOCKSIZEXY && x_coord>=0){
			block_id = block_id+1;
		}
		else if(y_coord == Constants.BLOCKSIZEXY){
			block_id= block_id-MapWidth;
		}
	}
	@Deprecated 
	public void ManualChangeCoords(Coordinates coord){ // Marked As Deprecated For Prevention Of Misuse
		x_coord = coord.X;
		y_coord = coord.Y;
	}
	public BasicDBObject GetIDAsOBJ(){
		return new BasicDBObject("plid",new Integer(player_id).toString());
	}
	public BasicDBObject ToDBObj(){
		BasicDBObject t_dl = new BasicDBObject();
		/*User Coordinates*/
		t_dl.append("username", Usrname);
		t_dl.append("password", PasswdHash);
		/*User Data*/
		t_dl.append("x_coord", new Double(x_coord).toString());
		t_dl.append("y_coord", new Double(y_coord).toString());
		t_dl.append("z_coord", new Double(z_coord).toString());
		t_dl.append("x_delta", new Double(x_delta).toString());
		t_dl.append("y_delta", new Double(y_delta).toString()); 
		t_dl.append("z_delta", new Double(z_delta).toString());
		t_dl.append("model_id", new Integer(model_id).toString());
		t_dl.append("player_id", new Integer(player_id).toString()); 
		t_dl.append("alternate_movement_id", new Integer(alternate_movement_id).toString()); 
		t_dl.append("block_id", new Integer(block_id).toString());
		t_dl.append("Map_Width", new Integer(Map_Width).toString());
		t_dl.append("isAlive", new Boolean(isAlive).toString()); 
		t_dl.append("isDead", new Boolean(isDead).toString());
		t_dl.append("isMoving", new Boolean(isMoving).toString());
		t_dl.append("isFlying", new Boolean(isFlying).toString());
		t_dl.append("isSwimming", new Boolean(isSwimming).toString()); 
		t_dl.append("isOtherState", new Boolean(isOtherState).toString());
		return t_dl;
	}
}
