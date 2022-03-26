package model;

public class Servicos {
	
	private int id;
	private String servico;
	private Double preco;
	
	
	public Servicos(String servico, Double preco) {
		this.servico = servico;
		this.preco = preco;
	}
	
	public Servicos(String servico)
	{
		this.servico = servico;
	}
	public Servicos(int id)
	{
		this.id = id;
	}
	public Servicos()
	{
	
	}
	
	public Servicos(Double valor)
	{
		this.preco = valor;
	}
	public Servicos(int id, String servico, Double preco) {
		this.id = id;
		this.servico = servico;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String toString()
	{
		return servico;
		
	}
	
}
