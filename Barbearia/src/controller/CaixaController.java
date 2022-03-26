package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CaixaController {
	 
	Stage stage;
	
	public void fecharJanela(ActionEvent evento) {
		stage = new Stage();
		stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
		stage.close();
	}
}
