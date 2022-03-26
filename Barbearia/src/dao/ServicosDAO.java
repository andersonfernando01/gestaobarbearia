package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Servicos;

public class ServicosDAO {

Connection conexao;
	
	public void salvar(Servicos servico) {
		
		conexao = new Banco().ligar();
		
		String sql ="INSERT INTO servicos(nome,preco)VALUES(?,?);";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,servico.getServico());
			registrar.setDouble(2,servico.getPreco());
			registrar.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao salvar Servicos\n"+e);
		
		}
		
	}
public void editar(Servicos servico) {
		
		conexao = new Banco().ligar();
		
		String sql ="UPDATE servicos SET nome= ?, preco= ? WHERE id= ?;";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,servico.getServico());
			registrar.setDouble(2,servico.getPreco());
			registrar.setDouble(2,servico.getId());
			registrar.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao Editar Servicos\n"+e);	
		}
	}
		
		public void apagar(Servicos servico) {
			
			conexao = new Banco().ligar();
			
			String sql ="DELETE FROM servicos WHERE id= ?;";
			try {
				PreparedStatement registrar = conexao.prepareStatement(sql);
				registrar.setInt(1, servico.getId());
				registrar.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "[ERRO]:Ao Apagar Servicos\n"+e);
				e.printStackTrace();
			}	
	}
	
	
public ResultSet tabela() {
		
		conexao = new Banco().ligar();
		
		String sql ="SELECT * FROM servicos;";
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
