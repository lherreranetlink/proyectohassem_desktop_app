package connection;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

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
					String userId = Long.toString((Long) json.get("user_id"));
					Constants.setIpAddressLocal(ipAddress);
					Constants.setHttpPortLocal(httpPort);
					Constants.setUserId(userId);
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
	
	public static boolean Register(String nombre, String nickName, String password, String correo, 
								   String pais, String profilePhoto) {
		try {
		String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/register";
		URL url = new URL(urlString);
		
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("nombre", nombre);
		params.put("nick_name", nickName);
		params.put("password", password);
		params.put("correo", correo);
		params.put("pais", pais);
		params.put("foto_perfil", profilePhoto);
		
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) 
            		postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        int responseCode = conn.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null)
				response.append(inputLine);
			
			in.close();
			JSONParser parser = new JSONParser();
			System.out.println(response.toString());
			Object obj = parser.parse(response.toString());
			
			JSONObject json = (JSONObject) obj;
			String status = (String) json.get("status");
			
			if (status.equals("Success")) {
				return true;
			} else {
				String msg = (String) json.get("message");
				JOptionPane.showMessageDialog(null, msg);
				return false;
			}
			
        } else {
        	JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			return false;
        }
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		return false;
	}
	
	public static boolean newCanvas(String titulo, String newPhoto){
		
		String urlString = "http://" + Constants.ip_address_local + ":" + Constants.http_port_local + "/obras/subir_foto";
		System.out.println("Upload photo url: " + urlString);
		try {
			URL url = new URL(urlString);
			System.out.println(urlString);
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("console.out")), true));
			System.out.print(newPhoto);
			Map<String,Object> params = new LinkedHashMap<>();
			params.put("user_id", Constants.user_id_local);
			params.put("photo", newPhoto);
			params.put("titulo", titulo);

			
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String,Object> param : params.entrySet()) {
	            if (postData.length() != 0) 
	            		postData.append('&');
					postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
					postData.append('=');
		            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	        }
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        int responseCode = conn.getResponseCode();
	        
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
					JOptionPane.showMessageDialog(null, "Cargado con exito!");
					return true;
				} else {
					String msg = (String) json.get("message");
					JOptionPane.showMessageDialog(null, msg);
					return false;
				}
				
	        } else {
	        	JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
				return false;
	        }
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static JSONObject get_all_photos()
	{
		String urlString = "http://" + Constants.ip_address_local + ":" + Constants.http_port_local + "/obras/get_all_photos_by_user?user_id=" + Constants.user_id_local;
		try {
			URL url;
			url = new URL(urlString);
			
			System.out.println(urlString);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
				
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("imagenes.json")), true));
				System.out.print(response);
				System.setOut(stdout); 
				
				
				
				/*JSONParser parser = new JSONParser();
				Object obj = parser.parse(response.toString());
				
				JSONObject json = (JSONObject) obj;
				String status = (String) json.get("status");
				
				if (status.equals("Success")) {
					String ipAddress = (String) json.get("ip_address");
					String httpPort = (String) json.get("http_port");
					String userId = Long.toString((Long) json.get("user_id"));
					Constants.setIpAddressLocal(ipAddress);
					Constants.setHttpPortLocal(httpPort);
					Constants.setUserId(userId);
				} else {
					String msg = (String) json.get("message");
					JOptionPane.showMessageDialog(null, msg);
				}*/
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void busqueda() {
		String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/get_users_per_region?user_id=" + Constants.user_id_local;
		try {
			URL url;
			url = new URL(urlString);
			
			//System.out.println(urlString);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
				
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("UsuariosRegion.json")), true));
				System.out.print(response);
				System.setOut(stdout); 
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void busquedaObra(String titulo) {
		String urlString = "http://" + Constants.ip_address_local + ":" + Constants.http_port_local + "/obras/buscar?titulo="+titulo;
		try {
			URL url;
			url = new URL(urlString);
			
			//System.out.println(urlString);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
				
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("ObraB.json")), true));
				System.out.print(response);
				System.setOut(stdout); 
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void imagenesAzar() {
		String urlString = "http://" + Constants.ip_address_local + ":" + Constants.http_port_local + "/obras/index";
		try {
			URL url;
			url = new URL(urlString);
			
			//System.out.println(urlString);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
				
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("azar.json")), true));
				System.out.print(response);
				System.setOut(stdout); 
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void seguir(String usuarioS) {
		String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/follow_user?user_id=" + Constants.user_id_local + "&id_usuario_seguido=" + usuarioS;
		try {
			URL url;
			url = new URL(urlString);
			
			System.out.println(urlString);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
				
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("seguir.json")), true));
				System.out.print(response);
				System.setOut(stdout); 
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


public static boolean seguirPOST(String usuarioS) {
	String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/follow_user";
	System.out.println("Seguir: " + urlString);
	try {
		URL url = new URL(urlString);
		PrintStream stdout = System.out;
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("seguir.json")), true));
		System.out.print(usuarioS);
		System.setOut(stdout); 
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("user_id", Constants.user_id_local);
		params.put("id_usuario_seguido", usuarioS);

		
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) 
            		postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        int responseCode = conn.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
				JOptionPane.showMessageDialog(null, "Cargado con exito!");
				return true;
			} else {
				String msg = (String) json.get("message");
				JOptionPane.showMessageDialog(null, msg);
				return false;
			}
			
        } else {
        	JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			return false;
        }
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	return false;
}

public static void get_followers() {
	String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/get_followers?user_id=" + Constants.user_id_local;
	try {
		URL url;
		url = new URL(urlString);
		
		System.out.println(urlString);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
			
			PrintStream stdout = System.out;
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("seguidores.json")), true));
			System.out.print(response);
			System.setOut(stdout); 
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public static void get_idolos() {
	String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/get_idolos?user_id=" + Constants.user_id_local;
	try {
		URL url;
		url = new URL(urlString);
		
		System.out.println(urlString);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
			
			PrintStream stdout = System.out;
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("idolos.json")), true));
			System.out.print(response);
			System.setOut(stdout); 
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}


public static boolean quit_follow(String usuarioS) {
	String urlString = "http://" + Constants.ip_address + ":" + Constants.http_port + "/quit_follow";
	System.out.println("Seguir: " + urlString);
	try {
		URL url = new URL(urlString);
		PrintStream stdout = System.out;
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("NOseguir.json")), true));
		System.out.print(usuarioS);
		System.setOut(stdout); 
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("user_id", Constants.user_id_local);
		params.put("id_usuario_seguido", usuarioS);

		
		StringBuilder postData = new StringBuilder();
		for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) 
            		postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        int responseCode = conn.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
				JOptionPane.showMessageDialog(null, "Cargado con exito!");
				return true;
			} else {
				String msg = (String) json.get("message");
				JOptionPane.showMessageDialog(null, msg);
				return false;
			}
			
        } else {
        	JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			return false;
        }
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	return false;
}

	public static JSONObject get_all_photosID(String userID)
	{
		String urlString = "http://" + Constants.ip_address_local + ":" + Constants.http_port_local + "/obras/get_all_photos_by_user?user_id=" + userID;
		try {
			URL url;
			url = new URL(urlString);
			
			System.out.println(urlString);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
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
				
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("imagenesID.json")), true));
				System.out.print(response);
				System.setOut(stdout); 
				
				
				
				/*JSONParser parser = new JSONParser();
				Object obj = parser.parse(response.toString());
				
				JSONObject json = (JSONObject) obj;
				String status = (String) json.get("status");
				
				if (status.equals("Success")) {
					String ipAddress = (String) json.get("ip_address");
					String httpPort = (String) json.get("http_port");
					String userId = Long.toString((Long) json.get("user_id"));
					Constants.setIpAddressLocal(ipAddress);
					Constants.setHttpPortLocal(httpPort);
					Constants.setUserId(userId);
				} else {
					String msg = (String) json.get("message");
					JOptionPane.showMessageDialog(null, msg);
				}*/
			}
			else {
				JOptionPane.showMessageDialog(null, "Response Code: " + responseCode + "\n Unable to connect to remote host");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
