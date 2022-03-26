package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import dao.AgendaDAO;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Agenda;
import model.Cliente;
import model.Servicos;

public class AgendaController implements Initializable {

	Stage stage;
	FXMLLoader loader;
	Parent root;
	Scene scene;

	@FXML
	private TextField tfdCodigo;
	@FXML
	private TextField tfValor;
	@FXML
	private TextField tfHora;
	@FXML
	private TextArea tfOBS;
	
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
	private ComboBox<Cliente> clientes;
	@FXML
	private ComboBox<Servicos> servicos;
	@FXML
	private DatePicker dpData;
	@FXML
	private TableView<Agenda> Tabela;
	@FXML
	private TableColumn<Agenda, Integer> tbId;
	@FXML
	private TableColumn<Agenda, String> tbCliente;
	@FXML
	private TableColumn<Agenda, String> tbServico;
	@FXML
	private TableColumn<Agenda, Double> tbValor;
	@FXML
	private TableColumn<Agenda, String> tbData;
	@FXML
	private TableColumn<Agenda, String> tbEHora;
	@FXML
	private TableColumn<Agenda, String> tbOBS;

	ObservableList<Cliente> cliente = FXCollections.observableArrayList();
	ObservableList<Servicos> servico = FXCollections.observableArrayList();
	ObservableList<Agenda> ListaTabela = FXCollections.observableArrayList();
	
	public String pegarData() {
		LocalDate data = dpData.getValue();
		String myDate = data.toString();

		return myDate;

	}
	
	public void NovoRegistro() 
	{
		tfdCodigo.setDisable(false);
		clientes.setDisable(false);
		servicos.setDisable(false);
		tfValor.setDisable(false);
		tfOBS.setDisable(false);
		tfHora.setDisable(false);
		dpData.setDisable(false);
	
		btnCancelar.setDisable(false);
		btnSalvar.setDisable(false);
		btnEditar.setDisable(false);
		btnApagar.setDisable(false);
		btnNovo.setDisable(true);
	}
	
	public void CancelarRegistro() 
	{
		tfdCodigo.setDisable(true);
		clientes.setDisable(true);
		servicos.setDisable(true);
		tfValor.setDisable(true);
		tfOBS.setDisable(true);
		tfHora.setDisable(true);
		dpData.setDisable(true);
		
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}
	
	public void trocarFuncao() 
	{
		tfdCodigo.setText(null);
		clientes.setValue(null);
		servicos.setValue(null);
		tfValor.setText(null);
		tfOBS.setText(null);
		tfHora.setText(null);
		dpData.setValue(null);
		
		tfdCodigo.setDisable(true);
		clientes.setDisable(true);
		servicos.setDisable(true);
		tfValor.setDisable(true);
		tfOBS.setDisable(true);
		tfHora.setDisable(true);
		dpData.setDisable(true);
	
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}

	public void GuardarRegistro() {

		String formato = pegarData();
		AgendaDAO consulta = new AgendaDAO();
		Agenda agenda = new Agenda(clientes.getSelectionModel().getSelectedItem().getNome(),
				servicos.getSelectionModel().getSelectedItem().getServico(), Double.parseDouble(tfValor.getText()),
				formato,tfHora.getText(), tfOBS.getText());
		consulta.salvar(agenda);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public void EditarRegistro() {

		String formato = pegarData();
		AgendaDAO consulta = new AgendaDAO();
		Agenda agenda = new Agenda(Integer.parseInt(tfdCodigo.getText()), clientes.getSelectionModel().getSelectedItem().getNome(),
				servicos.getSelectionModel().getSelectedItem().getServico(), Double.parseDouble(tfValor.getText()), formato,
				tfHora.getText(), tfOBS.getText());
		consulta.editar(agenda);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public void ApagarRegistro() {
		Agenda agenda = new Agenda(Integer.parseInt(tfdCodigo.getText()));
		AgendaDAO consulta = new AgendaDAO();
		consulta.apagar(agenda);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}



	public void PreencherTabela() {
		AgendaDAO pt = new AgendaDAO();
		ResultSet rs = pt.tabela();

		try {
			while (rs.next()) {
				ListaTabela.add(new Agenda(rs.getInt("id"),rs.getString("cliente"),
						rs.getString("servico"), rs.getDouble("valor"), rs.getString("Data_Agenda"),
						rs.getString("hora"), rs.getString("obs")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		tbId.setCellValueFactory(new PropertyValueFactory<Agenda, Integer>("id"));
		tbCliente.setCellValueFactory(new PropertyValueFactory<Agenda, String>("cliente"));
		tbServico.setCellValueFactory(new PropertyValueFactory<Agenda, String>("nome"));
		tbValor.setCellValueFactory(new PropertyValueFactory<Agenda, Double>("valor"));
		tbData.setCellValueFactory(new PropertyValueFactory<Agenda, String>("data"));
		tbEHora.setCellValueFactory(new PropertyValueFactory<Agenda, String>("hora"));
		tbOBS.setCellValueFactory(new PropertyValueFactory<Agenda, String>("OBS"));
		Tabela.setItems(ListaTabela);
	}

	public void ComboClientes() {
		AgendaDAO pt = new AgendaDAO();
		ResultSet rs = pt.clientes();

		try {
			while (rs.next()) {
				cliente.add(new Cliente(rs.getString("nome")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		clientes.setItems(cliente);
	}

	public void ComboServicos() {
		AgendaDAO pt = new AgendaDAO();
		ResultSet rs = pt.servicos();
		try {
			while (rs.next()) {
				servico.add(new Servicos(rs.getString("nome")));
				
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		servicos.setItems(servico);
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ComboClientes();
		ComboServicos();
		PreencherTabela();
		
	}

	public void fecharJanela(ActionEvent evento) {
		stage = new Stage();
		stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
		stage.close();
	}
}
