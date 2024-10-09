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
	
	public void adicionarMaxdice(int i) {
		personagensInstanciados[i].setMaxdice(personagensInstanciados[i].getMaxdice()+1);
	}
	public void adicionarMindice(int i) {
		personagensInstanciados[i].setMindice(personagensInstanciados[i].getMindice()+1);
	}
	public void setConcludedStep(int i,int tipo) {
		personagensInstanciados[i].setConcludedStep(tipo);
	}
	public void adicionarTotalRolagem(int i) {
		personagensInstanciados[i].setTotalRolagem(personagensInstanciados[i].getTotalRolagem()+1);
	}
	public int[][] calcularPontos() {
		int[][] arrayScore = {{0,1},{0,2},{0,3},{0,4}};
		int indiceSalvo = -1;
		int comparador = -1;
		for(int i = 0; i < 4;i++) {
			if(personagensInstanciados[i].getMaxdice() > comparador) {
				comparador = personagensInstanciados[i].getMaxdice();
				indiceSalvo = i;
			}
		}
		arrayScore[indiceSalvo][0]+=1;
		comparador = -1;
		for(int i = 0; i < 4;i++) {
			if(personagensInstanciados[i].getMindice() > comparador) {
				comparador = personagensInstanciados[i].getMindice();
				indiceSalvo = i;
			}
		}
		arrayScore[indiceSalvo][0]-=1;
		comparador = -1;
		for(int i = 0; i < 4;i++) {
			if(personagensInstanciados[i].getTotalRolagem() > comparador) {
				comparador = personagensInstanciados[i].getTotalRolagem();
				indiceSalvo = i;
			}
		}
		arrayScore[indiceSalvo][0]+=0; //Depois de implementar um bom sistema pra variar a quantidade de rolagens, implementar a pontuação.
		comparador = -1;
		for(int i = 0; i < 4;i++) {
			arrayScore[i][0] += personagensInstanciados[i].getConcludedStep();
		}
		return arrayScore;
	}
}
