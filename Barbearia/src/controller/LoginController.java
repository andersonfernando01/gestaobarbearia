package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import dao.UsuarioDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Usuario;

public class  LoginController extends Application implements Initializable {
	@FXML
	private TextField nome;
	@FXML
	private PasswordField senha;
	@FXML
	private Label validar;
	@FXML
	private Button btnBotao;


	Stage stage = new Stage();
	Scene scene;
	Parent root;
	FXMLLoader loader;

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnBotao.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent evento) {

				Usuario user = new Usuario(nome.getText(), senha.getText());
				UsuarioDAO dao = new UsuarioDAO();
				ResultSet validando = dao.getNomeESenha(user);
				validar.setText("");
				try {
					if (validando.next()) {

						try {

							loader = new FXMLLoader(getClass().getResource("/view/Principal.fxml"));
							root = loader.load();
							scene = new Scene(root);
							stage.setScene(scene);
							stage.setTitle("MENU PRINCIAL");
							stage.setResizable(false);
							stage.show();
							fecharJanela(evento);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null,
									"[erro]:LoginController\n ao construir menu principal" + e);
							e.printStackTrace();
						}

					} else {
						validar.setText("usuário ou senha inválida!");
						validar.setFont(Font.font("Arial", 20));
						validar.setTextFill(Color.RED);
					}

				} catch (SQLException e) {

					JOptionPane.showMessageDialog(null, "[ERRO]: no retorno\n" + e);
				}
			}

		});

	}

	public void fecharJanela(ActionEvent evento) {
		stage = new Stage();
		stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
		stage.close();

	}

}
