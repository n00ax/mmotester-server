package mmotest.constants;

public class Constants {
	public static final String PRODUCTNAME = "MMOTest Server";
	public static final String VERSTR = new StringBuilder().append(PRODUCTNAME).append(" BETA0.1").toString();
	public static final String PRODUCTMAN = "CL";
	public static final String PRODUCTSTSTR = new StringBuilder().append(VERSTR).append(" , PROPERTY OF ")
	.append(PRODUCTMAN).append("ANY UNAUTHORIZED USE OF THIS SERVER IS PUNISHABLE BY CIVIL LAW").toString();
	public static final int INTSTR = 1;
	public static final short PORTNUM = 5000;
	public static final int MAXPORT = 6000;
	public static final int MINPORT = 6001;
	public static final String LOGNAME = "log.mmm";
	public static final String PACKET_ENC_TYPE = "RSA";
	public static final String PACKET_ENC_PROVIDER= "SUN";
	public static final String PACKET_RAN_TYPE = "SHA1PRNG";
	public static final String PACKET_RAN_PROVIDER="SUN";
	public static final int PACKET_KEY_SIZE = 1024;
}
