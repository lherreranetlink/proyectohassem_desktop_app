package constants;

public class Constants {
	
	public static String ip_address = "192.168.1.70";
	public static String http_port = "8080";
	public static String ip_address_local = "";
	public static String http_port_local = "";
	public static String user_id_local = "";
	
	public static void setIpAddress(String ip_address) {
		Constants.ip_address = ip_address; 
	}
	
	public static void setHttpPort(String http_port) {
		Constants.http_port = http_port;
	}
	
	public static void setIpAddressLocal(String ip_address) {
		Constants.ip_address_local = ip_address; 
	}
	
	public static void setHttpPortLocal(String http_port) {
		Constants.http_port_local = http_port;
	}
	
	public static void setUserId(String user_id){
		Constants.user_id_local = user_id;
	}
	
}
