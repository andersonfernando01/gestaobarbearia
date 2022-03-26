package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Cliente;

public class ClienteDAO
{
	
	Connection conexao;
	
	public void salvar(Cliente cliente) {
		
		conexao = new Banco().ligar();
		
		String sql ="INSERT INTO cliente(nome,genero,Data_Nasc,telefone,email,endereco)VALUES(?,?,?,?,?,?);";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,cliente.getNome());
			registrar.setString(2,cliente.getGenero());
			registrar.setString(3,cliente.getDataNascimento());
			registrar.setString(4,cliente.getTelefone());
			registrar.setString(5,cliente.getEmail());
			registrar.setString(6,cliente.getEndereco());
			registrar.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao salvar registro\n"+e);
			e.printStackTrace();
		}
		
	}
	
	
	
	public void editar(Cliente cliente) {
		
		conexao = new Banco().ligar();
		
		String sql ="UPDATE cliente SET nome= ?, genero= ?, Data_Nasc= ?, telefone= ?, email= ?, endereco= ?  WHERE codigo= ?;";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,cliente.getNome());
			registrar.setString(2,cliente.getGenero());
			registrar.setString(3,cliente.getDataNascimento());
			registrar.setString(4,cliente.getTelefone());
			registrar.setString(5,cliente.getEmail());
			registrar.setString(6,cliente.getEndereco());
			registrar.setInt(7, cliente.getId());
			registrar.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao Editar Cliente\n"+e);	
		}
	}
		
		public void apagar(Cliente cliente) {
			
			conexao = new Banco().ligar();
			
			String sql ="DELETE FROM cliente WHERE codigo= ?;";
			try {
				PreparedStatement registrar = conexao.prepareStatement(sql);
				registrar.setInt(1, cliente.getId());
				registrar.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "[ERRO]:Ao Apagar Cliente\n"+e);
				e.printStackTrace();
			}	
	}
	
public ResultSet tabela() {
		
		conexao = new Banco().ligar();
		
		String sql ="SELECT * FROM cliente;";
		try {
			PreparedStatement preencher = conexao.prepareStatement(sql);
			ResultSet rs = preencher.executeQuery();
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao preencher tabela\n"+e);
			e.printStackTrace();
			return null;
		}
		
	}
	
}
