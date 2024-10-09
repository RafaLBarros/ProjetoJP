package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ControlePersonagem;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Component;

public class Scoreboard extends JFrame{
	private ControlePersonagem controlePersonagem;
	private int[][] scorePlayer;
	private Background background;
	
	public Scoreboard(ControlePersonagem controlePersonagem) {
		background = new Background("/images/1bg.png");
		this.controlePersonagem = controlePersonagem;
		// Não permite mexer o tamanho da pagina
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tamanho da página
		setBounds(100, 100, 1296, 759);
		
		// Função para centralizar o programa na tela!
		setLocationRelativeTo(null);
		setContentPane(background);
		background.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placar");
		lblNewLabel.setBounds(0, 0, 1280, 45);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		background.add(lblNewLabel);
		
		JLabel lbl_valores = new JLabel();
		lbl_valores.setBounds(58, 162, 310, 420);
		lbl_valores.setFont(new Font("Verdana", Font.BOLD, 17));
		lbl_valores.setHorizontalAlignment(SwingConstants.CENTER);
		String string = String.format("<html><br>Jogador 1 concluiu %d etapas!<br>Jogador 1 rolou %d seis no dado!<br>Jogador 1 rolou %d um no dado!<br>Jogador 1 rolou %d vezes o dado!<br>",controlePersonagem.getPlayerInstanciado(0).getConcludedStep(),controlePersonagem.getPlayerInstanciado(0).getMaxdice(),controlePersonagem.getPlayerInstanciado(0).getMindice(),controlePersonagem.getPlayerInstanciado(0).getTotalRolagem());
		String string2 = String.format("<html>Jogador 2 concluiu %d etapas!<br>Jogador 2 rolou %d seis no dado!<br>Jogador 2 rolou %d um no dado!<br>Jogador 2 rolou %d vezes o dado!<br>",controlePersonagem.getPlayerInstanciado(1).getConcludedStep(),controlePersonagem.getPlayerInstanciado(1).getMaxdice(),controlePersonagem.getPlayerInstanciado(1).getMindice(),controlePersonagem.getPlayerInstanciado(1).getTotalRolagem());
		String string3 = String.format("<html>Jogador 3 concluiu %d etapas!<br>Jogador 3 rolou %d seis no dado!<br>Jogador 3 rolou %d um no dado!<br>Jogador 3 rolou %d vezes o dado!<br>",controlePersonagem.getPlayerInstanciado(2).getConcludedStep(),controlePersonagem.getPlayerInstanciado(2).getMaxdice(),controlePersonagem.getPlayerInstanciado(2).getMindice(),controlePersonagem.getPlayerInstanciado(2).getTotalRolagem());
		String string4 = String.format("<html>Jogador 4 concluiu %d etapas!<br>Jogador 4 rolou %d seis no dado!<br>Jogador 4 rolou %d um no dado!<br>Jogador 4 rolou %d vezes o dado!<br>",controlePersonagem.getPlayerInstanciado(3).getConcludedStep(),controlePersonagem.getPlayerInstanciado(3).getMaxdice(),controlePersonagem.getPlayerInstanciado(3).getMindice(),controlePersonagem.getPlayerInstanciado(3).getTotalRolagem());
		lbl_valores.setText(string + "<html><br>" + string2 + "<html><br>" + string3 + "<html><br>" + string4 + "<html><br>");
		background.add(lbl_valores);
		
		scorePlayer = controlePersonagem.calcularPontos();
		Arrays.sort(scorePlayer, (a, b) -> Integer.compare(a[0], b[0]));
		
		JLabel lbl_vitoria = new JLabel("");
		lbl_vitoria.setText(String.format("Parabéns Jogador %d! Você ganhou!",scorePlayer[3][1]));
		lbl_vitoria.setFont(new Font("Verdana", Font.BOLD, 17));
		lbl_vitoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_vitoria.setBounds(460, 56, 360, 77);
		background.add(lbl_vitoria);
		
		JLabel lbl_primeiro = new JLabel("");
		lbl_primeiro.setText(String.format("1º: Jogador %d: %d pontos!",scorePlayer[3][1],scorePlayer[3][0]));
		lbl_primeiro.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_primeiro.setFont(new Font("Verdana", Font.BOLD, 17));
		lbl_primeiro.setBounds(510, 150, 260, 35);
		background.add(lbl_primeiro);
		
		JLabel lbl_segundo = new JLabel("");
		lbl_segundo.setText(String.format("2º: Jogador %d: %d pontos!",scorePlayer[2][1],scorePlayer[2][0]));
		lbl_segundo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_segundo.setFont(new Font("Verdana", Font.BOLD, 17));
		lbl_segundo.setBounds(510, 200, 260, 35);
		background.add(lbl_segundo);
		
		JLabel lbl_terceiro = new JLabel("");
		lbl_terceiro.setText(String.format("3º: Jogador %d: %d pontos!",scorePlayer[1][1],scorePlayer[1][0]));
		lbl_terceiro.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_terceiro.setFont(new Font("Verdana", Font.BOLD, 17));
		lbl_terceiro.setBounds(510, 250, 260, 35);
		background.add(lbl_terceiro);
		
		JLabel lbl_quarto = new JLabel("4º: Jogador 4: 0 pontos!");
		lbl_quarto.setText(String.format("4º: Jogador %d: %d pontos!",scorePlayer[0][1],scorePlayer[0][0]));
		lbl_quarto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_quarto.setFont(new Font("Verdana", Font.BOLD, 17));
		lbl_quarto.setBounds(510, 300, 260, 35);
		background.add(lbl_quarto);
		
		JLabel img_primeiro = new JLabel("");
		int pers = controlePersonagem.getPersonagemInstanciado(scorePlayer[3][1]-1);
		img_primeiro.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/charactermini"+(pers)+".png")));
		img_primeiro.setBounds(470, 150, 40, 40);
		background.add(img_primeiro);
		
		JLabel img_segundo = new JLabel("");
		pers = controlePersonagem.getPersonagemInstanciado(scorePlayer[2][1]-1);
		img_segundo.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/charactermini"+(pers)+".png")));
		img_segundo.setBounds(470, 200, 40, 40);
		background.add(img_segundo);
		
		JLabel img_terceiro = new JLabel("");
		pers = controlePersonagem.getPersonagemInstanciado(scorePlayer[1][1]-1);
		img_terceiro.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/charactermini"+(pers)+".png")));
		img_terceiro.setBounds(470, 250, 40, 40);
		background.add(img_terceiro);
		
		JLabel img_quarto = new JLabel("");
		pers = controlePersonagem.getPersonagemInstanciado(scorePlayer[0][1]-1);
		img_quarto.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/charactermini"+(pers)+".png")));
		img_quarto.setBounds(470, 300, 40, 40);
		background.add(img_quarto);
		
		JLabel lbl_estatisticas = new JLabel("Estatísticas");
		lbl_estatisticas.setFont(new Font("Verdana", Font.BOLD, 20));
		lbl_estatisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estatisticas.setBounds(143, 114, 140, 35);
		background.add(lbl_estatisticas);
		setVisible(true);
	}
}
