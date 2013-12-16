package mmotest.player;

public class CurrentPlayer extends Player{
	private double plr_pitch;
	private double plr_yaw;
	public CurrentPlayer(double x, double y, double z, double xdelta, double ydelta, double zdelta,
			int modelid, int playerid, int alternate_movement, int blockid, int MapWidth,
			boolean is_Alive, boolean is_Dead, boolean is_Moving, boolean is_Flying, boolean is_Swimming, boolean is_OtherState,
			String Username, String PasswordHash){
		super(x, y, z, xdelta, ydelta, zdelta, modelid, playerid, alternate_movement, blockid, MapWidth, 
				is_Alive, is_Dead, is_Moving, is_Flying, is_Swimming, is_OtherState, Username, PasswordHash);
	}
	public void CalculatePitch(){
		
	}
}
