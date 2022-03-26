package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Agenda;


public class AgendaDAO 
{
Connection conexao;
	
	public void salvar(Agenda ag) {
		
		conexao = new Banco().ligar();
		
		String sql ="INSERT INTO agenda(cliente,servico,valor,Data_Agenda,hora,obs)VALUES(?,?,?,?,?,?);";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,ag.getCliente());
			registrar.setString(2,ag.getNome());
			registrar.setDouble(3,ag.getValor());
			registrar.setString(4,ag.getData());
			registrar.setString(5,ag.getHora());
			registrar.setString(6,ag.getOBS());
			registrar.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao salvar registro\n"+e);
			e.printStackTrace();
		}
		
	}
public void editar(Agenda ag) {
		
		conexao = new Banco().ligar();
		
		String sql ="UPDATE agenda SET cliente= ?, servico= ?, valor= ?, Data_Agenda= ?, hora= ?, obs= ?  WHERE id= ?;";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,ag.getCliente());
			registrar.setString(2,ag.getNome());
			registrar.setDouble(3,ag.getValor());
			registrar.setString(4,ag.getData());
			registrar.setString(5,ag.getHora());
			registrar.setString(6,ag.getOBS());
			registrar.setInt(7, ag.getId());
			registrar.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao Editar Agenda\n"+e);	
		}
	}
		
		public void apagar(Agenda ag) {
			
			conexao = new Banco().ligar();
			
			String sql ="DELETE FROM agenda WHERE id= ?;";
			try {
				PreparedStatement registrar = conexao.prepareStatement(sql);
				registrar.setInt(1, ag.getId());
				registrar.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "[ERRO]:Ao Apagar Agenda\n"+e);
				e.printStackTrace();
			}	
	}
	
public ResultSet tabela() {
		
		conexao = new Banco().ligar();
		
		String sql ="SELECT * FROM agenda;";
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

public ResultSet clientes()
{
	conexao = new Banco().ligar();
	
	String sql ="SELECT * FROM cliente;";
	try {
		PreparedStatement preencher = conexao.prepareStatement(sql);
		ResultSet rs = preencher.executeQuery();
		return rs;
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "[ERRO]:Ao preencher clientes\n"+e);
		e.printStackTrace();
		return null;
	}
}

public ResultSet servicos()
{
	conexao = new Banco().ligar();
	
	String sql ="SELECT * FROM servicos;";
	try {
		PreparedStatement preencher = conexao.prepareStatement(sql);
		ResultSet rs = preencher.executeQuery();
		return rs;
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "[ERRO]:Ao preencher servicos\n"+e);
		e.printStackTrace();
		return null;
	}
}
	
}
