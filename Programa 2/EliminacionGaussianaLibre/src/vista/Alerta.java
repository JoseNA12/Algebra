package vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {

	public static void MostrarAlerta(String pEncabezado, String pCuerpo, AlertType pTipo)
	{
		Alert alert = new Alert(pTipo);
		alert.setTitle("¡Atención!");
		alert.setHeaderText(pEncabezado);
		alert.setContentText(pCuerpo);

		alert.showAndWait();
	}
}
