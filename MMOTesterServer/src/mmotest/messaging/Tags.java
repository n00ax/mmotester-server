package mmotest.messaging;

public class Tags {
	public static final int PLAYER[]={0};
	public static final int GM[]={0};
	public static final int ADMIN[]={0};
	public static final int DEV[]={0};
	public static final String PLTag = "<Player>";
	public static final String GMTag = "<GM>";
	public static final String ADTag = "<Admin>";
	public static final String DevTag = "<Developer>";
	public String GetGMIMG(){
		return new String("gm_img.png");
	}
	public String GetPlIMG(){
		return new String("pl_img.png");
	}
	public String GetADIMG(){
		return new String("ad_img.png");
	}
	public String GetDEVIMG(){
		return new String("dev_img.png");
	}
}
