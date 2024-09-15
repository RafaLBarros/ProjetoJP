package controller;

import java.util.ArrayList;

import model.Personagem;

public class ControlePersonagem {
	// Cria o primeiro valor de personagem, inicializado no equivalente a vazio.
	private int personagem = 0;
	// Cria o armazenamento de quantos personagens foram selecionados.
	private int characters_selected = 0;
	// Cria a Lista de Personagens
	ArrayList<Integer> lista_personagens = new ArrayList<Integer>();
	private Personagem[] personagensInstanciados;

	public int getCharacters_selected() {
		return characters_selected;
	}

	public void setCharacters_selected(int characters_selected) {
		this.characters_selected = characters_selected;
	}

	public int getPersonagem() {
		return personagem;
	}

	public void setPersonagem(int personagem) {
		this.personagem = personagem;
	}

	public ArrayList<Integer> getLista_personagens() {
		return lista_personagens;
	}

	public void setLista_personagens(ArrayList<Integer> lista_personagens) {
		this.lista_personagens = lista_personagens;
	}
	
	public void instanciarPersonagens() {
		personagensInstanciados = new Personagem[lista_personagens.size()];
		for(int i = 0;i < lista_personagens.size();i++) {
			personagensInstanciados[i] = new Personagem(lista_personagens.get(i));
		}
	}
	
	public int getPersonagemInstanciado(int i) {
		return personagensInstanciados[i].getPersonagem();
	}
	public Personagem getPlayerInstanciado(int i) {
		return personagensInstanciados[i];
	}
	
}
