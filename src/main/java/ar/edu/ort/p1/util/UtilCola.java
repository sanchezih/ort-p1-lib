package ar.edu.ort.p1.util;

import ar.edu.ort.tp1.u5.tda.interfaces.Cola;

public class UtilCola {

	/**
	 * 
	 * @param <T>
	 * @param cola
	 */
	public static <T> void mostrarColaGenerica(Cola<T> cola) {
		
		T centinela = null;
		cola.add(centinela);
		T elemento = cola.remove();
		
		while (elemento != centinela) {
			System.out.println("\t-> " + elemento);
			cola.add(elemento);
			elemento = cola.remove();
		}
	}
	
}
