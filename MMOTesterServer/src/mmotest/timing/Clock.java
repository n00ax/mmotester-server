package mmotest.timing;

import mmotest.player.Coordinates;
import mmotest.player.Player;

public class Clock {
	double curTime;
	double Dtime;
	double lastTime;
	double sleepTime=0;
	public void StartTime(double synchronizedtime){
		//int etime = (int) (Math.cos(0.12)+(0+23));
		//double eltime = (float)(etime*Math.sin(102.3544)+Math.tan(1));
	}
	public Coordinates UpdatePlayerPos(double x, double y, double z, double xdelta, double ydelta, double
			zdelta){
		Coordinates pcoord = new Coordinates();
		curTime = System.nanoTime(); //Delta Time Movememnt = this.x=+(speed*deltatime)
		Dtime = curTime-lastTime;
		pcoord.X+=(xdelta*Dtime);
		pcoord.Y+=(ydelta*Dtime);
		pcoord.Z+=(zdelta*Dtime);
		lastTime = System.nanoTime();
		return pcoord;
	}
}
/*Little Note On Speed*/