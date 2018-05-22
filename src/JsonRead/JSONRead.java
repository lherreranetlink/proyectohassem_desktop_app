package JsonRead;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JSONRead {
	
	public int activado = 0;
	public String tituloTexto = "";
	public String rutaTexto = "";
	public String usuarioInfo = "";
	
	//Para las imagenes/////////////////////////////////////////////
	public  List<String> titulos = new ArrayList<String>();
	public  List<String> textos64 = new ArrayList<String>();
	public List<String> imagenID = new ArrayList<String>();
	///////////////////////////////////////////////////////////////
	
	//Para los usuarios de la region//////////////////////////////
	public List<String> usuarioID = new ArrayList<String>();
	public List<String> nickName = new ArrayList<String>();
	public List<String> fotoPerfil = new ArrayList<String>();
	///////////////////////////////////////////////////////////////
	
	public List<String> getTitulos(JsonElement elemento){
		dumpJSONElement(elemento);
		return titulos;
	}
	
	public List<String> getTextos64(){
		return textos64;
	}
	
	public List<String> getNickNames(JsonElement elemento){
		dumpJSONElement(elemento);
		return nickName;
	}
	
	public List<String> getUsuarioIDs(){
		return usuarioID;
	}
	
	public List<String> getFotoPerfiles(){
		return fotoPerfil;
	}
	
	public List<String> getimagenID(){
		return imagenID;
	}
	
	public void dumpJSONElement(JsonElement elemento) {
		
	    if (elemento.isJsonObject()) {
	        //System.out.println("Es objeto");
	        JsonObject obj = elemento.getAsJsonObject();
	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	        while (iter.hasNext()) {
	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
	            
	            if(entrada.getKey().equals("titulo"))
	            {
	            		//System.out.println("===> clave: " + entrada.getKey());
	            		activado = 1;
	            }
	            /*
	            else if(entrada.getKey().equals("ruta"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
            			activado = 2;
	            }
	            */
	            else if(entrada.getKey().equals("nick_name"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
            			activado = 3;
	            }
	            else if(entrada.getKey().equals("id"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
            			activado = 4;
	            }
	            else if(entrada.getKey().equals("foto_perfil_base64"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
            			activado = 5;
	            }
	            else if(entrada.getKey().equals("obra_id")) 
	            {
	            		activado = 6;
	            }
	            else if(entrada.getKey().equals("base64_photo")) 
	            {
	            		activado = 7;
	            }
	            else if(entrada.getKey().equals("base64_image"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
            			activado = 8;
	            }
	            else if(entrada.getKey().equals("user_id"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
	            		activado = 9;
	            }
	            else
	            {
	            		activado = 0;
	            		//System.out.println("Clave: " + entrada.getKey());
	    	            //System.out.println("Valor:");
	            }
	            
	            dumpJSONElement(entrada.getValue());
	        }
	 
	    } else if (elemento.isJsonArray()) {
	        JsonArray array = elemento.getAsJsonArray();
	        //System.out.println("Es array. Numero de elementos: " + array.size());
	        java.util.Iterator<JsonElement> iter = array.iterator();
	        while (iter.hasNext()) {
	            JsonElement entrada = iter.next();
	            dumpJSONElement(entrada);
	        }
	    } else if (elemento.isJsonPrimitive()) {
	        //System.out.println("Es primitiva");
	        JsonPrimitive valor = elemento.getAsJsonPrimitive();
	        if (valor.isBoolean()) {
	            System.out.println("Es booleano: " + valor.getAsBoolean());
	        } else if (valor.isNumber()) {
	            //System.out.println("Es numero: " + valor.getAsNumber());
	            if(activado == 6)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		imagenID.add(usuarioInfo);
	            }
	            else if(activado == 4)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		usuarioID.add(usuarioInfo);
	            }
	            else if(activado == 9)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		usuarioID.add(usuarioInfo);
	            }
	        } else if (valor.isString()) {
	            
	            if(activado == 1)
	            {
	            		//System.out.println("===> titulo texto: " + valor.getAsString());
	            		tituloTexto = valor.getAsString();
	            		titulos.add(tituloTexto);
	            }
	            /*
	            else if(activado == 2)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		rutaTexto = valor.getAsString();
	            		textos64.add(rutaTexto);
	            }
	            */
	            else if(activado == 3)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		nickName.add(usuarioInfo);
	            }
	            else if(activado == 5)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		fotoPerfil.add(usuarioInfo);
	            }
	            else if(activado == 7)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		textos64.add(usuarioInfo);
	            }
	            else if(activado == 8)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		usuarioInfo = valor.getAsString();
	            		textos64.add(usuarioInfo);
	            }
	            else
	            {
	            		System.out.println("Es texto: " + valor.getAsString());
	            }
	            
	        }
	    } else if (elemento.isJsonNull()) {
	        System.out.println("Es NULL");
	    } else {
	        System.out.println("Es otra cosa");
	    }
	}
		
}