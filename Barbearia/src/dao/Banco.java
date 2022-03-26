package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Banco 
{
	
	public Connection connection;
	private final  String DATABASE_URL ="jdbc:mysql://localhost:3306/barbearia";
	private final String USERNAME = "root";
	private final String PASSWORD ="";
	
  public  Connection ligar()
  {
	  try {
		connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog
		(null, "[erro]:Ao conectar banco\n"+e.getMessage());
	}
	  return connection;
  }
  
  public Connection desligar()
  {
	  try {
		connection.close();
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog
		(null, "[erro]: Ao desconectar banco\n"+e.getMessage());
	
	}
	  return connection;
  }

}
