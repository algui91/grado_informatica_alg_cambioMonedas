package com.elbauldelprogramador.algoritmica.progDinamica;

public class BuildConf {
	public static final boolean DEBUG 		 = true;
	public static final int 	WHAT_EXAMPLE = 3;
	public static final int 	EXAMPLE1  	 = 1;
	public static final int 	EXAMPLE2  	 = 2;
	public static final int 	EXAMPLE3  	 = 3;
	
	/**
	 *  Values for examples
	 */
	private final static int P1	 = 8;				// Cantidad a devolver
	private final static int[] C1 = {1, 4, 6};		// Valor de los N tipos de monedas
	private final static int P2	 = 180;				
	private final static int[] C2 = {1, 90, 100};	
	private final static int P3	 = 1000;				
	private final static int[] C3 = {1, 50, 200, 500, 1000};
	
	public static final int returnPforExample(int id) {
		switch (id) {
		case EXAMPLE1:
			return P1;
		case EXAMPLE2:
			return P2;
		case EXAMPLE3:
			return P3;
		default:
			return -1;
		}
	}

	public static final int[] returnCforExample(int id) {
		switch (id) {
		case EXAMPLE1:
			return C1;
		case EXAMPLE2:
			return C2;
		case EXAMPLE3:
			return C3;
		default:
			return null;
		}
	}
}
