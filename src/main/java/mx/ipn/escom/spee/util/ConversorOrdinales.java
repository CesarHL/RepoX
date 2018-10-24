package mx.ipn.escom.spee.util;

public class ConversorOrdinales {

	/*
	 * lista de las expresiones que siguen al numero para un numero cardinal
	 * abreviado. Salvo la posicion 1 y 3, los demas no tienen genero
	 */
	private static final String[] expresionAbreviada = { "m", "er", "d", "er", "t", "t", "t", "m", "v", "n" };

	/*
	 * lista de las expresiones de unidad para un numero cardinal. Salvo la
	 * posicion 1 y 3, los demas no tienen genero
	 */
	private static final String[] unidades = { "", "PRIMER", "SEGUND", "TERCER", "CUART", "QUINT", "SEXT", "SÉPTIM",
			"OCTAV", "NOVEN" };

	/*
	 * lista de las expresiones de decenas para un numero cardinal. Salvo la
	 * posicion 1 y 3, los demas no tienen genero
	 */
	private static final String[] decenas = { "", "DÉCIM", "VIGÉSIM", "TRIGÉSIM", "CUADRAGÉSIM", "QUINCUAGÉSIM",
			"SEXAGÉSIM", "SEPTUAGÉSIM", "OCTOGÉSIM", "NONAGÉSIM" };

	/*
	 * lista de las expresiones de centenas para un numero cardinal. Salvo la
	 * posicion 1 y 3, los demas no tienen genero
	 */
	private static final String[] centenas = { "", "CENTÉSIM", "DUCENTÉSIM", "TRICENTÉSIM", "CUADRIGENTÉSIM",
			"QUINGENTÉSIM", "SEXCENTÉSIM", "SEPTINGENTÉSIM", "OCTINGENTÉSIM", "NONINGENTÉSIM" };

	public static final String NUMERO_INVALIDO = "Número no aceptado.";

	/**
	 * Hace una conversion de numeros cardinales a numero ordinal. Del 1-999.
	 * 
	 * @param numero
	 *            el numero cardinal a convertir
	 * 
	 * @param generoMasculino
	 *            enviar true si la lista es de articulos con genero masculino,
	 *            false si es femenino.
	 * @return el numero ordinal como palabra en forma de string
	 */
	public static String convertidorCardinalOrdinal(Integer numero, Boolean generoMasculino) {
		Integer unidad = 0;
		Integer decena = 0;
		Integer centena = 0;
		/*
		 * Iniciamos con una terminacion en A en el genero (genero femenino)
		 */
		String genero = "A";
		StringBuilder numeroOrdinal = new StringBuilder();

		/*
		 * Verificamos si es de genero masculino, de serlo cambiamos la
		 * terminacion a O
		 */
		if (generoMasculino) {
			genero = "O";
		}

		/*
		 * Con el uso del modulo se obtiene el valor de las unidades, decenas y
		 * centenas
		 */
		unidad = (numero % 10);
		decena = (numero / 10) % 10;
		centena = (numero / 100) % 10;

		/*
		 * Se genera la cadena, de acuerdo a el caso de que sea un numero mayor
		 * a la centena, a la decena o si solo son unidades
		 */
		if (numero >= 100 && !centenas[centena].isEmpty()) {
			numeroOrdinal.append(centenas[centena]).append(genero).append(Constantes.ESPACIO);
		}
		if (numero >= 10 && !decenas[decena].isEmpty()) {
			numeroOrdinal.append(decenas[decena]).append(genero).append(Constantes.ESPACIO);
		}
		if (!unidades[unidad].isEmpty()) {
			/*
			 * si no es la posicion 1 o 3 se le agrega el genero
			 */
			if (!(unidades[unidad] == unidades[1] || unidades[unidad] == unidades[3])) {
				numeroOrdinal.append(unidades[unidad]).append(genero).append(Constantes.ESPACIO);
			} else {
				numeroOrdinal.append(unidades[unidad]).append(Constantes.ESPACIO);
			}

		}

		/*
		 * No he considerado crear execpciones particulares para esta clase en
		 * el caso de que se envie un 0 o algo mayor a 999 (dado que es muy
		 * improbable. Pero para evitar algun mal uso he agregado este pequeño
		 * easter egg que salva de un caso muy improbable
		 */
		if (numero == 0) {
			numeroOrdinal = new StringBuilder();
			numeroOrdinal.append(NUMERO_INVALIDO).append(Constantes.ESPACIO);
		}
		if (numero > 999) {
			numeroOrdinal = new StringBuilder();
			numeroOrdinal.append(NUMERO_INVALIDO).append(Constantes.ESPACIO);
		}

		/*
		 * regresamos la cadena formunada
		 */
		return numeroOrdinal.toString();
	}

	/**
	 * Hace una conversion de numeros cardinales a numero ordinal abreviado. Del
	 * 1-999.
	 * 
	 * @param numero
	 *            el numero cardinal a convertir
	 * 
	 * @param generoMasculino
	 *            enviar true si la lista es de articulos con genero masculino,
	 *            false si es femenino.
	 * @return el numero ordinal en forma de string
	 */
	public static String convertidorCarinalOrdinalAbreviado(Integer numero, Boolean generoMasculino) {
		Integer unidad = 0;
		/*
		 * Iniciamos con una terminacion en a en el genero (genero femenino)
		 */
		String genero = "a";
		StringBuilder numeroOrdinal = new StringBuilder();

		/*
		 * verificamos si es de genero masculino, de serlo cambiamos la
		 * terminacion a 0
		 */
		if (generoMasculino) {
			genero = "o";
		}

		/*
		 * con el uso del modulo se obtiene el valor de la unidad (ultima cifra
		 * del numero)
		 */
		unidad = (numero % 10);

		/*
		 * se genera la cadena
		 */
		numeroOrdinal.append(numero.toString()).append(expresionAbreviada[unidad]);

		/*
		 * Se asigna el genero, o en caso de que la terminacion sea 1 o 3, se
		 * deja intacta.
		 */
		if (!(unidad == 1 || unidad == 3)) {
			numeroOrdinal.append(genero);
		}
		numeroOrdinal.append(Constantes.ESPACIO);

		/*
		 * En caso de recibir un 0 o algo >999 se envia el mensaje de numero no
		 * aceptado
		 */
		if (numero == 0) {
			numeroOrdinal = new StringBuilder();
			numeroOrdinal.append(NUMERO_INVALIDO).append(Constantes.ESPACIO);
		}
		if (numero > 999) {
			numeroOrdinal = new StringBuilder();
			numeroOrdinal.append(NUMERO_INVALIDO).append(Constantes.ESPACIO);
		}

		/*
		 * regresamos la cadena formunada
		 */
		return numeroOrdinal.toString();
	}

	private ConversorOrdinales() {
		super();
	}
}
