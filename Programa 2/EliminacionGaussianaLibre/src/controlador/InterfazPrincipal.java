package controlador;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logica.Bareiss;
import vista.Alerta;


public class InterfazPrincipal extends Application {

	private enum Ecuacion {UNO, DOS, TRES, CUATRO, CINCO}

	@FXML private Stage ventanaPrincipal;
	@FXML private AnchorPane mainLayout;

	@FXML private Menu menu_GenerarNuevaMatriz;
	@FXML private MenuItem menuItem_tamanio2x2;
	@FXML private MenuItem menuItem_tamanio3x3;
	@FXML private MenuItem menuItem_tamanio4x4;
	@FXML private MenuItem menuItem_tamanio5x5;

	@FXML private GridPane gridPane_Matriz;

	@FXML private TextField textField_Casilla_0_0;
	@FXML private TextField textField_Casilla_0_1;
	@FXML private TextField textField_Casilla_0_2;
	@FXML private TextField textField_Casilla_0_3;
	@FXML private TextField textField_Casilla_0_4;
	@FXML private TextField textField_Casilla_0_5;

	@FXML private TextField textField_Casilla_1_0;
	@FXML private TextField textField_Casilla_1_1;
	@FXML private TextField textField_Casilla_1_2;
	@FXML private TextField textField_Casilla_1_3;
	@FXML private TextField textField_Casilla_1_4;
	@FXML private TextField textField_Casilla_1_5;

	@FXML private TextField textField_Casilla_2_0;
	@FXML private TextField textField_Casilla_2_1;
	@FXML private TextField textField_Casilla_2_2;
	@FXML private TextField textField_Casilla_2_3;
	@FXML private TextField textField_Casilla_2_4;
	@FXML private TextField textField_Casilla_2_5;

	@FXML private TextField textField_Casilla_3_0;
	@FXML private TextField textField_Casilla_3_1;
	@FXML private TextField textField_Casilla_3_2;
	@FXML private TextField textField_Casilla_3_3;
	@FXML private TextField textField_Casilla_3_4;
	@FXML private TextField textField_Casilla_3_5;

	@FXML private TextField textField_Casilla_4_0;
	@FXML private TextField textField_Casilla_4_1;
	@FXML private TextField textField_Casilla_4_2;
	@FXML private TextField textField_Casilla_4_3;
	@FXML private TextField textField_Casilla_4_4;
	@FXML private TextField textField_Casilla_4_5;

	@FXML private Text text_Ecuacion_1;
	@FXML private Text text_Ecuacion_2;
	@FXML private Text text_Ecuacion_3;
	@FXML private Text text_Ecuacion_4;
	@FXML private Text text_Ecuacion_5;

	@FXML private TextArea textArea_Resultado;

	public int dimensionMatriz = 0;

	public String Ecuacion_1 = "";
	public String Ecuacion_2 = "";
	public String Ecuacion_3 = "";
	public String Ecuacion_4 = "";
	public String Ecuacion_5 = "";

	public String[][] matrizNumeros = new String[5][6];


	@Override
	public void start(Stage pPrimaryStage) throws IOException
	{
		this.ventanaPrincipal = pPrimaryStage;
		this.ventanaPrincipal.setTitle("Eliminación Gaussiana libre de fracciones");
		this.ventanaPrincipal.setResizable(false);

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(InterfazPrincipal.class.getResource("/vista/InterfazPrincipal.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		ventanaPrincipal.setScene(scene);
		ventanaPrincipal.show();

		KeyListener(scene);
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	private void KeyListener(Scene scene)
	{
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event ->
		{
			switch(event.getCode())
			{
			case ENTER:
				//ResolverSistema(null);

			default:
				break;
			}
			//System.out.println("Pressed: " + event.getCode());
		});
	}

	public void DefinirTamanioMatriz2x2(ActionEvent event)
	{
		GenerarMatriz(2);
	}

	public void DefinirTamanioMatriz3x3(ActionEvent event)
	{
		GenerarMatriz(3);
	}

	public void DefinirTamanioMatriz4x4(ActionEvent event)
	{
		GenerarMatriz(4);
	}

	public void DefinirTamanioMatriz5x5(ActionEvent event)
	{
		GenerarMatriz(5);
	}

	private void GenerarMatriz(int pDimension)
	{
		dimensionMatriz = pDimension;
		gridPane_Matriz.setDisable(false);
		// Poner todas las casillas invisibles y borrar su contenido
		ManejarEstadoCasillasMatriz(Ecuacion.UNO, true, false, false, false, false, false, false);
		ManejarEstadoCasillasMatriz(Ecuacion.DOS, true, false, false, false, false, false, false);
		ManejarEstadoCasillasMatriz(Ecuacion.TRES, true, false, false, false, false, false, false);
		ManejarEstadoCasillasMatriz(Ecuacion.CUATRO, true, false, false, false, false, false, false);
		ManejarEstadoCasillasMatriz(Ecuacion.CINCO, true, false, false, false, false, false, false);


		switch (dimensionMatriz)
		{
		case 2:
			ManejarEstadoCasillasMatriz(Ecuacion.UNO, true, true, true, true, false, false, false);
			ManejarEstadoCasillasMatriz(Ecuacion.DOS,  true, true, true, true, false, false, false);
			break;

		case 3:
			ManejarEstadoCasillasMatriz(Ecuacion.UNO, true, true, true, true, true, false, false);
			ManejarEstadoCasillasMatriz(Ecuacion.DOS, true, true, true, true, true, false, false);
			ManejarEstadoCasillasMatriz(Ecuacion.TRES, true, true, true, true, true, false, false);
			break;

		case 4:
			ManejarEstadoCasillasMatriz(Ecuacion.UNO, true, true, true, true, true, true, false);
			ManejarEstadoCasillasMatriz(Ecuacion.DOS, true, true, true, true, true, true, false);
			ManejarEstadoCasillasMatriz(Ecuacion.TRES, true, true, true, true, true, true, false);
			ManejarEstadoCasillasMatriz(Ecuacion.CUATRO, true, true, true, true, true, true, false);
			break;

		case 5:
			ManejarEstadoCasillasMatriz(Ecuacion.UNO, true, true, true, true, true, true, true);
			ManejarEstadoCasillasMatriz(Ecuacion.DOS, true, true, true, true, true, true, true);
			ManejarEstadoCasillasMatriz(Ecuacion.TRES, true, true, true, true, true, true, true);
			ManejarEstadoCasillasMatriz(Ecuacion.CUATRO, true, true, true, true, true, true, true);
			ManejarEstadoCasillasMatriz(Ecuacion.CINCO, true, true, true, true, true, true, true);
			break;

		default:
			break;

		}
	}

	private void ManejarEstadoCasillasMatriz(Ecuacion pEcuacion, boolean borrarContenido, boolean casilla1, boolean casilla2, boolean casilla3, boolean casilla4, boolean casilla5, boolean casilla6)
	{
		switch (pEcuacion)
		{
		case UNO:
			textField_Casilla_0_0.setVisible(casilla1);
			textField_Casilla_0_1.setVisible(casilla2);
			textField_Casilla_0_2.setVisible(casilla3);
			textField_Casilla_0_3.setVisible(casilla4);
			textField_Casilla_0_4.setVisible(casilla5);
			textField_Casilla_0_5.setVisible(casilla6);
			break;

		case DOS:
			textField_Casilla_1_0.setVisible(casilla1);
			textField_Casilla_1_1.setVisible(casilla2);
			textField_Casilla_1_2.setVisible(casilla3);
			textField_Casilla_1_3.setVisible(casilla4);
			textField_Casilla_1_4.setVisible(casilla5);
			textField_Casilla_1_5.setVisible(casilla6);
			break;

		case TRES:
			textField_Casilla_2_0.setVisible(casilla1);
			textField_Casilla_2_1.setVisible(casilla2);
			textField_Casilla_2_2.setVisible(casilla3);
			textField_Casilla_2_3.setVisible(casilla4);
			textField_Casilla_2_4.setVisible(casilla5);
			textField_Casilla_2_5.setVisible(casilla6);
			break;

		case CUATRO:
			textField_Casilla_3_0.setVisible(casilla1);
			textField_Casilla_3_1.setVisible(casilla2);
			textField_Casilla_3_2.setVisible(casilla3);
			textField_Casilla_3_3.setVisible(casilla4);
			textField_Casilla_3_4.setVisible(casilla5);
			textField_Casilla_3_5.setVisible(casilla6);
			break;

		case CINCO:
			textField_Casilla_4_0.setVisible(casilla1);
			textField_Casilla_4_1.setVisible(casilla2);
			textField_Casilla_4_2.setVisible(casilla3);
			textField_Casilla_4_3.setVisible(casilla4);
			textField_Casilla_4_4.setVisible(casilla5);
			textField_Casilla_4_5.setVisible(casilla6);
			break;
		}

		if (borrarContenido)
		{
			textField_Casilla_0_0.setText("");
			textField_Casilla_0_1.setText("");
			textField_Casilla_0_2.setText("");
			textField_Casilla_0_3.setText("");
			textField_Casilla_0_4.setText("");
			textField_Casilla_0_5.setText("");

			textField_Casilla_1_0.setText("");
			textField_Casilla_1_1.setText("");
			textField_Casilla_1_2.setText("");
			textField_Casilla_1_3.setText("");
			textField_Casilla_1_4.setText("");
			textField_Casilla_1_5.setText("");

			textField_Casilla_2_0.setText("");
			textField_Casilla_2_1.setText("");
			textField_Casilla_2_2.setText("");
			textField_Casilla_2_3.setText("");
			textField_Casilla_2_4.setText("");
			textField_Casilla_2_5.setText("");

			textField_Casilla_3_0.setText("");
			textField_Casilla_3_1.setText("");
			textField_Casilla_3_2.setText("");
			textField_Casilla_3_3.setText("");
			textField_Casilla_3_4.setText("");
			textField_Casilla_3_5.setText("");

			textField_Casilla_4_0.setText("");
			textField_Casilla_4_1.setText("");
			textField_Casilla_4_2.setText("");
			textField_Casilla_4_3.setText("");
			textField_Casilla_4_4.setText("");
			textField_Casilla_4_5.setText("");

			RestablecerEcuaciones();

			text_Ecuacion_1.setText("");
			text_Ecuacion_2.setText("");
			text_Ecuacion_3.setText("");
			text_Ecuacion_4.setText("");
			text_Ecuacion_5.setText("");

			textArea_Resultado.setText("");
		}
	}

	private void RestablecerEcuaciones()
	{
		Ecuacion_1 = "";
		Ecuacion_2 = "";
		Ecuacion_3 = "";
		Ecuacion_4 = "";
		Ecuacion_5 = "";
	}

	private boolean RecabarDatos()
	{
		int filas = dimensionMatriz;
		int columnas = dimensionMatriz + 1; // Incluir el digito después de la igualación de la ecuación -> =

		matrizNumeros[0][0] = textField_Casilla_0_0.getText();
		matrizNumeros[0][1] = textField_Casilla_0_1.getText();
		matrizNumeros[0][2] = textField_Casilla_0_2.getText();
		matrizNumeros[0][3] = textField_Casilla_0_3.getText();
		matrizNumeros[0][4] = textField_Casilla_0_4.getText();
		matrizNumeros[0][5] = textField_Casilla_0_5.getText();

		matrizNumeros[1][0] = textField_Casilla_1_0.getText();
		matrizNumeros[1][1] = textField_Casilla_1_1.getText();
		matrizNumeros[1][2] = textField_Casilla_1_2.getText();
		matrizNumeros[1][3] = textField_Casilla_1_3.getText();
		matrizNumeros[1][4] = textField_Casilla_1_4.getText();
		matrizNumeros[1][5] = textField_Casilla_1_5.getText();

		matrizNumeros[2][0] = textField_Casilla_2_0.getText();
		matrizNumeros[2][1] = textField_Casilla_2_1.getText();
		matrizNumeros[2][2] = textField_Casilla_2_2.getText();
		matrizNumeros[2][3] = textField_Casilla_2_3.getText();
		matrizNumeros[2][4] = textField_Casilla_2_4.getText();
		matrizNumeros[2][5] = textField_Casilla_2_5.getText();

		matrizNumeros[3][0] = textField_Casilla_3_0.getText();
		matrizNumeros[3][1] = textField_Casilla_3_1.getText();
		matrizNumeros[3][2] = textField_Casilla_3_2.getText();
		matrizNumeros[3][3] = textField_Casilla_3_3.getText();
		matrizNumeros[3][4] = textField_Casilla_3_4.getText();
		matrizNumeros[3][5] = textField_Casilla_3_5.getText();

		matrizNumeros[4][0] = textField_Casilla_4_0.getText();
		matrizNumeros[4][1] = textField_Casilla_4_1.getText();
		matrizNumeros[4][2] = textField_Casilla_4_2.getText();
		matrizNumeros[4][3] = textField_Casilla_4_3.getText();
		matrizNumeros[4][4] = textField_Casilla_4_4.getText();
		matrizNumeros[4][5] = textField_Casilla_4_5.getText();


		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas++)
		{
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas++)
			{
				matrizNumeros[contadorFilas][contadorColumnas] = matrizNumeros[contadorFilas][contadorColumnas].replaceAll(" ", "");

				if (matrizNumeros[contadorFilas][contadorColumnas].length() == 0) { return false; }
			}
		}
		return true;
	}

	private String AgregarIncognitasEcuacion(String pEcuacion)
	{
		String nuevaEcuacion = "";
		int miDimension = dimensionMatriz;
		int i = 0;
		boolean agregarResto = false;

		while (true)
		{
			if (pEcuacion.length() == i) { break; }

			if (pEcuacion.charAt(i) == '=') { nuevaEcuacion += "x"; agregarResto = true; }

			if (pEcuacion.charAt(i) == '+' || pEcuacion.charAt(i) == '-' && i != 0 && agregarResto != true)
			{
				if (miDimension == 1)
				{
					nuevaEcuacion += "x" + pEcuacion.charAt(i);
					miDimension -= 1;
				}
				else
				{
					String indice = Integer.toString(miDimension);
					nuevaEcuacion += "x^" + indice + pEcuacion.charAt(i);
					miDimension -= 1;
				}
			}
			else
			{
				nuevaEcuacion += pEcuacion.charAt(i);
			}
			i += 1;
		}

		return nuevaEcuacion;
	}

	private boolean FormaEcuaciones()
	{
		int filas = dimensionMatriz;
		int columnas = dimensionMatriz + 1; // Incluir el digito después de la igualación de la ecuación -> =

		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas++)
		{
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas++)
			{
				try
				{
					switch (contadorFilas)
					{

					case 0:
						if (contadorColumnas == 0)
						{
							int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
							Ecuacion_1 += matrizNumeros[contadorFilas][contadorColumnas];
						}
						else
						{
							if (contadorColumnas == dimensionMatriz)
							{
								int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
								Ecuacion_1 += "=" + matrizNumeros[contadorFilas][contadorColumnas];
							}
							else
							{
								Ecuacion_1 += VerificarNumero(matrizNumeros[contadorFilas][contadorColumnas]);
							}
						}
						break;

					case 1:
						if (contadorColumnas == 0)
						{
							int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
							Ecuacion_2 += matrizNumeros[contadorFilas][contadorColumnas];
						}
						else
						{
							if (contadorColumnas == dimensionMatriz)
							{
								int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
								Ecuacion_2 += "=" + matrizNumeros[contadorFilas][contadorColumnas];
							}
							else
							{
								Ecuacion_2 += VerificarNumero(matrizNumeros[contadorFilas][contadorColumnas]);
							}
						}
						break;

					case 2:
						if (contadorColumnas == 0)
						{
							int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
							Ecuacion_3 += matrizNumeros[contadorFilas][contadorColumnas];
						}
						else
						{
							if (contadorColumnas == dimensionMatriz)
							{
								int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
								Ecuacion_3 += "=" + matrizNumeros[contadorFilas][contadorColumnas];
							}
							else
							{
								Ecuacion_3 += VerificarNumero(matrizNumeros[contadorFilas][contadorColumnas]);
							}
						}
						break;

					case 3:
						if (contadorColumnas == 0)
						{
							int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
							Ecuacion_4 += matrizNumeros[contadorFilas][contadorColumnas];
						}
						else
						{
							if (contadorColumnas == dimensionMatriz)
							{
								int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
								Ecuacion_4 += "=" + matrizNumeros[contadorFilas][contadorColumnas];
							}
							else
							{
								Ecuacion_4 += VerificarNumero(matrizNumeros[contadorFilas][contadorColumnas]);
							}
						}
						break;

					case 4:
						if (contadorColumnas == 0)
						{
							int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
							Ecuacion_5 += matrizNumeros[contadorFilas][contadorColumnas];
						}
						else
						{
							if (contadorColumnas == dimensionMatriz)
							{
								int num = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]); // Existe un simbolo
								Ecuacion_5 += "=" + matrizNumeros[contadorFilas][contadorColumnas];
							}
							else
							{
								Ecuacion_5 += VerificarNumero(matrizNumeros[contadorFilas][contadorColumnas]);
							}
						}
						break;

					default:
						return false;
					}
				}
				catch (Exception e)
				{
					return false;
				}
			}
		}

		Ecuacion_1 = AgregarIncognitasEcuacion(Ecuacion_1);
		Ecuacion_2 = AgregarIncognitasEcuacion(Ecuacion_2);
		Ecuacion_3 = AgregarIncognitasEcuacion(Ecuacion_3);
		Ecuacion_4 = AgregarIncognitasEcuacion(Ecuacion_4);
		Ecuacion_5 = AgregarIncognitasEcuacion(Ecuacion_5);

		text_Ecuacion_1.setText(Ecuacion_1);
		text_Ecuacion_2.setText(Ecuacion_2);
		text_Ecuacion_3.setText(Ecuacion_3);
		text_Ecuacion_4.setText(Ecuacion_4);
		text_Ecuacion_5.setText(Ecuacion_5);

		return true;
	}

	private String VerificarNumero(String pNumero)
	{
		int numero = Integer.parseInt(pNumero);

		if (numero >= 0){ return "+" + pNumero; }
		else { return pNumero; }
	}

	private int[][] ObtenerMatrizNumeros(String[][] pMatriz)
	{
		int filas = dimensionMatriz;
		int columnas = dimensionMatriz + 1;

		int[][] matriz = new int[filas][columnas];

		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas++)
		{
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas++)
			{
				matriz[contadorFilas][contadorColumnas] = Integer.parseInt(matrizNumeros[contadorFilas][contadorColumnas]);
			}
		}

		return matriz;
	}

	public void ResolverSistema(ActionEvent event)
	{
		if (dimensionMatriz != 0)
		{
			boolean puedeResolver = RecabarDatos();
			if (puedeResolver)
			{
				RestablecerEcuaciones();
				boolean iniciar = FormaEcuaciones();

				if (iniciar)
				{
					Bareiss bareiss = new Bareiss(ObtenerMatrizNumeros(matrizNumeros), dimensionMatriz);
					bareiss.IniciarProceso();

					textArea_Resultado.setText("");
					textArea_Resultado.appendText(bareiss.getMatricesResultantes()); //(bareiss.getIncognitasSistema()).toString() + bareiss.getDeterminante());
					textArea_Resultado.appendText("Determinante: " + bareiss.getDeterminante());
					textArea_Resultado.appendText("\nIncognitas:\n" + bareiss.getIncognitasSistema());
				}
				else
				{
					Alerta.MostrarAlerta("Solo se aceptan números enteros!", "Parece que has ingresado un caracter inválido en una o varias casillas. \nPor favor, verifíque los campos!.", AlertType.ERROR);
				}
			}
			else
			{
				Alerta.MostrarAlerta("Completa todos los campos antes de continuar", "Parece que has olvidado ingresar un dígito en alguna casilla en blanco!", AlertType.ERROR);
			}
		}
		else
		{
			Alerta.MostrarAlerta("No has generado una matriz!", "Parece que no has creado una matriz, créala e inserta todos los valores que consideres necesarios.", AlertType.ERROR);
		}
	}

}
