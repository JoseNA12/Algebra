package source;
import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {

	@FXML private Stage ventanaPrincipal;
	@FXML private AnchorPane mainLayout;

	@FXML private Button aplicarOE;
	@FXML private Button deshacerOE;
	@FXML private Button botonHistorial;
	@FXML private Button siguienteHistorial;
	@FXML private Button anteriorHistorial;
	@FXML private Label label1;
	@FXML private Label OpElemLabel;
	@FXML private Label MILabel;

	@FXML private TextField campoTexto1;
	@FXML private TextField campoTexto2;
	@FXML private TextField campoTexto3;
	@FXML private TextField campoTexto4;
	@FXML private TextField campoTexto5;

	@FXML private TextField campoTexto6;
	@FXML private TextField campoTexto7;
	@FXML private TextField campoTexto8;
	@FXML private TextField campoTexto9;
	@FXML private TextField campoTexto10;

	@FXML private TextField campoTexto11;
	@FXML private TextField campoTexto12;
	@FXML private TextField campoTexto13;
	@FXML private TextField campoTexto14;
	@FXML private TextField campoTexto15;

	@FXML private TextField campoTexto16;
	@FXML private TextField campoTexto17;
	@FXML private TextField campoTexto18;
	@FXML private TextField campoTexto19;
	@FXML private TextField campoTexto20;

	@FXML private TextField campoTexto21;
	@FXML private TextField campoTexto22;
	@FXML private TextField campoTexto23;
	@FXML private TextField campoTexto24;
	@FXML private TextField campoTexto25;

	@FXML private TextField campoTexto110;
	@FXML private TextField campoTexto26;
	@FXML private TextField campoTexto31;
	@FXML private TextField campoTexto41;
	@FXML private TextField campoTexto51;

	@FXML private TextField campoTexto61;
	@FXML private TextField campoTexto71;
	@FXML private TextField campoTexto81;
	@FXML private TextField campoTexto91;
	@FXML private TextField campoTexto101;

	@FXML private TextField campoTexto111;
	@FXML private TextField campoTexto121;
	@FXML private TextField campoTexto131;
	@FXML private TextField campoTexto141;
	@FXML private TextField campoTexto151;

	@FXML private TextField campoTexto161;
	@FXML private TextField campoTexto171;
	@FXML private TextField campoTexto181;
	@FXML private TextField campoTexto191;
	@FXML private TextField campoTexto201;

	@FXML private TextField campoTexto211;
	@FXML private TextField campoTexto221;
	@FXML private TextField campoTexto231;
	@FXML private TextField campoTexto241;
	@FXML private TextField campoTexto251;


	@FXML private TextField campoOE;
	@FXML private TextField numeroFilas;
	@FXML private TextField numeroColumnas;
	@FXML private Button botonCrearMatriz;


	@FXML private MenuBar MenuBarra;
	@FXML private Menu AyudaMenu;
	@FXML private MenuItem GuiaUsuarioMenu;
	@FXML private MenuItem InformacionMenu;


	String vectorOECopia;
	int columnas;
	int filas;
	int ultimoHistorial = 0;
	int tope = 0;
	String [][] matrizNumeros = new String[5][5];
	String [][] matrizNumerosCopia = new String[5][5];
	TextField [][] matrizTextField = new TextField [5][5];
	String [] vectorHistorial = new String[100];
	String [] vectorOE = new String[100];
	int conteoDeshacer=0;







	@Override
	public void start(Stage pPrimaryStage) throws IOException {

		mainLayout = FXMLLoader.load(getClass().getResource("/fx/VentanaPrincipal.fxml"));
		Scene scene = new Scene(mainLayout);
		this.ventanaPrincipal = pPrimaryStage;
		this.ventanaPrincipal.setTitle("Eliminación Gaussiana");
		this.ventanaPrincipal.setResizable(false);
		ventanaPrincipal.setScene(scene);
		ventanaPrincipal.show();

	}

	public static void main(String[] args) {
		launch(args);
	}


	public void crearMatriz(ActionEvent event){

		cambiarVisibilidad(false);
		try{
			if ( (Integer.parseInt(numeroColumnas.getText()) <= 5 ) & (Integer.parseInt((numeroFilas.getText()))  <= 5)){
				columnas= Integer.parseInt(numeroColumnas.getText());
				filas = Integer.parseInt((numeroFilas.getText()));
			}
			else{
				MostrarAlerta("No se puede crear la matriz", "Favor añada una cantidad de filas y columnas menor o igual a 5", AlertType.ERROR);
			}


		}catch(Exception e){
			MostrarAlerta("No se puede crear la matriz", "Favor añada la cantidad de filas y columnas para crear la matriz", AlertType.ERROR);

		}


		for (int contadorFilas = 1; contadorFilas <= filas; contadorFilas ++ ){


			for (int contadorColumnas = 1; contadorColumnas <= columnas; contadorColumnas ++ ) {

				switch(contadorFilas){

					case 1:
						switch(contadorColumnas){
								case 1:
									campoTexto1.setVisible(true);
									break;
								case 2:
									campoTexto2.setVisible(true);
									break;

								case 3:
									campoTexto3.setVisible(true);
									break;

								case 4:
									campoTexto4.setVisible(true);
									break;

								case 5:
									campoTexto5.setVisible(true);
									break;

								default:
									//Print
									break;

						}
						break;

					case 2:
						switch(contadorColumnas){
							case 1:
								campoTexto6.setVisible(true);
								break;
							case 2:
								campoTexto7.setVisible(true);
								break;

							case 3:
								campoTexto8.setVisible(true);
								break;

							case 4:
								campoTexto9.setVisible(true);
								break;

							case 5:
								campoTexto10.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;

					case 3:
						switch(contadorColumnas){
							case 1:
								campoTexto11.setVisible(true);
								break;
							case 2:
								campoTexto12.setVisible(true);
								break;

							case 3:
								campoTexto13.setVisible(true);
								break;

							case 4:
								campoTexto14.setVisible(true);
								break;

							case 5:
								campoTexto15.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;
					case 4:
						switch(contadorColumnas){
							case 1:
								campoTexto16.setVisible(true);
								break;
							case 2:
								campoTexto17.setVisible(true);
								break;

							case 3:
								campoTexto18.setVisible(true);
								break;

							case 4:
								campoTexto19.setVisible(true);
								break;

							case 5:
								campoTexto20.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;
					case 5:
						switch(contadorColumnas){
							case 1:
								campoTexto21.setVisible(true);
								break;
							case 2:
								campoTexto22.setVisible(true);
								break;

							case 3:
								campoTexto23.setVisible(true);
								break;

							case 4:
								campoTexto24.setVisible(true);
								break;

							case 5:
								campoTexto25.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;

					default:
						break;

					}


				}
			}
	}


	public void rellenarCamposHistorial(){


		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas ++ ){
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {

				switch(contadorFilas){

					case 0:
						switch(contadorColumnas){
								case 0:
									campoTexto110.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;
								case 1:
									campoTexto26.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								case 2:
									campoTexto31.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								case 3:
									campoTexto41.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								case 4:
									campoTexto51.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								default:
									//Print
									break;

						}
						break;

					case 1:
						switch(contadorColumnas){
							case 0:
								campoTexto61.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto71.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto81.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto91.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto101.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;

					case 2:
						switch(contadorColumnas){
							case 0:
								campoTexto111.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto121.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto131.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto141.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto151.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;
					case 3:
						switch(contadorColumnas){
							case 0:
								campoTexto161.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto171.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto181.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto191.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto201.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;
					case 4:
						switch(contadorColumnas){
							case 0:
								campoTexto211.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto221.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto231.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto241.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto251.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;

					default:
						break;

					}


				}
			}


	}

	public void rellenarCamposDeshacer(){
		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas ++ ){
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {

				switch(contadorFilas){

					case 0:
						switch(contadorColumnas){
								case 0:
									campoTexto1.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;
								case 1:
									campoTexto2.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								case 2:
									campoTexto3.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								case 3:
									campoTexto4.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								case 4:
									campoTexto5.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
									break;

								default:
									//Print
									break;

						}
						break;

					case 1:
						switch(contadorColumnas){
							case 0:
								campoTexto6.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto7.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto8.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto9.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto10.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;

					case 2:
						switch(contadorColumnas){
							case 0:
								campoTexto11.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto12.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto13.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto14.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto15.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;
					case 3:
						switch(contadorColumnas){
							case 0:
								campoTexto16.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto17.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto18.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto19.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto20.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;
					case 4:
						switch(contadorColumnas){
							case 0:
								campoTexto21.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto22.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto23.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto24.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto25.setText(matrizNumerosCopia[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;

					default:
						break;

					}


				}
			}


	}

	public void Deshacer(){
		try{
			String matriz = vectorHistorial[tope-conteoDeshacer];
			char [] matrizChar = matriz.toCharArray();
			StringBuilder num = new StringBuilder();
			int columna = 0;
			int fila = 0;

			for( int i=0; i<matrizChar.length; i++){

				   if ((matrizChar[i]!=',')  & (matrizChar[i]!='.')){
					   while ((matrizChar[i]!=',')  & (matrizChar[i]!='.')){
						   num.append(matrizChar[i]);
						   i+= 1;

					   }

					   matrizNumerosCopia[fila][columna] = num.toString();//InsertarValorHistorial(num.toString(), columna, fila);
					   columna+=1;
					   num = new StringBuilder();

				   }else{
					   if (matrizChar[i]=='.'){
						   	columna = 0;
						   	fila+=1;
						   	num = new StringBuilder();

					   }

				   }

				}
			rellenarCamposDeshacer();
			conteoDeshacer+=1;

		}catch(Exception e){
			MostrarAlerta("No se puede deshacer!", "", AlertType.ERROR);


		}
	}
	public void Anterior(){
		try{
			ultimoHistorial = ultimoHistorial - 1;
			historial();
			System.out.print("Anterior ultimo historial "+ultimoHistorial);

		}catch(Exception e){
			MostrarAlerta("No se puede volver atrás en el historial!", "No se puede volver más atrás en el historial. Ya se encuentra en la primera versión de la matriz", AlertType.ERROR);
			ultimoHistorial = ultimoHistorial + 1;
			System.out.print("No se hizo el anterior: "+ultimoHistorial);
		}

	}



	public void Siguiente(){
		try{

			ultimoHistorial = ultimoHistorial + 1;
			historial();
			System.out.print("Siguiente ultimo historial "+ultimoHistorial);

		}
		catch(Exception e){
			MostrarAlerta("No se puede seguir en el historial", "No se puede mover más en el historial. Ya se encuentra en la última versión de la matriz", AlertType.ERROR);
			ultimoHistorial = ultimoHistorial - 1;
			if ( tope< ultimoHistorial){
				ultimoHistorial = ultimoHistorial - 1;
			}
			System.out.print("No se hizo siguiente ultimoHistorial "+ultimoHistorial);
		}
	}

	public void historial(){
		try{

			String matriz = vectorHistorial[ultimoHistorial];
			if (ultimoHistorial != 0){
				vectorOECopia = vectorOE[ultimoHistorial-1];
			}

			char [] matrizChar = matriz.toCharArray();
			StringBuilder num = new StringBuilder();
			int columna = 0;
			int fila = 0;

			verHistorial(true);


//REVISAR



			for( int i=0; i<matrizChar.length; i++){

			   if ((matrizChar[i]!=',')  & (matrizChar[i]!='.')){
				   while ((matrizChar[i]!=',')  & (matrizChar[i]!='.')){
					   num.append(matrizChar[i]);
					   i+= 1;

				   }

				   matrizNumerosCopia[fila][columna] = num.toString();//InsertarValorHistorial(num.toString(), columna, fila);
				   columna+=1;
				   num = new StringBuilder();

			   }else{
				   if (matrizChar[i]=='.'){
					   	columna = 0;
					   	fila+=1;
					   	num = new StringBuilder();

				   }

			   }

			}

			rellenarCamposHistorial();

		}catch(Exception e){
			MostrarAlerta("No se puede mostrar el historial", "No se puede mover más en el historial ya que no se ha creado ninguna matriz", AlertType.ERROR);
		}

	}

	public void verHistorial(boolean x){
		for (int contadorFilas = 1; contadorFilas <= filas; contadorFilas ++ ){


			for (int contadorColumnas = 1; contadorColumnas <= columnas; contadorColumnas ++ ) {

				switch(contadorFilas){

					case 1:
						switch(contadorColumnas){
								case 1:
									campoTexto110.setVisible(true);
									break;
								case 2:
									campoTexto26.setVisible(true);
									break;

								case 3:
									campoTexto31.setVisible(true);
									break;

								case 4:
									campoTexto41.setVisible(true);
									break;

								case 5:
									campoTexto51.setVisible(true);
									break;

								default:
									//Print
									break;

						}
						break;

					case 2:
						switch(contadorColumnas){
							case 1:
								campoTexto61.setVisible(true);
								break;
							case 2:
								campoTexto71.setVisible(true);
								break;

							case 3:
								campoTexto81.setVisible(true);
								break;

							case 4:
								campoTexto91.setVisible(true);
								break;

							case 5:
								campoTexto101.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;

					case 3:
						switch(contadorColumnas){
							case 1:
								campoTexto111.setVisible(true);
								break;
							case 2:
								campoTexto121.setVisible(true);
								break;

							case 3:
								campoTexto131.setVisible(true);
								break;

							case 4:
								campoTexto141.setVisible(true);
								break;

							case 5:
								campoTexto151.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;
					case 4:
						switch(contadorColumnas){
							case 1:
								campoTexto161.setVisible(true);
								break;
							case 2:
								campoTexto171.setVisible(true);
								break;

							case 3:
								campoTexto181.setVisible(true);
								break;

							case 4:
								campoTexto191.setVisible(true);
								break;

							case 5:
								campoTexto201.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;
					case 5:
						switch(contadorColumnas){
							case 1:
								campoTexto211.setVisible(true);
								break;
							case 2:
								campoTexto221.setVisible(true);
								break;

							case 3:
								campoTexto231.setVisible(true);
								break;

							case 4:
								campoTexto241.setVisible(true);
								break;

							case 5:
								campoTexto251.setVisible(true);
								break;

							default:
								//Print
								break;

						}
						break;

					default:
						break;

					}


				}
		}

		siguienteHistorial.setVisible(x);
		anteriorHistorial.setVisible(x);
		label1.setVisible(x);

		if (ultimoHistorial == 0){
			MILabel.setText("Matriz Inicial");
			MILabel.setVisible(true);
			OpElemLabel.setVisible(false);

		}
		else{
			MILabel.setVisible(false);
			OpElemLabel.setText("Operación Elemental: "+vectorOECopia);
			OpElemLabel.setVisible(true);
		}




	}

	public void cambiarVisibilidad(boolean x){
		campoTexto1.setVisible(x);
		campoTexto2.setVisible(x);
		campoTexto3.setVisible(x);
		campoTexto4.setVisible(x);
		campoTexto5.setVisible(x);

		campoTexto6.setVisible(x);
		campoTexto7.setVisible(x);
		campoTexto8.setVisible(x);
		campoTexto9.setVisible(x);
		campoTexto10.setVisible(x);

		campoTexto11.setVisible(x);
		campoTexto12.setVisible(x);
		campoTexto13.setVisible(x);
		campoTexto14.setVisible(x);
		campoTexto15.setVisible(x);

		campoTexto16.setVisible(x);
		campoTexto17.setVisible(x);
		campoTexto18.setVisible(x);
		campoTexto19.setVisible(x);
		campoTexto20.setVisible(x);

		campoTexto21.setVisible(x);
		campoTexto22.setVisible(x);
		campoTexto23.setVisible(x);
		campoTexto24.setVisible(x);
		campoTexto25.setVisible(x);


	}


	public void recabarDatos(){
		Boolean seguir = false;
		Boolean alerta = true;
		String operacionElemental = campoOE.getText();

		matrizNumeros[0][0] = campoTexto1.getText();
		matrizNumeros[0][1] = campoTexto2.getText();
		matrizNumeros[0][2] = campoTexto3.getText();
		matrizNumeros[0][3] = campoTexto4.getText();
		matrizNumeros[0][4] = campoTexto5.getText();

		matrizNumeros[1][0] = campoTexto6.getText();
		matrizNumeros[1][1] = campoTexto7.getText();
		matrizNumeros[1][2] = campoTexto8.getText();
		matrizNumeros[1][3] = campoTexto9.getText();
		matrizNumeros[1][4] = campoTexto10.getText();

		matrizNumeros[2][0] = campoTexto11.getText();
		matrizNumeros[2][1] = campoTexto12.getText();
		matrizNumeros[2][2] = campoTexto13.getText();
		matrizNumeros[2][3] = campoTexto14.getText();
		matrizNumeros[2][4] = campoTexto15.getText();

		matrizNumeros[3][0] = campoTexto16.getText();
		matrizNumeros[3][1] = campoTexto17.getText();
		matrizNumeros[3][2] = campoTexto18.getText();
		matrizNumeros[3][3] = campoTexto19.getText();
		matrizNumeros[3][4] = campoTexto20.getText();

		matrizNumeros[4][0] = campoTexto21.getText();
		matrizNumeros[4][1] = campoTexto22.getText();
		matrizNumeros[4][2] = campoTexto23.getText();
		matrizNumeros[4][3] = campoTexto24.getText();
		matrizNumeros[4][4] = campoTexto25.getText();


		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas ++ ){
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {

				matrizNumeros[contadorFilas][contadorColumnas] = matrizNumeros[contadorFilas][contadorColumnas].replaceAll(" ", "");


				if (matrizNumeros[contadorFilas][contadorColumnas].length()!=0){
					alerta = false;
					seguir = true;


				}
			}
		}


		if ((seguir == true) & (alerta == false)){
			try{
				parsearOpElemental(operacionElemental);
			}catch(Exception e){
				MostrarAlerta("Error con la operación elemental", "Parece que has ingresado una operación elemental o números de casilla inválidos", AlertType.ERROR);

			}

		}
		else{
			MostrarAlerta("Completa todos los campos antes de continuar", "Parece que has olvidado ingresar un dígito en alguna casilla en blanco!", AlertType.ERROR);

		}


	}

	public boolean esNumero(String num){
		try{

			Integer.parseInt(num);

		}
		catch(Exception e){
			return false;
		}

		return true;
	}

	public void soloNumeros(KeyEvent event) {

        String character = event.getCharacter();


        if(esNumero(character) == false){
            event.consume();
        }
    }



	public void parsearOpElemental(String operacionElemental){

		operacionElemental = operacionElemental.replaceAll("\\*", "");
		operacionElemental = operacionElemental.replaceAll(" ", "");
		operacionElemental = operacionElemental.replaceAll(";", ",");
		operacionElemental = operacionElemental.toLowerCase();

		char [] opElemArray = operacionElemental.toCharArray();

		int contador = 0;
		int factor;
		String factorString;
		String numerador;
		String denominador;

		DespintarFila();

		while (contador < opElemArray.length){
			factor = 0;
			factorString = "";
			StringBuilder sb = new StringBuilder();
			StringBuilder numeradorSB= new StringBuilder();
			StringBuilder denominadorSB= new StringBuilder();
			numerador = "";
			denominador = "";


			if (Character.isDigit(opElemArray[contador])){


				while (opElemArray[contador] != 'f'){
					try{
						if (opElemArray[contador] == '/'){
							numeradorSB = sb;
							contador+=1;
							while (opElemArray[contador] != 'f'){
								denominadorSB.append(opElemArray[contador]);
								contador+= 1;

							}
							break;
						}

						sb.append(opElemArray[contador]);
						contador += 1;
					}
					catch(ArrayIndexOutOfBoundsException excepcion){
						MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);
						break;
					}
				}

				factorString = sb.toString();
				factor = Integer.parseInt(factorString);
				numerador= numeradorSB.toString();
				denominador = denominadorSB.toString();


				if (opElemArray[contador] == 'f' && Character.isDigit(opElemArray[contador+1]) == true){

						contador+=1;
						int filaMult = Character.getNumericValue(opElemArray[contador]);
						AgregarHistorial();
						multiplicarFila(opElemArray, factor,  filaMult, numerador, denominador);
						PintarFila(filaMult);
						contador += 1;

						try
						{

							if (opElemArray[contador] == '+'){
								System.out.print("Op"+opElemArray[contador]);
								factorString = "";
								sb = new StringBuilder();
								numeradorSB = new StringBuilder();
								denominadorSB = new StringBuilder();
								contador+= 1;
								if (Character.isDigit(opElemArray[contador]) == true){
									while (opElemArray[contador] != 'f'){
										try{
											if (opElemArray[contador] == '/'){
												numeradorSB = sb;
												contador+=1;
												while (opElemArray[contador] != 'f'){
													denominadorSB.append(opElemArray[contador]);
													contador+= 1;

												}
												break;
											}
											sb.append(opElemArray[contador]);
											contador += 1;
										}
										catch(ArrayIndexOutOfBoundsException excepcion){
											MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);
											break;
										}
									}

									factorString = sb.toString();
									numerador= numeradorSB.toString();
									denominador = denominadorSB.toString();

									factor = Integer.parseInt(factorString);

									if (opElemArray[contador] == 'f' && Character.isDigit(opElemArray[contador+1]) == true){

										contador+=1;
										int filaSuma = Character.getNumericValue(opElemArray[contador]);
										EliminarHistorial();
										AgregarHistorial();
										sumarFilas(opElemArray, factor, filaMult, filaSuma, numerador, denominador);
										PintarFila(filaSuma);

										break;
									}


								}
								else{
									MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \n", AlertType.ERROR);
									break;
								}
							}else{
								System.out.print("xd");
								break;
							}

							//AgregarHistorial();
						}
						catch(ArrayIndexOutOfBoundsException excepcion){
							//AgregarHistorial();
							System.out.print(".");
							break;
						}

				}
				else{
					MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \n", AlertType.ERROR);
					break;
				}

			}

			else{

				try{
					if (opElemArray[contador] == 'f' && Character.isDigit(opElemArray[contador+1]) == true && opElemArray[contador+2] == ','){
						int fila1 = Character.getNumericValue(opElemArray[contador+1]);

						if (opElemArray[contador+3] == 'f' && Character.isDigit(opElemArray[contador+4]) == true){
							int fila2 = Character.getNumericValue(opElemArray[contador+4]);
							AgregarHistorial();
							intercambiarFilas(opElemArray, fila1, fila2);
							PintarFila(fila1);
							PintarFila(fila2);
							contador += 5;
							break;
						}

						else{
							MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);
							break;
						}

					}
					else{
						MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);
							break;
					}
				}catch(ArrayIndexOutOfBoundsException excepcion){
					MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);
					break;
				}


			}
		}
	}


	public void multiplicarFila(char [] opElemenArray, int factor, int filaM, String numerador, String denominador){ //multiplicarFila(opElemArray, factor, opElemArray[contador+1]);

		Rational resultadoRational;
		filaM = filaM - 1;
		if (filaM >= 0){


			Rational FactorRacional;
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {
				if (!numerador.equals("")){
					FactorRacional = new Rational(Integer.parseInt(numerador), Integer.parseInt(denominador));
				}
				else{
					FactorRacional = new Rational(factor, 1);
				}


				String num = matrizNumeros[filaM][contadorColumnas];
				int tamaño = num.length();
				int contador = 0;
				StringBuilder numeradorStr = new StringBuilder();
				StringBuilder denominadorStr = new StringBuilder();
				String numeradorM;
				String denominadorM;

				while (tamaño > contador){
					char aChar = num.charAt(contador);
					if (aChar == '/'){
						contador+=1;
						while (tamaño > contador){
							aChar = num.charAt(contador);

							denominadorStr.append(aChar);
							contador+=1;
						}
						break;
					}
					numeradorStr.append(aChar);
					contador+=1;

				}

				numeradorM = numeradorStr.toString();


				if (denominadorStr.toString().equals("")){
					denominadorM = "1";
				}
				else{
					denominadorM = denominadorStr.toString();
				}


				Rational ElemMatriz = new Rational(Integer.parseInt(numeradorM), Integer.parseInt(denominadorM));
				resultadoRational = FactorRacional.times(ElemMatriz);
				matrizNumeros[filaM][contadorColumnas] = resultadoRational.toString();




			}
			//AgregarHistorial();
			ImprimirMatriz();

		}else{
			MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);

		}


	}

	public void intercambiarFilas(char [] opElemArray, int fila1, int fila2){

		fila1 = fila1 - 1;
		fila2 = fila2 - 1;

		for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {

				String x = matrizNumeros[fila1][contadorColumnas];
				String y = matrizNumeros[fila2][contadorColumnas];

				String temp = x;
				x = y;
				y = temp;


				matrizNumeros[fila1][contadorColumnas] = x;
				matrizNumeros[fila2][contadorColumnas] = y;

			}
		//AgregarHistorial();
		ImprimirMatriz();


	}

	public void sumarFilas(char [] opElemArray, int factor, int filaPrimera, int fila, String numerador, String denominador){ //opElemArray, factor2, filaMult, filaSuma

		multiplicarFila(opElemArray, factor, fila, numerador, denominador);
		filaPrimera = filaPrimera - 1;
		fila = fila -1;
		Rational resultadoRational;

		if ((filaPrimera >= 0) & (fila  >= 0)){
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {


				String num2= matrizNumeros[filaPrimera][contadorColumnas];
				String numFraccionario = matrizNumeros[fila][contadorColumnas];

				StringBuilder numeradorSuma = new StringBuilder();
				StringBuilder denominadorSuma = new StringBuilder();
				StringBuilder numeradorSuma2 = new StringBuilder();
				StringBuilder denominadorSuma2 = new StringBuilder();
				int tamaño = numFraccionario.length();
				int tamaño2 = num2.length();
				int contador = 0;

				while (tamaño > contador){
					char aChar = numFraccionario.charAt(contador);
					if (aChar == '/'){
						contador+=1;
						while (tamaño > contador){
							aChar = num2.charAt(contador);

							denominadorSuma.append(aChar);
							contador+=1;
						}
						break;
					}
					numeradorSuma.append(aChar);
					contador+=1;

				}
				contador=0;

				while (tamaño2 > contador){
					char aChar = num2.charAt(contador);

					if (aChar == '/'){

						contador+=1;
						while (tamaño2 > contador){
							aChar = num2.charAt(contador);
							denominadorSuma2.append(aChar);
							contador+=1;
						}
						break;
					}
					numeradorSuma2.append(aChar);
					contador+=1;

				}

				String numSum = numeradorSuma.toString();
				String denSum;

				if (denominadorSuma.toString().equals("")){
					denSum = "1";
				}
				else{
					denSum = denominadorSuma.toString();
				}


				String numSum2 = numeradorSuma2.toString();
				String denSum2;

				if (denominadorSuma2.toString().equals("")){
					denSum2 = "1";
				}
				else{
					denSum2 = denominadorSuma2.toString();
				}


				Rational ElemMatriz1 = new Rational(Integer.parseInt(numSum), Integer.parseInt(denSum));

				Rational ElemMatriz2 = new Rational(Integer.parseInt(numSum2), Integer.parseInt(denSum2));


				resultadoRational = ElemMatriz1.plus(ElemMatriz2);
				matrizNumeros[fila][contadorColumnas] = resultadoRational.toString();
			}
			ImprimirMatriz();
			//AgregarHistorial();

		}else{
			MostrarAlerta("Operación Elemental mal formulada!", "Parece que has ingresado un formato inválido como Operación Elemental. \nPor favor, verifíque la sección de Ayuda!.", AlertType.ERROR);
		}


	}

	public void AgregarHistorial(){
		StringBuilder strMatriz = new StringBuilder();
		String x = campoOE.getText();

		x = x.toUpperCase();



		for( int i=0; i<columnas; i++){
		   for( int j=0; j<filas; j++){

		      strMatriz.append(matrizNumeros[i][j]);
		      strMatriz.append(",");
		   }

		   strMatriz.append(".");
		}

		String matriz = strMatriz.toString();

		for( int i=0; i<vectorHistorial.length; i++){

			if (vectorHistorial[i]==null){
				vectorHistorial[i] = matriz;
				System.out.print("\nAgregando la matriz "+i+": "+vectorHistorial[i]+"\n");
				vectorOE[i] = x;
				System.out.print("\nAgregando la OE: "+vectorOE[i]+"\n");
			//	ultimoHistorial = i;
				tope = i;

				System.out.print("Indice ultimo historial: "+tope);

				break;
			}

		}



	}

	public void EliminarHistorial(){

		for( int i=0; i<vectorHistorial.length; i++){

			if (vectorHistorial[i]==null){
				vectorHistorial[i-1] = null;
				vectorOE[i-1] = null;
				tope = i-1;


				break;
			}

		}

	}
	public void DespintarFila(){
		campoTexto1.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto2.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto3.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto4.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto5.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto6.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto7.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto8.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto9.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto10.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto11.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto12.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto13.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto14.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto15.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto16.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto17.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto18.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto19.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto20.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto21.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto22.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto23.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto24.setStyle("-fx-background-color: #FFFFFF;");
		campoTexto25.setStyle("-fx-background-color: #FFFFFF;");
	}
	public void PintarFila(int numeroFila){

		switch(numeroFila){

		case 1:
			campoTexto1.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto2.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto3.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto4.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto5.setStyle("-fx-background-color: #F5A9A9;");
			break;
		case 2:
			campoTexto6.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto7.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto8.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto9.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto10.setStyle("-fx-background-color: #F5A9A9;");
			break;
		case 3:
			campoTexto11.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto12.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto13.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto14.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto15.setStyle("-fx-background-color: #F5A9A9;");
			break;
		case 4:
			campoTexto16.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto17.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto18.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto19.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto20.setStyle("-fx-background-color: #F5A9A9;");
			break;
		case 5:
			campoTexto21.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto22.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto23.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto24.setStyle("-fx-background-color: #F5A9A9;");
			campoTexto25.setStyle("-fx-background-color: #F5A9A9;");
			break;
		default:
			break;

		}
	}



	public void ImprimirMatriz(){
		for (int contadorFilas = 0; contadorFilas < filas; contadorFilas ++ ){
			for (int contadorColumnas = 0; contadorColumnas < columnas; contadorColumnas ++ ) {

				switch(contadorFilas){

					case 0:
						switch(contadorColumnas){
								case 0:
									campoTexto1.setText(matrizNumeros[contadorFilas][contadorColumnas]);
									break;
								case 1:
									campoTexto2.setText(matrizNumeros[contadorFilas][contadorColumnas]);
									break;

								case 2:
									campoTexto3.setText(matrizNumeros[contadorFilas][contadorColumnas]);
									break;

								case 3:
									campoTexto4.setText(matrizNumeros[contadorFilas][contadorColumnas]);
									break;

								case 4:
									campoTexto5.setText(matrizNumeros[contadorFilas][contadorColumnas]);
									break;

								default:
									//Print
									break;

						}
						break;

					case 1:
						switch(contadorColumnas){
							case 0:
								campoTexto6.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto7.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto8.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto9.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto10.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;

					case 2:
						switch(contadorColumnas){
							case 0:
								campoTexto11.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto12.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto13.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto14.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto15.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;
					case 3:
						switch(contadorColumnas){
							case 0:
								campoTexto16.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto17.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto18.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto19.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto20.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;
					case 4:
						switch(contadorColumnas){
							case 0:
								campoTexto21.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;
							case 1:
								campoTexto22.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 2:
								campoTexto23.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 3:
								campoTexto24.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							case 4:
								campoTexto25.setText(matrizNumeros[contadorFilas][contadorColumnas]);
								break;

							default:
								//Print
								break;

						}
						break;

					default:
						break;

					}


				}
			}



	}

	public void MostrarAlerta(String pEncabezado, String pCuerpo, AlertType pTipo)
	{
		Alert alert = new Alert(pTipo);
		alert.setTitle("¡Atención!");
		alert.setHeaderText(pEncabezado);
		alert.setContentText(pCuerpo);

		alert.showAndWait();
	}

	public void MostrarGuiaUsuario(ActionEvent event){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Guía de Usuario");
		alert.setHeaderText("Guía de Usuario");
		alert.setContentText(""
				+ "\n 1. Inserte una cantidad de filas y columnas menor o igual que 5 y precione el botón Crear Matriz."
				+ "\n"
				+ "\n 2. Inserte solamente números fraccionarios y enteros en los campos de la matriz creada"
				+ "\n"
				+ "\n 3. Inserte la operación elemental para iniciar a operar la matriz. Formato de operaciones elementales: "
				+ "\n		Cambio de filas: F1;F2 \n		Suma de filas: 2/5F1 + 3F2 \n		Multiplicación de filas: 4/3F1"
				+ "\n"
				+ "\n 4. Presione el botón de Aplicar para ejecutar la operación elemental."
				+ "\n"
				+ "\n 5. Si desea ver el historial de cambios en la matriz, presione el botón Historal y recorra el historial por medio de los botones Siguiente y Anterior"
				+ "\n"
				+ "\n 6. Puede deshacer la aplicación de una operación elemental presionando el botón de Deshacer");

		alert.showAndWait();
	}

	public void MostrarInformacion(ActionEvent event){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Información");
		alert.setHeaderText("Información");
		alert.setContentText(""
				+ "Instituto Tecnológico de Costa Rica"
				+ "\n"
				+ "\n Asistente para la Eliminación Gaussiana"
				+ "\n"
				+ "\n Autores:"
				+ "\n		Josué Suárez Campos"
				+ "\n		José Navarro Acuña"
				+ "\n		Martín Vargas Campos"
				+ "\n");


		alert.showAndWait();
	}

}



