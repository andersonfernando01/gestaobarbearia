package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.ServicosDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Servicos;

public class ServicosController implements Initializable {

	Stage stage;
	
	@FXML
	private TextField tfNome;
	@FXML
	private TextField tfCodigo;
	@FXML
	private TextField tfPreco;
	
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
	private TableView<Servicos> Tabela;
	@FXML
	private TableColumn<Servicos, Integer>tbId;
	@FXML
	private TableColumn<Servicos, String> tbNome;
	@FXML
	private TableColumn<Servicos, Double> tbpreco;
	
	ObservableList<Servicos> ListaTabela = FXCollections.observableArrayList();
	
	public void NovoRegistro() 
	{
		tfCodigo.setDisable(false);
		tfNome.setDisable(false);
		tfPreco.setDisable(false);
	
		btnCancelar.setDisable(false);
		btnSalvar.setDisable(false);
		btnEditar.setDisable(false);
		btnApagar.setDisable(false);
		btnNovo.setDisable(true);
	}
	
	public void CancelarRegistro() 
	{
		tfCodigo.setDisable(true);
		tfNome.setDisable(true);
		tfPreco.setDisable(true);
		
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}
	
	public void trocarFuncao() 
	{
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfPreco.setText(null);
		
		tfCodigo.setDisable(true);
		tfNome.setDisable(true);
		tfPreco.setDisable(true);
	
		btnCancelar.setDisable(true);
		btnSalvar.setDisable(true);
		btnEditar.setDisable(true);
		btnApagar.setDisable(true);
		btnNovo.setDisable(false);
	}

	
	public void GuardarRegistro() {

		
		Servicos servico = new Servicos(tfNome.getText(), Double.parseDouble(tfPreco.getText()));
		ServicosDAO consulta = new ServicosDAO();
		consulta.salvar(servico);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
		
	public void EditarRegistro() {

		Servicos servico = new Servicos(tfNome.getText(),Double.parseDouble( tfPreco.getText()));
		ServicosDAO consulta = new ServicosDAO();
		consulta.editar(servico);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	
	public void ApagarRegistro() {
		Servicos servico = new Servicos(Integer.parseInt(tfCodigo.getText()));
		ServicosDAO consulta = new ServicosDAO();
		consulta.apagar(servico);
		ListaTabela.clear();
		PreencherTabela();
		trocarFuncao();

	}
	public void fecharJanela(ActionEvent evento)
	{
		stage = new Stage();
		stage = (Stage)((Node)evento.getSource()).getScene().getWindow();
		stage.close();
	}
	
	public void PreencherTabela() {
		ServicosDAO consulta = new ServicosDAO();
		ResultSet rs = consulta.tabela();

		try {
			while (rs.next())

				ListaTabela.add(new Servicos(rs.getInt("id"),rs.getString("nome"), rs.getDouble("preco")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tbId.setCellValueFactory(new PropertyValueFactory<Servicos, Integer>("id"));
		tbNome.setCellValueFactory(new PropertyValueFactory<Servicos, String>("servico"));
		tbpreco.setCellValueFactory(new PropertyValueFactory<Servicos, Double>("preco"));
		
		Tabela.setItems(ListaTabela);
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		PreencherTabela();
	}

}
