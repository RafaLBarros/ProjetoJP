package controller;

import model.Casa;

public class ControleCasa {
	private int quantidade_casas = 49;
	private Casa[] tabuleiro = new Casa[quantidade_casas];
	
	public ControleCasa() {
		
	}
	public int getQuantidade_casas() {
		return quantidade_casas;
	}
	public void setQuantidade_casas(int quantidade_casas) {
		this.quantidade_casas = quantidade_casas;
	}
	public Casa[] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(int indice,int tipo) {
		this.tabuleiro[indice] = new Casa(indice,tipo);
	}
	
	
}
