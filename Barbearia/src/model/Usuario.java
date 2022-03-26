package model;



public class Usuario extends Pessoa{
	
	private String senha;
	private String nivelAcesso;

	public Usuario(int id, String nome, String genero, String dataNascimento, 
			String telefone, String email, String nivelAceso, String senha) {
		super(id, nome, genero, dataNascimento, telefone, email);
		this.nivelAcesso = nivelAceso;
		this.senha= senha;
	
	}
	
	public Usuario(String nome, String genero, String dataNascimento, 
			String telefone, String email, String nivelAceso, String senha) {
		super(nome, genero, dataNascimento, telefone, email);
		
		this.nivelAcesso = nivelAceso;
		this.senha = senha;
	}
	
	
	
	public Usuario(String nome, String senha)
	{
		super(nome);
		this.senha =senha;
		
	}
	
	public Usuario(int id)
	{
		super(id);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	public String toString()
	{
		return getNome();
		
	}
	

}
