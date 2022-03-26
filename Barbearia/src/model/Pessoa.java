package model;

public abstract class Pessoa {
	
	
	private int id;
	private String nome;
	private String genero;
	private String DataNascimento;
	private String telefone;
	private String email;
	
	public Pessoa(int id, String nome, String genero, String dataNascimento, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		DataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
	}
	public Pessoa(String nome, String genero, String dataNascimento, String telefone, String email) {
		
		this.nome = nome;
		this.genero = genero;
		DataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
	}
	public Pessoa(String nome) {
		
		this.nome = nome;
		
	}
public Pessoa(int id) {
		
		this.id= id;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
