package clases;

import java.util.HashMap;

import entidades.Operario;

public class ModeloDatos {
	
	HashMap<String, Operario> mapaOperarios;

		public ModeloDatos(){
			mapaOperarios=new HashMap<String, Operario>();
		}
		public  String registrarOperario(Operario ope) {
			
			if(mapaOperarios.containsKey(ope.getDocumento())==false) {
				mapaOperarios.put(ope.getDocumento(), ope);
				return "si";
				
			}else {
				System.out.println("Ya existe la persona");
				return "no";
			}
			

		}
		
		public Operario consultarOperarioPorDocumento(String documento) {
			
			Operario operaTemporal=null;
			
			if(mapaOperarios.containsKey(documento)) {
				operaTemporal=mapaOperarios.get(documento);
				
		}return operaTemporal;
			}
		
		public void consultarOperarioLista() {
			
			System.out.println("LISTA OPERARIOS");
			System.out.println();
			System.out.println(mapaOperarios);
			
		}
		
		public void actualizarOperario() {
			
		}
		
		public void eliminarOperario() {
			
		}
}
