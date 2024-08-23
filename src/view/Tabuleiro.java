package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tabuleiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//Cria o primeiro valor de personagem, inicializado no equivalente a vazio.
	private int personagem = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuleiro frame = new Tabuleiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tabuleiro() {
		//Não permite mexer o tamanho da pagina
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Tamanho pre-setado para o placeholder ficar em um tamanho bom, mexer depois com o mapa novo!
		setBounds(100, 100, 1400,773);
		contentPane = new JPanel();
		//Coloquei a cor do background branca para mesclar com o mapa!
		contentPane.setBackground(new Color(255, 255, 255));
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//A seguir os labels de escolher personagem!
		JLabel lblNewLabel_1 = new JLabel("Escolha o Jogador 1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1241, 33, 133, 57);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Escolha o Jogador 2");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(1241, 152, 133, 57);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Escolha o Jogador 3");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(1241, 283, 133, 57);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Escolha o Jogador 4");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(1241, 413, 133, 57);
		contentPane.add(lblNewLabel_4);
		
		//A seguir os botões para selecionar os personagens!
		JButton btnNewButton_sieg = new JButton("");
		btnNewButton_sieg.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.png")));
		btnNewButton_sieg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 1;
			}
		});
		btnNewButton_sieg.setBounds(1255, 561, 40, 40);
		contentPane.add(btnNewButton_sieg);
		
		JButton btnNewButton_zero = new JButton("");
		btnNewButton_zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 2;
			}
		});
		btnNewButton_zero.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
		btnNewButton_zero.setBounds(1305, 561, 40, 40);
		contentPane.add(btnNewButton_zero);
		
		JButton btnNewButton_uno = new JButton("");
		btnNewButton_uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 3;
			}
		});
		btnNewButton_uno.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
		btnNewButton_uno.setBounds(1255, 612, 40, 40);
		contentPane.add(btnNewButton_uno);
		
		JButton btnNewButton_ai = new JButton("");
		btnNewButton_ai.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg")));
		btnNewButton_ai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 4;
			}
		});
		btnNewButton_ai.setBounds(1305, 612, 40, 40);
		contentPane.add(btnNewButton_ai);
		
		//Botão para selecionar personagem vazio, caso tenha selecionado errado!
		JButton btnNewButton_vazio = new JButton("");
		btnNewButton_vazio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 0;
			}
		});
		btnNewButton_vazio.setBounds(1280, 657, 40, 40);
		contentPane.add(btnNewButton_vazio);
		
		/*A seguir botões para pressionar após selecionar qual personagem quer!
		 * Quero mudar a forma que isso funciona, mas não tenho ideias ainda, aceito sugestões
		 * Quero também que quando uma pessoa selecione um personagem, a outra não possa selecionar o mesmo!
		 * ~Rafael
		*/
		JButton btnNewButton_player1 = new JButton("");
		btnNewButton_player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personagem == 1)
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
				else if(personagem == 2)
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
				else if(personagem == 3)
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
				else if(personagem == 4)
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg"))); 
				else if(personagem == 0)
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
			}
		});
		btnNewButton_player1.setBounds(1280, 101, 40, 40);
		contentPane.add(btnNewButton_player1);
		
		JButton btnNewButton_player2 = new JButton("");
		btnNewButton_player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personagem == 1)
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
				else if(personagem == 2)
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
				else if(personagem == 3)
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
				else if(personagem == 4)
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg"))); 
				else if(personagem == 0)
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
			}
		});
		btnNewButton_player2.setBounds(1280, 220, 40, 40);
		contentPane.add(btnNewButton_player2);
		
		JButton btnNewButton_player3 = new JButton("");
		btnNewButton_player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personagem == 1)
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
				else if(personagem == 2)
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
				else if(personagem == 3)
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
				else if(personagem == 4)
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg"))); 
				else if(personagem == 0)
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
			}
		});
		btnNewButton_player3.setBounds(1280, 351, 40, 40);
		contentPane.add(btnNewButton_player3);
		
		JButton btnNewButton_player4 = new JButton("");
		btnNewButton_player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personagem == 1)
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
				else if(personagem == 2)
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
				else if(personagem == 3)
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
				else if(personagem == 4)
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg"))); 
				else if(personagem == 0)
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
			}
		});
		btnNewButton_player4.setBounds(1280, 481, 40, 40);
		contentPane.add(btnNewButton_player4);
		
		
		//Label que possui o mapa, posicionado no final para não ficar em cima dos outros componentes!!!
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Tabuleiro_Placeholder.jpg")));
		lblNewLabel.setBounds(22, 19, 1280, 720);
		contentPane.add(lblNewLabel);
		
		
		
	
		//Função para centralizar o programa na tela!
		setLocationRelativeTo(null);
	}
}
