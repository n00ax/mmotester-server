package mmotest.player;

public class FASTUpdate {
	public int Plid;
	public int Worldid;
	public double X;
	public double Y;
	public double Z;
	public double DX;
	public double DY;
	public double DZ;
	public FASTUpdate(int plid, int worldid, double x, double y, double z, double dx, double dy, double dz){
		Plid = plid;
		Worldid = worldid;
		X=x;
		Y=y;
		Z=z;
		DX = dx;
		DY = dy;
		DZ = dz;
	}
}
