package ar.edu.ort.p1.util;

/**
 * Clase que implementa ejercicios opcionales con arrays
 * 
 * @author ihsanch
 *
 */
public class UtilArrays {

	/**
	 * Ejercicio TP4-11: Mostrar el contenido de un array de caracteres recibido
	 * como parametro sin valores repetidos
	 * 
	 * @param elementos
	 */
	public static void mostrarSinRepetidos(char[] elementos) {
		int j;
		boolean salio;
		for (int i = 0; i < elementos.length; i++) {
			j = 0;
			salio = false;
			while (!salio && j < i) {
				if (elementos[i] == elementos[j]) {
					salio = true;
				}
				j++;
			}
			if (!salio) {
				System.out.print(elementos[i] + " ");
			}
		}
		System.out.println();
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Ejercicio TP4-12: Retornar si el contenido de un array de caracteres recibido
	 * como parametro representa un palindromo.
	 * 
	 * @param elementos
	 * @return
	 */
	public static boolean isPalindromo(char[] elementos) {

		boolean isPalindromo = true;
		int length = elementos.length;
		for (int i = 0; i < elementos.length; i++) {
			if (isPalindromo) {
				int start = elementos[i];
				int end = elementos[--length];
				if (length < i) {
					break;
				}
				if (start != end) {
					isPalindromo = false;
				}
			}
		}
		return isPalindromo;
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Ejercicio TP4-13: Invertir el contenido de un array de caracteres recibido
	 * como parametro, sin usar un array auxiliar.
	 * 
	 * @param elementos
	 */
	public static void invertir(char[] elementos) {
		char aux;
		for (int i = 0; i < (elementos.length / 2); i++) {
			aux = elementos[i];
			elementos[i] = elementos[elementos.length - 1 - i];
			elementos[elementos.length - 1 - i] = aux;
		}
		mostrar(elementos);
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Ejercicio TP4-14: Rotar una posicion hacia la derecha cada elemento de un
	 * array de caracteres recibido como parametro, sin usar un array auxiliar.
	 * 
	 * @param elementos
	 */
	public static void rotar(char[] elementos) {
		char aux = elementos[elementos.length - 1];

		for (int i = elementos.length - 2; i >= 0; i--) {
			elementos[i + 1] = elementos[i];
		}
		elementos[0] = aux;
		mostrar(elementos);
	}

	/*----------------------------------------------------------------------------*/

	public static char[] unirConjuntos(char[] cjto1, char[] cjto2) {
		char[] res = new char[cjto1.length + cjto2.length];
		char i = 0;
		for (char c : cjto1) {
			res[i++] = c;
		}
		for (char c : cjto2) {
			res[i++] = c;
		}
		return res;
	}

	public static char[] unirConjuntosObviandoRepetidos(char[] cjto1, char[] cjto2) {
		char[] res = new char[cjto1.length + cjto2.length];
		char i = 0;
		for (char c : cjto1) {
			if (!contiene(res, c)) {
				res[i++] = c;
			}
		}
		for (char c : cjto2) {
			if (!contiene(res, c)) {
				res[i++] = c;
			}
		}
		return res;
	}

	/*----------------------------------------------------------------------------*/

	public static boolean contiene(char[] elementos, char key) {
		boolean existe = false;
		int i = 0;
		while (i < elementos.length && !existe) {
			if (elementos[i] == key) {
				existe = true;
			}
			i++;
		}
		return existe;
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Ejercicio TP4-16: Mostrar los valores resultantes de la intersección de dos
	 * arrays de caracteres (sin repeticiones) recibidos como parámetros.
	 * 
	 * @param cjto1
	 * @param cjto2
	 */
	public static void mostrarInterseccion(char[] cjto1, char[] cjto2) {
		boolean salio;
		for (int i = 0; i < cjto1.length; i++) {
			salio = false;
			for (int j = 0; j < cjto2.length; j++) {
				if (!salio && cjto1[i] == cjto2[j]) {
					System.out.print(cjto2[j] + " ");
					salio = true;
				}
			}
		}
		System.out.println();
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Ejercicio TP4-17: Mostrar los valores resultantes de la diferencia de dos
	 * arrays de caracteres (sin repeticiones) recibidos como parametros (el primero
	 * menos el segundo).
	 * 
	 * @param cjto1
	 * @param cjto2
	 */
	public static void mostrarDiferencia(char[] cjto1, char[] cjto2) {
		char[] res = new char[cjto1.length];
		int resIndex = 0;
		for (int i = 0; i < cjto1.length; i++) {
			boolean encontrada = false;
			int j = 0;
			while (j < cjto2.length && !encontrada) {
				if (cjto1[i] == cjto2[j]) {
					encontrada = true;
				}
				j++;
			}
			if (!encontrada) {
				res[resIndex] = cjto1[i];
				resIndex++;
			}
		}
		mostrarSinRepetidos(res);
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Ejercicio TP4-18: Mostrar los valores resultantes de la diferencia simétrica
	 * de dos arrays de caracteres (sin repeticiones) recibidos como parámetros (el
	 * primero menos el segundo).
	 * 
	 * @param cjto1
	 * @param cjto2
	 */
	public static void mostrarDiferenciaSimetrica(char[] cjto1, char[] cjto2) {
		char[] res = new char[cjto1.length + cjto2.length];
		int resIndex = 0;

		for (int i = 0; i < cjto1.length; i++) {
			boolean encontrada = false;
			int j = 0;
			while (j < cjto2.length && !encontrada) {
				if (cjto1[i] == cjto2[j]) {
					encontrada = true;
				}
				j++;
			}
			if (!encontrada) {
				res[resIndex] = cjto1[i];
				resIndex++;
			}
		}

		for (int i = 0; i < cjto2.length; i++) {
			boolean encontrada = false;
			int j = 0;
			while (j < cjto1.length && !encontrada) {
				if (cjto2[i] == cjto1[j]) {
					encontrada = true;
				}
				j++;
			}
			if (!encontrada) {
				res[resIndex] = cjto2[i];
				resIndex++;
			}
		}

		mostrarSinRepetidos(res);
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Mostrar el contenido de un array de caracteres recibido como parametro
	 * 
	 * @param elementos
	 */
	public static void mostrar(char[] elementos) {
		for (int i = 0; i < elementos.length; i++) {
			System.out.print(elementos[i] + " ");
		}
		System.out.println();
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Mostrar el contenido de un array de double recibido como parametro
	 * 
	 * @param elementos
	 */
	public static void mostrar(double[] elementos) {
		for (int i = 0; i < elementos.length; i++) {
			System.out.print(Double.parseDouble(String.format("%.2f", elementos[i])) + "\n");
		}
	}

	/*----------------------------------------------------------------------------*/

	/**
	 * Mostrar el contenido de un array de T recibido como parametro
	 * 
	 * @param <T>
	 * @param elementos
	 */
	public static <T> void mostrarGenerico(T[] elementos) {
		for (int i = 0; i < elementos.length; i++) {
			System.out.print(elementos[i] + "\n");
		}
	}

}
