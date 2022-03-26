package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.UsuarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Usuario;

public class CadastrarUsuarioController implements Initializable {

	Stage stage;
	FXMLLoader loader;
	Parent root;
	Scene scene;
	
	@FXML
	private TextField tfdCodigo;
	@FXML
	private TextField tfdNome;
	@FXML
	private TextField tfdTelefone;
	@FXML
	private TextField tfdEmail;
	@FXML
	private TextField tfdSenha;
	@FXML
	private TextField tfdConfirmarSenha;
	
	@FXML	
	private Button btnCancelar;
	@FXML	
	private Button btnSalvar;
	@FXML	
	private Button btnEditar;
	@FXML	
	private Button btnApagar;
	@FXML	
	private Button btnNovo;
	
	@FXML
	private ComboBox<String> tfdGenero;
	@FXML
	private ComboBox<String> tfdNivelAcesso;
	@FXML
	private DatePicker dpDataNascimento;
	@FXML
	private TextField tfdEndereco;
	@FXML
	private TableView<Usuario> Tabela;
	@FXML
	private TableColumn<Usuario, Integer>tbId;
	@FXML
	private TableColumn<Usuario, String> tbNome;
	@FXML
	private TableColumn<Usuario, String> tbGenero;
	@FXML
	private TableColumn<Usuario, String> tbNascimento;
	@FXML
	private TableColumn<Usuario, String> tbTelefone;
	@FXML
	private TableColumn<Usuario, String> tbEmail;
	@FXML
	private TableColumn<Usuario, String> tbNivelAcesso;
	@FXML
	private TableColumn<Usuario, String> tbSenha;
	
	ObservableList<String> genero = FXCollections.observableArrayList();
	ObservableList<String> NivelAcesso = FXCollections.observableArrayList();
	ObservableList<Usuario> ListaTabela = FXCollections.observableArrayList();
	String listaGenero[] = {"M","F"};
	String listaAcesso[]= {"Administrador","Trabalhador","Estagiário"};
	
	
	public void NovoRegistro() 
	{
		tfdCodigo.setDisable(false);
		tfdNome.setDisable(false);
		tfdGenero.setDisable(false);
		tfdTelefone.setDisable(false);
		tfdEmail.setDisable(false);
		tfdNivelAcesso.setDisable(false);
		dpDataNascimento.setDisable(false);
		tfdSenha.setDisable(false);
		btnCancelar.setDisable(false);
		btnSalvar.setDisable(false);
		btnEditar.setDisable(false);
		btnApagar.setDisable(false);
		btnNovo.setDisable(true);
	}
	
	public void CancelarRegistro() 
	{
		tfdCodigo.setDisable(true);
		tfdNome.setDisable(true);
		tfdGenero.setDisable(true);
		tfdTelefone.setDisable(true);
		tfdEmail.setDisable(true);
		tfdSenha.setDisable(true);
		tfdNivelAcesso.setDisable(true);
		dpDataNascimento.setDisable(true);
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}
	
	public void trocarFuncao() 
	{
		tfdCodigo.setText(null);
		tfdNome.setText(null);
		tfdGenero.setValue(null);
		tfdEmail.setText(null);
		tfdSenha.setText(null);
		dpDataNascimento.setValue(null);
		tfdNivelAcesso.setValue(null);
		
		tfdCodigo.setDisable(true);
		tfdNome.setDisable(true);
		tfdGenero.setDisable(true);
		tfdTelefone.setDisable(true);
		tfdEmail.setDisable(true);
		tfdSenha.setDisable(true);
		dpDataNascimento.setDisable(true);
		tfdNivelAcesso.setDisable(true);
	
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}

	public void GuardarRegistro() {
		
		String formato = pegarData();
		Usuario usuario = new Usuario(tfdNome.getText(),tfdGenero.getSelectionModel().getSelectedItem(),
				formato,tfdTelefone.getText(), tfdEmail.getText(),
				tfdNivelAcesso.getSelectionModel().getSelectedItem(),tfdSenha.getText());
		UsuarioDAO consulta = new UsuarioDAO();
		consulta.salvar(usuario);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public void EditarRegistro() {

		String formato = pegarData();
		Usuario usuario = new Usuario(Integer.parseInt(tfdCodigo.getText()), tfdNome.getText(),tfdGenero.getSelectionModel().getSelectedItem(),
				formato,tfdTelefone.getText(), tfdEmail.getText(),
				tfdNivelAcesso.getSelectionModel().getSelectedItem(),tfdSenha.getText());
		UsuarioDAO consulta = new UsuarioDAO();
		consulta.editar(usuario);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	
	
	public void ApagarRegistro() {

		Usuario usuario = new Usuario(Integer.parseInt(tfdCodigo.getText()));
		UsuarioDAO consulta = new UsuarioDAO();
		consulta.apagar(usuario);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public String pegarData() {
		LocalDate data = dpDataNascimento.getValue();
		String myDate = data.toString();

		return myDate;

	}

	public void PreencherTabela() {
		UsuarioDAO pt = new UsuarioDAO();
		ResultSet rs = pt.tabela();

		try {
			while (rs.next())

				ListaTabela.add(new Usuario(rs.getInt("codigo"),rs.getString("nome"), rs.getString("genero"),
						rs.getString("Data_Nasc"),rs.getString("telefone"), rs.getNString("email"),
						rs.getString("nivel_Acesso"),rs.getString("senha")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tbId.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("id"));
		tbNome.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nome"));
		tbGenero.setCellValueFactory(new PropertyValueFactory<Usuario,String>("genero"));
		tbNascimento.setCellValueFactory(new PropertyValueFactory<Usuario,String>("dataNascimento"));
		tbTelefone.setCellValueFactory(new PropertyValueFactory<Usuario,String>("telefone"));
		tbEmail.setCellValueFactory(new PropertyValueFactory<Usuario,String>("email"));
		tbNivelAcesso.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nivelAcesso"));
		tbSenha.setCellValueFactory(new PropertyValueFactory<Usuario,String>("senha"));
		Tabela.setItems(ListaTabela);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		genero.addAll(listaGenero);
		NivelAcesso.addAll(listaAcesso);
		tfdGenero.setItems(genero);
		tfdNivelAcesso.setItems(NivelAcesso);
		PreencherTabela();

	}
	
	
	public void fecharJanela(ActionEvent evento)
	{
		stage = new Stage();
		stage = (Stage)((Node)evento.getSource()).getScene().getWindow();
		stage.close();
	}
}
