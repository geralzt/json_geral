import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Persona implements JSONStreamAware{
	
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String n, String a, int e){
		nombre = n;
		apellido = a;
		edad = e;
	}

	// Este metodo convierte a la cadena JSON
	
	@Override
	public void writeJSONString(Writer out) throws IOException {
		LinkedHashMap<Object, Object> obj = new LinkedHashMap<>();
		
		//se emplean dos paramatros (key, value)
		// las key son los atributos
		obj.put("nombre", nombre);
		obj.put("apellido", apellido);
		obj.put("edad", String.valueOf(edad));
		
		//escribe la cadena JSON
		JSONValue.writeJSONString(obj, out);
		
	}
		
}
