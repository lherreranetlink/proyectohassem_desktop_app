package constants;

public class Constants {
	
	public static String ip_address = "localhost";
	public static String http_port = "8000";
	
	public static void setIpAddress(String ip_address) {
		Constants.ip_address = ip_address; 
	}
	
	public static void setHttpPort(String http_port) {
		Constants.http_port = http_port;
	}
}
