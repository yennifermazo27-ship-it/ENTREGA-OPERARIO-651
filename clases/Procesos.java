package clases;

import entidades.Operario;

public class Procesos {

	public void calcularSueldoNuevo(Operario operario){
		
		double por=0;
		
		System.out.println("Desde procesos: "+operario);
		
		if(operario.getSueldo()<500 && operario.getAntiguedad()>=10) {
			
			por=0.2;
		
		}else if(operario.getSueldo()<500 && operario.getAntiguedad()<10){
			
			por=0.05;
			
		}else if(operario.getSueldo()>=500) {
			
			por=0;
			
		}
		
		double aumento=operario.getSueldo()*por;
		double sueldoNuevo=operario.getSueldo()+aumento;
		 
		operario.setSueldoNuevo(sueldoNuevo);
		operario.setAumento(por*100);
	}
	
}
