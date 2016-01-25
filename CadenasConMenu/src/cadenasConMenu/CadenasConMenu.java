package cadenasConMenu;

import utiles.Menu;
import utiles.Teclado;

/**
 * Clase CadenasConMenu Entrega la clase CadenasConMenu que muestre el siguiente
 * menú.
 * 
 * Capitaliza palabras: solicitará al usuario una cadena por teclado y
 * convertirá el primer carácter de cada palabra a mayúsculas. Mostrará el
 * resultado. Extrae mayúsculas: solicitará al usuario una cadena por teclado y
 * extraerá las iniciales que estén en mayúsculas acompañadas por un punto.
 * Necesitarás el método Character.isUpperCase(caracter). Mostrará el resultado.
 * Salir
 * 
 * Requisitos:
 * 
 * Sólo se recogerán opciones de menú válidos (1, 2 y 3) Utiliza métodos en la
 * medida de lo posible Evita el uso de bucles infinitos
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 */
public class CadenasConMenu {
	static Menu menuCadenas = new Menu("Manejo de Cadenas",
			new String[] { "Capitaliza palabras.", "Extrae mayúsculas.", "Salir." });

	public static void main(String[] args) {
		gestionarMenu();
	}

	/**
	 * M&eacute;todo para la gesti&oacute;n del men&uacute; de cadenas.
	 */
	private static void gestionarMenu() {
		do {
			switch (menuCadenas.gestionar()) {
			case 1:
				System.out.println(capitalizaPalabras());
				break;
			case 2:
				System.out.println(extraeMayusculas());
				break;
			case 3:
				System.out.println("Adiooos.");
				return;
			}
		} while (true);// No se como obviar este bucle infinito..
	}

	/**
	 * Convierte la primera letra de la palabra de la cadena a
	 * may&uacute;sculas.
	 * 
	 * @return Devuelve la cadena con el inicio de cada palabra en
	 *         may&uacute;sculas.
	 */
	private static StringBuilder capitalizaPalabras() {
		String cadena = Teclado.leerCadena("Dame una cadena..").trim();
		StringBuilder cadena2 = new StringBuilder(cadena);
		if ((cadena.charAt(0) != ' ')) {
			if (!(Character.isUpperCase(cadena.charAt(0)))) {
				cadena2.insert(0, Character.toUpperCase(cadena.charAt(0)));
				cadena2.delete(1, 2);
			}
		}
		for (int i = 0; i < cadena.length() - 1; i++) {
			if (cadena.charAt(i) == ' ' && cadena.charAt(i + 1) != ' ') {
				if (!(Character.isUpperCase(cadena.charAt(i)))) {
					if (cadena.charAt(i) == ' ' && cadena.charAt(i + 1) != ' ')
						cadena2.insert((i + 1), Character.toUpperCase(cadena.charAt(i + 1)));
					cadena2.delete((i + 2), (i + 3));
				}
			}
		}
		return cadena2;
	}

	/**
	 * Extrae las may&uacute;sculas de las palabras de la cadena y las concatena
	 * con un punto.
	 * 
	 * @return Devuelve las may&uacute;sculas extraidas con su punto
	 *         concatenado.
	 */
	private static StringBuilder extraeMayusculas() {
		String cadena = Teclado.leerCadena("Dame una cadena..").trim();
		StringBuilder cadena2 = new StringBuilder();
		if (Character.isUpperCase(cadena.charAt(0))) {
			cadena2.append(cadena.charAt(0) + ". ");
		}
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == ' ' && cadena.charAt(i + 1) != ' ' && Character.isUpperCase(cadena.charAt(i + 1)))
				cadena2.append(cadena.charAt(i + 1) + ". ");
		}
		return cadena2;
	}
}