package model;

public class Personagem {
	private int casaAtual;
	private int personagem;
	private int pontos;
	private int totalRolagem;
	
	public Personagem(int personagem) {
		this.personagem = personagem;
	}

	public int getCasaAtual() {
		return casaAtual;
	}

	public void setCasaAtual(int casaAtual) {
		this.casaAtual = casaAtual;
	}

	public int getPersonagem() {
		return personagem;
	}

	public void setPersonagem(int personagem) {
		this.personagem = personagem;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getTotalRolagem() {
		return totalRolagem;
	}

	public void setTotalRolagem(int totalRolagem) {
		this.totalRolagem = totalRolagem;
	}
	
}
