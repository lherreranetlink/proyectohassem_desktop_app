package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import constants.Constants;


public class ConnectionManager {
	
	public static boolean login(String nickName, String password, String pais) {
		
		String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/make_connection?username=" + nickName + "&password="  + password;
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
				System.out.println("Response: " + response);
				/*if (response.toString().equals("Login Ok"))
					return true;
				else
				{
					JOptionPane.showMessageDialog(null, response.toString());
					return false;
				}*/
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
				return false;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
