package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import constants.Constants;


public class ConnectionManager {
	
	public static boolean Login(String nickName, String password, String pais) {
		
		String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/try_login?nick_name=" 
		+ nickName + "&password="  + password + "&pais=" + pais;
		
		try {
			URL url;
			url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			
			if (responseCode == HttpURLConnection.HTTP_OK)
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				
				while ((inputLine = in.readLine()) != null)
					response.append(inputLine);
				
				in.close();
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(response.toString());
				
				JSONObject json = (JSONObject) obj;
				String status = (String) json.get("status");
				
				if (status.equals("Success")) {
					String ipAddress = (String) json.get("ip_address");
					String httpPort = (String) json.get("http_port");
					Constants.setIpAddress(ipAddress);
					Constants.setHttpPort(httpPort);
					return true;
				} else {
					String msg = (String) json.get("message");
					JOptionPane.showMessageDialog(null, msg);
					return false;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
				return false;
			}
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean Register(String nombre, String nickName, String password, 
								String correo, String edad, String sexo, String region) {
		
		String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/register"
		+ "?nombre=" + nombre + "&nick_name=" + nickName + "&password=" + password + "&correo=" + correo
		+ "&edad=" + edad + "&sexo=" + sexo + "&region=" + region;
		
		URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			
			if (responseCode == HttpURLConnection.HTTP_OK)
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				
				while ((inputLine = in.readLine()) != null)
					response.append(inputLine);
				
				in.close();
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(response.toString());
				
				JSONObject json = (JSONObject) obj;
				String status = (String) json.get("status");
				
				if (status.equals("Success")) 
					return true;
				else {
					String msg = (String) json.get("message");
					JOptionPane.showMessageDialog(null, msg);
					return false;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
				return false;
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
