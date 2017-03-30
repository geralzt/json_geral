import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Codificar de JAVA a JSON\n");
		
		DA_Persona da_persona = new DA_Persona();
		
		//Crea una variable array y esta almacena el arreglo de personas
		JSONArray array = new JSONArray();
		array = da_persona.arrayPer();
		
		StringWriter out = new StringWriter();
		try {
			//Escribe a una cadena JSON todo lo que este en out
			array.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(out);
		
		System.out.println("\nDecodificar de JSON a JAVA\n");
		
		
		//se crea la variable jsonobjet donde se almacenar el arreglo de personas dentro
		//una key
		JSONObject jsonPersona = new JSONObject();
		jsonPersona.put("personas", out);
		
		//leer la cadena JSON
		JSONParser persona_parser = new JSONParser();
		
		try {
			//objPersonas ayuda a leer la cadena JSON
			JSONObject objPersonas = (JSONObject) persona_parser.parse(jsonPersona.toJSONString());
			//arrayPersona ayuda a obtener el arreglo del JSON
			JSONArray arrayPersona = (JSONArray) objPersonas.get("personas");
			
			
			//para poder recorrer el arreglo de personas
			for (int i = 0; i< arrayPersona.size(); i++){
				//persona nos permite obtener a cada persona
				JSONObject persona = (JSONObject) arrayPersona.get(i);
				String nombre = (String) persona.get("nombre");
				String apellido = (String) persona.get("apellido");
				String edad = (String) persona.get("edad");
				
				System.out.println(nombre + "\t" + apellido + "\t" + edad);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		

	}

}
