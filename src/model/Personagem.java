package model;

public class Personagem {
	private int casaAtual = -1;
	private int personagem;
	private int pontos;
	private int totalRolagem;
	private int lastRoll;
	
	public int getLastRoll() {
		return lastRoll;
	}

	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}

	public Personagem(int personagem) {
		this.personagem = personagem;
	}

	public int getCasaAtual() {
		return casaAtual;
	}

	public void setCasaAtual(int casaAtual) {
		this.casaAtual = casaAtual;
	}
	public void walkCasaAtual(int soma) {
		this.casaAtual += soma;
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
