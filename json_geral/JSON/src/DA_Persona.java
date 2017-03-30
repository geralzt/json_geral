import org.json.simple.JSONArray;

public class DA_Persona {
	

	public JSONArray arrayPer(){
		
		//Contiene el arreglo de usuarios 
		//al array se le manda un objeto, en este caso las personas
		
		JSONArray arr = new JSONArray();
	
		arr.add(new Persona("Maria", "Camacho", 20));
		arr.add(new Persona("Gabriel", "Zurita", 16));
		arr.add(new Persona("Jose", "Torrico", 19));
		
		return arr;
	}
}
