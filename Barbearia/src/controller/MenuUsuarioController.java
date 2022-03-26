package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuUsuarioController 
{
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	public void CadastrarUsuario(ActionEvent event)
	{
		
		try {
			Parent root =FXMLLoader.load(getClass().getResource("/view/CadastrarUsuario.fxml"));
			//stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage =new Stage();
			stage.setScene(scene);
			stage.setTitle("Cadastrar Usuário");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void TrocarUsuario(ActionEvent event)
	{
		
		try {
			root = FXMLLoader.load(getClass().getResource("/view/TrocarUsuario.fxml"));
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("trocar Usuário");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
}
