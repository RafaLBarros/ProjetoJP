package controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import dao.Consulta;
import dao.Insercao;
import model.Pontuacao;

public class ControlePontuacao {
	private Consulta consulta;
	private Pontuacao pontuacao;
	private Insercao insercao;
	
	public void consultarPontos(){
		consulta = new Consulta();
	}
	public String getValores() {
		consulta.Proximo();
		return consulta.getNome() + " : " + consulta.getPontos() + " : " + consulta.getData();
	}
	public void salvarPontuacao(String nome,int pontos) {
		ZoneId zoneid1 = ZoneId.of("America/Sao_Paulo");
		ZonedDateTime data = ZonedDateTime.now(zoneid1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String datastr = data.format(formatter);
		insercao = new Insercao(nome,pontos,datastr);
		consulta = new Consulta();
		
	}
}
