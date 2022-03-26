package model;
public class Cliente extends Pessoa {
	
	
	private String Endereco;
	
	
	public Cliente(int id, String nome, String genero, String dataNascimento, String telefone, String email, String endereco) {
		super(id, nome, genero, dataNascimento, telefone, email);
		this.Endereco = endereco;
	}
	
	public Cliente(String nome, String genero, String dataNascimento, String telefone,
			String email,String Endereco) {
		super(nome, genero, dataNascimento, telefone, email);
		
		this.Endereco = Endereco;	
	}
	public Cliente(String nome)
	{
		super(nome);
	}
	public Cliente(int id)
	{
		super(id);
	}
	

	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	public String toString()
	{
		return getNome();
		
	}
	}



