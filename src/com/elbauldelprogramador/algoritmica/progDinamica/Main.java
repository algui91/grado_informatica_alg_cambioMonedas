package com.elbauldelprogramador.algoritmica.progDinamica;

public class Main {
	
	private final static int P	 = 
			BuildConf.returnPforExample(BuildConf.WHAT_EXAMPLE);	// Cantidad a devolver
	private final static int[] C = 
			BuildConf.returnCforExample(BuildConf.WHAT_EXAMPLE);	// Valor de los N tipos de monedas
	
	private static void cambio(final int[] C, final int cantidadADevolver) {

	    int cAct;
	    final int n = C.length+1;
	    final int p = cantidadADevolver + 1;
	    final int inf = Integer.MAX_VALUE-1;

	    final int[][] D = new int[n][p];

	    for (int j = 1; j < p; j++)
	        D[0][j] = inf;
	    for (int i = 1; i < n; i++)
	    	D[i][0] = 0;
	    
	    for (int i = 1; i < n; i++) {
	        for (int j = 1; j < p; j++) {
	            if (j - C[i-1] >= 0) // j reperesenta la cantidad a devolver
	                // Si la cantidad a devolver menos el valor dela moneda no es negativo, 
	            	// quiere decir que es posible hacer la devulición con dicha moneda
	            	cAct = D[i][j - C[i-1]];
	            else
	            	// No se puede devolver la cantidad j con el valor de la moneda C[i-1]
	            	// ya que el valor de la moneda es mayor que la cantidad a devolver
	            	// por tanto, acumulamos inf y usaremos la moneda anterior, que sí puede devolver la 
	            	// cantidad j
	                cAct = inf; 
	            // Si cAct es inf, quiere decir que no se pudo devolver la cantidad j usando la moneda C[i-1],
	            // Por tanto usamos los valores de la moneda anterior.
	            D[i][j] = Math.min(D[i-1][j], 1 + cAct);
	        }
	    }

	    
	    if (BuildConf.DEBUG)
		    for (int i = 0; i < C.length + 1; i++) {
		    	for (int j = 0; j < P + 1; j++) {
					System.out.print(D[i][j] + " ");
				}
		    	System.out.print("\n");
			} 
	    //return table[n-1][p-1];
	    System.out.print("El mínimo número de monedas a usar es " + D[n-1][p-1] + "\n");
	    recomponerSolucion(D);
	}
	
	public static void recomponerSolucion(final int[][] D){
		// Recomponer la solución para indicar qué tipos de monedas se han usado
	    int[] x = new int[C.length];
	    int i = C.length;//n - 1;
	    int j = P;//p - 1;
	    
	    while (i != 0 && j != 0){
	    	if (D[i][j] == D[i-1][j]) // Si se ha usado la misma moneda
	    		i-=1;				  // Retrocedemos a la moneda anterior
	    	else {
	    		x[i-1] +=  1;		  // Si no se ha usado la misma cantidad de monedas
	    		j -= C[i - 1];		  // Quiere decir que se ha usado la moneda C[i], actualizamos 
	    	}						  // j quitándole lo que vale la moneda para seguir comprobando si 
	    							  // hemos vuelto a usar la misma moneda
	    }
	    
	    System.out.print("El valor de cada moneda usada es: \n");
	    for (int k = 0; k < x.length; k++)
	    	if (x[k] != 0){
	    		int cantidad = x[k];
	    		while (cantidad-- != 0)
	    			System.out.print("\t1 moneda de " + C[k] + "\n");
	    	}
	}
	
	public static void main(String[] args) {
		cambio(C, P);
	}

}