package model;

public class Agenda {
	
	
	
	private int id;
	private String cliente;
	private String servico;
	private Double valor;
	private String data;
	private String hora;
	private String OBS;
	public Agenda(int id, String cliente, String nome, Double valor, String data, String hora, String oBS) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = nome;
		this.valor = valor;
		this.data = data;
		this.hora = hora;
		this.OBS = oBS;
	}
	public Agenda(String cliente, String nome, Double valor, String data, String hora, String oBS) {
		this.cliente = cliente;
		this.servico = nome;
		this.valor = valor;
		this.data = data;
		this.hora = hora;
		this.OBS = oBS;
	}
	
	public Agenda(int id)
	{
		this.id = id;
	}
	
	public Agenda(String cliente) 
	{
		this.cliente = cliente;
	}
	
	public Agenda(Double valor) 
	{
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNome() {
		return servico;
	}
	public void setNome(String nome) {
		this.servico = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getOBS() {
		return OBS;
	}
	public void setOBS(String oBS) {
		OBS = oBS;
	}
	
	
	
	
	
}