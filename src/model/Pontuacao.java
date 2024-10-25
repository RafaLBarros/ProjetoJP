package model;

public class Pontuacao {
	private String nome;
	private int pontos;
	private String data;
	
	public Pontuacao(String nome,int pontos, String data) {
		this.nome = nome;
		this.pontos = pontos;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
