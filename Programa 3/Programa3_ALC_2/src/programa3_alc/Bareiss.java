package programa3_alc;

public class Bareiss {

	private float matriz[][];
	private int dimension = 0;

	private float pivotes[];

	private String determinante;
	private int signoDeterminante;

	private float[] incognitasSistema;

	private String matricesResultantes;


	public Bareiss(float[][] pMatriz, int pDimensionMatriz)
	{
		matriz = pMatriz;
		dimension = pDimensionMatriz;
		incognitasSistema = new float[dimension];
	}

	public String getDeterminante() { return determinante; }
	public float[] getIncognitasSistema() { return incognitasSistema; }
	public String getMatricesResultantes() { return matricesResultantes; }

	public boolean IniciarProceso()
	{
		// Nuevo elemento =  (pivote act) (elemento act) - (E.C.CP columna) (E.C.f.P fila) / pivote anterior

		matricesResultantes = "";

		if (!ObtenerPivotes()) // En caso de que la diagonal tenga uno o varios ceros
		{
			IntercambiarFilas();	// Intercambiar filas hasta que no existan ceros en la diagonal
		}

		float pivoteAnterior = 1; // pivote auxiliar, de primera instancia es 1
		for (int i = 0; i < dimension; i++) {

			//System.out.println("1) DiagonalDeterminante");
			DiagonalDeterminante(i);
			//ImprimirMatriz();

			try
			{
				//System.out.println("2) PrimerCuadrante");
				PrimerCuadrante(i, pivoteAnterior);
				//ImprimirMatriz();
				//System.out.println("3) CuartoCuadrante");
				CuartoCuadrante(i, pivoteAnterior);
				//ImprimirMatriz();
			}
			catch (ArithmeticException e)
			{
				//Alerta.MostrarAlerta("Sistema de ecuaciones inv�lido", "Al parecer has insertado un sistema de ecuaciones inv�lido y/o imposible de resolver!.", AlertType.ERROR);
				return false;
			}
			//System.out.println("4) PonerCerosColumnas");
			PonerCerosColumna(i);
			//ImprimirMatriz();

			pivoteAnterior = matriz[i][i];

		}

		//ImprimirMatriz();
		EncontrarIncognitas();

		return true;
	}

	private void DiagonalDeterminante(int indice)
	{
		for (int i = 0; i < indice; i++)
		{
                    matriz[i][i] = matriz[indice][indice];
		}
	}

	 // indice es la posici�n donde se encuentra el determinante en
	private void PrimerCuadrante(int indice, float pivoteAnterior)
	{
		for (int i = 0; i < indice; i++)
		{
			for (int j = indice + 1; j < dimension + 1; j++)
			{
				// a_ij = (a_ik * a_kj - a_kk * a_ij) / pivote

                            matriz[i][j] = (((matriz[i][indice] * matriz[indice][j]) -
				(matriz[indice][indice] * matriz[i][j])) * -1) / pivoteAnterior;
			}
		}
	}

	private void CuartoCuadrante(int indice, float pivoteAnterior) // indice es la posici�n donde se encuentra el determinante
	{
		for (int i = indice + 1; i < matriz.length; i++)
		{
			for (int j = indice + 1; j < dimension + 1; j++)
			{
				// a_ij = (a_kk * a_ij - a_ik * a_kj) / pivote

				matriz[i][j] = ((matriz[indice][indice] * matriz[i][j]) -
								 (matriz[i][indice] * matriz[indice][j])) / pivoteAnterior;
			}
		}
	}

	private boolean ObtenerPivotes() // Obtener todos los pivotes del sistema (diagonal principal)
	{
		pivotes = new float[dimension];
		for (int i = 0; i < dimension; i++)
		{
			if (matriz[i][i] == 0) { return false; } // Se necesita intercambiar filas, hay un cero en un pivote

			pivotes[i] = matriz[i][i];
		}
		return true; // Todo bien, todo correcto, y yo que me alegro
	}

	private int ValidarDiagonal() // Verificar que no haya 0 en la diagonal principal
	{
		for(int i = 0; i < dimension; i++)
		{
			if(matriz[i][i] == 0) { return i; } // Retorne el indice de la fila donde esta el 0 en la diagonal
		}
		return -1;
	}

	private void IntercambiarFilas() // intercambia filas hasta que no hayan en la diagonal
	{
		float[] filaAux = new float[dimension];
		int problema = -1; // numero de la donde hay un 0
		int contador = 0;

		// problema = ValidarDiagonal()

		while(((problema = ValidarDiagonal()) != -1) && contador < 1000) // Pruebe hasta mil combinaciones
		{
			for(int i = 0; i < dimension; i++)
			{
				filaAux = matriz[problema];
				matriz[problema] = matriz[i];
				matriz[i] = filaAux;

				signoDeterminante *= -1;
			}
			contador++;
			// problema = ValidarDiagonal()
		}
	}

	private void PonerCerosColumna(int pColumna) // Convierte los n�meros que se encuentran en la columna indicada en ceros.
	{
		for (int x = 0; x < dimension; x++)
		{
			if (x == pColumna) { continue; } // Evitar el pivote
			else { matriz[x][pColumna] = 0; }
		}
	}

	private void EncontrarIncognitas()
	{
		boolean infinitaSoluciones = false;
		boolean sinSolucion = false;
		String matrizResultante[] = new String [dimension];

		for (int i = 0; i < dimension; i++)
		{
			if( matriz[i][i] == 0 )
			{
				if (matriz[i][dimension] == 0) { infinitaSoluciones = true; }
				else { sinSolucion = true; }
			}
			else
			{
                            matrizResultante[i] = Float.toString(matriz[i][dimension] / matriz[i][i]);
			}
		}

		if(sinSolucion == true)
		{
                    //System.out.print("SIN SOLUCION");
                    determinante = "0";
			//Alerta.MostrarAlerta("Sin soluci�n", "El sistema que has ingresado no tiene soluci�n!.", AlertType.INFORMATION);
		}
		else
		{
			if (infinitaSoluciones == true)
			{
                            //System.out.print("INFINITAS SOLUCION");
                            determinante = "0";
				//Alerta.MostrarAlerta("Infinitas soluciones", "El sistema que has ingresado tiene infinitas soluciones!.", AlertType.INFORMATION);
			}
			else
			{
				for (int i = 0; i < dimension; i++)
				{
                                    if (i == dimension - 1) { determinante = Integer.toString((int) matriz[dimension - 1][dimension - 1]); }
                                    incognitasSistema[i] = Float.valueOf(matrizResultante[i]);
				}
			}
		}
	}

	private void ImprimirMatriz()
	{
		for (int i = 0; i < dimension; i++)
		{
			for (int j = 0; j < dimension + 1; j++)
			{
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}


}
