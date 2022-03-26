package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Cliente;

public class ClienteController implements Initializable {
	Stage stage;
	@FXML
	private TextField tfdCodigo;
	@FXML
	private TextField tfdNome;
	@FXML
	private TextField tfdTelefone;
	@FXML
	private TextField tfdEmail;
	
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
	private DatePicker dpDataNascimento;
	@FXML
	private TextField tfdEndereco;
	@FXML
	private TableView<Cliente> Tabela;
	@FXML
	private TableColumn<Cliente, Integer>tbId;
	@FXML
	private TableColumn<Cliente, String> tbNome;
	@FXML
	private TableColumn<Cliente, String> tbGenero;
	@FXML
	private TableColumn<Cliente, String> tbNascimento;
	@FXML
	private TableColumn<Cliente, String> tbTelefone;
	@FXML
	private TableColumn<Cliente, String> tbEmail;
	@FXML
	private TableColumn<Cliente, String> tbEndereco;

	ObservableList<String> genero = FXCollections.observableArrayList();
	ObservableList<Cliente> ListaTabela = FXCollections.observableArrayList();
	String listaGenero[] = {"M","F"};
	
	public String pegarData() {
		LocalDate data = dpDataNascimento.getValue();
		String myDate = data.toString();

		return myDate;

	}
	
	
	public void NovoRegistro() 
	{
		tfdCodigo.setDisable(false);
		tfdNome.setDisable(false);
		tfdGenero.setDisable(false);
		tfdTelefone.setDisable(false);
		tfdEndereco.setDisable(false);
		tfdEmail.setDisable(false);
		dpDataNascimento.setDisable(false);
	
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
		tfdEndereco.setDisable(true);
		tfdEmail.setDisable(true);
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
		tfdEndereco.setText(null);
		tfdEmail.setText(null);
		tfdTelefone.setText(null);
		dpDataNascimento.setValue(null);
		
		tfdCodigo.setDisable(true);
		tfdNome.setDisable(true);
		tfdGenero.setDisable(true);
		tfdTelefone.setDisable(true);
		tfdEndereco.setDisable(true);
		tfdEmail.setDisable(true);
		dpDataNascimento.setDisable(true);
	
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}

	public void GuardarRegistro() {

		String formato = pegarData();
		Cliente cliente = new Cliente(tfdNome.getText(), tfdGenero.getSelectionModel().getSelectedItem(), formato,
				tfdTelefone.getText(), tfdEmail.getText(), tfdEndereco.getText());
		ClienteDAO consulta = new ClienteDAO();
		consulta.salvar(cliente);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public void EditarRegistro() {

		String formato = pegarData();
		Cliente cliente = new Cliente(Integer.parseInt(tfdCodigo.getText()), tfdNome.getText(), tfdGenero.getSelectionModel().getSelectedItem(), formato,
				tfdTelefone.getText(), tfdEmail.getText(), tfdEndereco.getText());
		ClienteDAO consulta = new ClienteDAO();
		consulta.editar(cliente);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public void ApagarRegistro() {
		Cliente cliente = new Cliente(Integer.parseInt(tfdCodigo.getText()));
		ClienteDAO consulta = new ClienteDAO();
		consulta.apagar(cliente);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}

	public void fecharJanela(ActionEvent evento) {
		stage = new Stage();
		stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
		stage.close();
	}



	public void PreencherTabela() {
		ClienteDAO pt = new ClienteDAO();
		ResultSet rs = pt.tabela();

		try {
			while (rs.next())

				ListaTabela.add(new Cliente(rs.getInt("codigo"),rs.getString("nome"), rs.getString("genero"), rs.getString("Data_Nasc"),
						rs.getString("telefone"), rs.getNString("email"), rs.getString("endereco")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tbId.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
		tbNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
		tbGenero.setCellValueFactory(new PropertyValueFactory<Cliente, String>("genero"));
		tbNascimento.setCellValueFactory(new PropertyValueFactory<Cliente, String>("dataNascimento"));
		tbTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
		tbEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
		tbEndereco.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Endereco"));
		Tabela.setItems(ListaTabela);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		genero.addAll(listaGenero);
		tfdGenero.setItems(genero);
		PreencherTabela();

	}
}
