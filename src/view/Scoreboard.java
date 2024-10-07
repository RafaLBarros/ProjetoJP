package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ControlePersonagem;
import java.awt.Color;
import javax.swing.JTextPane;

public class Scoreboard {
	JFrame frame = new JFrame();
	ControlePersonagem controlePersonagem;
	
	public Scoreboard(ControlePersonagem controlePersonagem) {
		this.controlePersonagem = controlePersonagem;
		// Não permite mexer o tamanho da pagina
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tamanho da página
		frame.setBounds(100, 100, 1296, 759);
		
		// Função para centralizar o programa na tela!
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Placar");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea txtrn = new JTextArea();
		txtrn.setEditable(false);
		txtrn.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtrn.setBackground(new Color(240, 240, 240));
		String string = String.format("Player 1 concluiu %d etapas!\nPlayer 1 rolou %d seis no dado!\nPlayer 1 rolou %d um no dado!\nPlayer 1 rolou %d vezes o dado!\n",controlePersonagem.getPlayerInstanciado(0).getConcludedStep(),controlePersonagem.getPlayerInstanciado(0).getMaxdice(),controlePersonagem.getPlayerInstanciado(0).getMindice(),controlePersonagem.getPlayerInstanciado(0).getTotalRolagem());
		String string2 = String.format("Player 2 concluiu %d etapas!\nPlayer 2 rolou %d seis no dado!\nPlayer 2 rolou %d um no dado!\nPlayer 2 rolou %d vezes o dado!\n",controlePersonagem.getPlayerInstanciado(1).getConcludedStep(),controlePersonagem.getPlayerInstanciado(1).getMaxdice(),controlePersonagem.getPlayerInstanciado(1).getMindice(),controlePersonagem.getPlayerInstanciado(1).getTotalRolagem());
		String string3 = String.format("Player 3 concluiu %d etapas!\nPlayer 3 rolou %d seis no dado!\nPlayer 3 rolou %d um no dado!\nPlayer 3 rolou %d vezes o dado!\n",controlePersonagem.getPlayerInstanciado(2).getConcludedStep(),controlePersonagem.getPlayerInstanciado(2).getMaxdice(),controlePersonagem.getPlayerInstanciado(2).getMindice(),controlePersonagem.getPlayerInstanciado(2).getTotalRolagem());
		String string4 = String.format("Player 4 concluiu %d etapas!\nPlayer 4 rolou %d seis no dado!\nPlayer 4 rolou %d um no dado!\nPlayer 4 rolou %d vezes o dado!\n",controlePersonagem.getPlayerInstanciado(3).getConcludedStep(),controlePersonagem.getPlayerInstanciado(3).getMaxdice(),controlePersonagem.getPlayerInstanciado(3).getMindice(),controlePersonagem.getPlayerInstanciado(3).getTotalRolagem());
		txtrn.setText(string + "\n" + string2 + "\n" + string3 + "\n" + string4 + "\n");
		frame.getContentPane().add(txtrn, BorderLayout.WEST);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(240, 240, 240));
		textPane.setEditable(false);
		frame.getContentPane().add(textPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
