package controller;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController {
	Stage stage;
	FXMLLoader loader;
	Parent root;
	Scene scene;
	
	public void cliente()
	{
		
		try {
			loader = new FXMLLoader(getClass().getResource("/view/CadastrarCliente.fxml"));
			root = loader.load();
			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Clientes");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	public void MenuUsuario()
		{
			
			try {
				loader = new FXMLLoader(getClass().getResource("/view/MenuUsuario.fxml"));
				root = loader.load();
				scene = new Scene(root);
				stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Clientes");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void Agendar()
	{
		
		try {
			loader = new FXMLLoader(getClass().getResource("/view/Agenda.fxml"));
			root = loader.load();
			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Agendar");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void servicos()
	{
		
		try {
			loader = new FXMLLoader(getClass().getResource("/view/servicos.fxml"));
			root = loader.load();
			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("serviços");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void relatorio()
	{
		
		try {
			loader = new FXMLLoader(getClass().getResource("/view/Relatorio.fxml"));
			root = loader.load();
			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Relatório");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void Caixa()
	{
		
		try {
			loader = new FXMLLoader(getClass().getResource("/view/Caixa.fxml"));
			root = loader.load();
			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Relatório");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public void fecharJanela(ActionEvent evento)
	{
		Platform.exit();
		System.exit(0);
	}
	
}
