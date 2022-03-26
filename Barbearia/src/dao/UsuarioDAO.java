package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDAO {

	Connection conexao;

	public ResultSet getNomeESenha(Usuario u) {

		conexao = new Banco().ligar();

		try {
			PreparedStatement consulta = conexao
					.prepareStatement("SELECT nome,senha FROM usuario WHERE nome =? AND senha =?;");
			consulta.setString(1, u.getNome());
			consulta.setString(2, u.getSenha());
			ResultSet resultado = consulta.executeQuery();
			return resultado;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "[erro]:UsuarioDAO\n erro de consulta\n" + e);
			return null;
		}

	}
	
public void salvar(Usuario usuario) {
		
		conexao = new Banco().ligar();
		
		String sql ="INSERT INTO usuario(nome,genero,Data_Nasc,telefone,email,nivel_Acesso,senha)VALUES(?,?,?,?,?,?,?);";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setString(1,usuario.getNome());
			registrar.setString(2,usuario.getGenero());
			registrar.setString(3,usuario.getDataNascimento());
			registrar.setString(4,usuario.getTelefone());
			registrar.setString(5,usuario.getEmail());
			registrar.setString(6,usuario.getNivelAcesso());
			registrar.setString(7,usuario.getSenha());
			registrar.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro Salvo com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao salvar registro\n"+e);
			e.printStackTrace();
		}
		
	}
public void editar(Usuario usuario) {
	
	conexao = new Banco().ligar();
	
	String sql ="UPDATE usuario SET nome= ?, genero= ?, Data_Nasc= ?, telefone= ?, email= ?, nivel_Acesso= ?, senha= ?  WHERE codigo= ?;";
	try {
		PreparedStatement registrar = conexao.prepareStatement(sql);
		registrar.setString(1,usuario.getNome());
		registrar.setString(2,usuario.getGenero());
		registrar.setString(3,usuario.getDataNascimento());
		registrar.setString(4,usuario.getTelefone());
		registrar.setString(5,usuario.getEmail());
		registrar.setString(6, usuario.getNivelAcesso());
		registrar.setString(7,usuario.getSenha());
		registrar.setInt(8, usuario.getId());
		registrar.executeUpdate();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "[ERRO]:Ao Editar Usuário\n"+e);	
	}
}
	
	public void apagar(Usuario usuario) {
		
		conexao = new Banco().ligar();
		
		String sql ="DELETE FROM usuario WHERE codigo= ?;";
		try {
			PreparedStatement registrar = conexao.prepareStatement(sql);
			registrar.setInt(1, usuario.getId());
			registrar.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "[ERRO]:Ao Apagar Usuário\n"+e);
			e.printStackTrace();
		}	
}

	
public ResultSet tabela() {
		
		conexao = new Banco().ligar();
		
		String sql ="SELECT * FROM Usuario;";
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
