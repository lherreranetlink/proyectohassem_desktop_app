package JsonRead;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JSONRead {
	
	public static int activado = 0;
	public static String tituloTexto = "";
	public static String rutaTexto = "";
	public static List<String> titulos = new ArrayList<String>();
	public static List<String> textos64 = new ArrayList<String>();
	
	public static List<String> getTitulos(JsonElement elemento){
		JSONRead.dumpJSONElement(elemento);
		return titulos;
	}
	
	public static List<String> getTextos64(){
		return textos64;
	}
	
	public static void dumpJSONElement(JsonElement elemento) {
		
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
	            else if(entrada.getKey().equals("ruta"))
	            {
            			//System.out.println("===> clave: " + entrada.getKey());
            			activado = 2;
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
	            System.out.println("Es numero: " + valor.getAsNumber());
	        } else if (valor.isString()) {
	            
	            if(activado == 1)
	            {
	            		//System.out.println("===> titulo texto: " + valor.getAsString());
	            		tituloTexto = valor.getAsString();
	            		titulos.add(tituloTexto);
	            }
	            else if(activado == 2)
	            {
	            		//System.out.println("===> ruta texto: " + valor.getAsString());
	            		rutaTexto = valor.getAsString();
	            		textos64.add(rutaTexto);
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