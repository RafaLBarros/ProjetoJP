package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	// Cria o primeiro valor de personagem, inicializado no equivalente a vazio.
	private int personagem = 0;
	// Cria o primeiro valor de personagem selecionado!
	private int player1_personagem = 0;
	private int player2_personagem = 0;
	private int player3_personagem = 0;
	private int player4_personagem = 0;

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
		// Não permite mexer o tamanho da pagina
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Tamanho pre-setado para o placeholder ficar em um tamanho bom, mexer depois
		// com o mapa novo!
		setBounds(100, 100, 1400, 773);
		contentPane = new JPanel();
		// Coloquei a cor do background branca para mesclar com o mapa!
		contentPane.setBackground(new Color(255, 255, 255));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// A seguir os labels de escolher personagem!
		JLabel lblNewLabel_1 = new JLabel("Escolha o Jogador 1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 30, 130, 57);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Escolha o Jogador 2");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 152, 130, 57);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Escolha o Jogador 3");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 283, 130, 57);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Escolha o Jogador 4");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 413, 130, 57);
		contentPane.add(lblNewLabel_4);

		// A seguir os botões para selecionar os personagens!
		JButton btnNewButton_sieg = new JButton("");
		btnNewButton_sieg.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.png")));
		btnNewButton_sieg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 1;
			}
		});
		btnNewButton_sieg.setBounds(14, 561, 40, 40);
		contentPane.add(btnNewButton_sieg);

		JButton btnNewButton_zero = new JButton("");
		btnNewButton_zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 2;
			}
		});
		btnNewButton_zero.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
		btnNewButton_zero.setBounds(64, 561, 40, 40);
		contentPane.add(btnNewButton_zero);

		JButton btnNewButton_uno = new JButton("");
		btnNewButton_uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 3;
			}
		});
		btnNewButton_uno.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
		btnNewButton_uno.setBounds(14, 612, 40, 40);
		contentPane.add(btnNewButton_uno);

		JButton btnNewButton_ai = new JButton("");
		btnNewButton_ai.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg")));
		btnNewButton_ai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 4;
			}
		});
		btnNewButton_ai.setBounds(64, 612, 40, 40);
		contentPane.add(btnNewButton_ai);

		// Botão para selecionar personagem vazio, caso tenha selecionado errado!
		JButton btnNewButton_vazio = new JButton("");
		btnNewButton_vazio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 0;
			}
		});
		btnNewButton_vazio.setBounds(39, 657, 40, 40);
		contentPane.add(btnNewButton_vazio);

		/*
		 * A seguir botões para pressionar após selecionar qual personagem quer! Quero
		 * mudar a forma que isso funciona, mas não tenho ideias ainda, aceito sugestões
		 * Quero também que quando uma pessoa selecione um personagem, a outra não possa
		 * selecionar o mesmo! ~Rafael
		 */
		JButton btnNewButton_player1 = new JButton("");
		btnNewButton_player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (personagem == 1 && player1_personagem != 1 && player2_personagem != 1 && player3_personagem != 1
						&& player4_personagem != 1) {
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
					player1_personagem = 1;
				} else if (personagem == 2 && player1_personagem != 2 && player2_personagem != 2
						&& player3_personagem != 2 && player4_personagem != 2) {
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
					player1_personagem = 2;
				} else if (personagem == 3 && player1_personagem != 3 && player2_personagem != 3
						&& player3_personagem != 3 && player4_personagem != 3) {
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
					player1_personagem = 3;
				} else if (personagem == 4 && player1_personagem != 4 && player2_personagem != 4
						&& player3_personagem != 4 && player4_personagem != 4) {
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg")));
					player1_personagem = 4;
				} else if (personagem == 0) {
					btnNewButton_player1.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
					player1_personagem = 0;
				} else {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
				}
			}
		});
		btnNewButton_player1.setBounds(39, 101, 40, 40);
		contentPane.add(btnNewButton_player1);

		JButton btnNewButton_player2 = new JButton("");
		btnNewButton_player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (personagem == 1 && player1_personagem != 1 && player2_personagem != 1 && player3_personagem != 1
						&& player4_personagem != 1) {
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
					player2_personagem = 1;
				} else if (personagem == 2 && player1_personagem != 2 && player2_personagem != 2
						&& player3_personagem != 2 && player4_personagem != 2) {
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
					player2_personagem = 2;
				} else if (personagem == 3 && player1_personagem != 3 && player2_personagem != 3
						&& player3_personagem != 3 && player4_personagem != 3) {
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
					player2_personagem = 3;
				} else if (personagem == 4 && player1_personagem != 4 && player2_personagem != 4
						&& player3_personagem != 4 && player4_personagem != 4) {
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg")));
					player2_personagem = 4;
				} else if (personagem == 0) {
					btnNewButton_player2.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
					player2_personagem = 0;
				} else {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
				}
			}
		});
		btnNewButton_player2.setBounds(39, 220, 40, 40);
		contentPane.add(btnNewButton_player2);

		JButton btnNewButton_player3 = new JButton("");
		btnNewButton_player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (personagem == 1 && player1_personagem != 1 && player2_personagem != 1 && player3_personagem != 1
						&& player4_personagem != 1) {
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
					player3_personagem = 1;
				} else if (personagem == 2 && player1_personagem != 2 && player2_personagem != 2
						&& player3_personagem != 2 && player4_personagem != 2) {
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
					player3_personagem = 2;
				} else if (personagem == 3 && player1_personagem != 3 && player2_personagem != 3
						&& player3_personagem != 3 && player4_personagem != 3) {
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
					player3_personagem = 3;
				} else if (personagem == 4 && player1_personagem != 4 && player2_personagem != 4
						&& player3_personagem != 4 && player4_personagem != 4) {
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg")));
					player3_personagem = 4;
				} else if (personagem == 0) {
					btnNewButton_player3.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
					player3_personagem = 0;
				} else {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
				}
			}
		});
		btnNewButton_player3.setBounds(39, 351, 40, 40);
		contentPane.add(btnNewButton_player3);

		JButton btnNewButton_player4 = new JButton("");
		btnNewButton_player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (personagem == 1 && player1_personagem != 1 && player2_personagem != 1 && player3_personagem != 1
						&& player4_personagem != 1) {
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Sieghart.jpg")));
					player4_personagem = 1;
				} else if (personagem == 2 && player1_personagem != 2 && player2_personagem != 2
						&& player3_personagem != 2 && player4_personagem != 2) {
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Zero.jpg")));
					player4_personagem = 2;
				} else if (personagem == 3 && player1_personagem != 3 && player2_personagem != 3
						&& player3_personagem != 3 && player4_personagem != 3) {
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Uno.jpg")));
					player4_personagem = 3;
				} else if (personagem == 4 && player1_personagem != 4 && player2_personagem != 4
						&& player3_personagem != 4 && player4_personagem != 4) {
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Ai.jpg")));
					player4_personagem = 4;
				} else if (personagem == 0) {
					btnNewButton_player4.setIcon(new ImageIcon(Tabuleiro.class.getResource("")));
					player4_personagem = 0;
				} else {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
				}
			}
		});
		btnNewButton_player4.setBounds(39, 481, 40, 40);
		contentPane.add(btnNewButton_player4);

		// BIOMAS
		
		//FOGO
		JButton btnNewButton_fire1 = new JButton("");
		btnNewButton_fire1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire1.setBounds(322, 30, 80, 80);
		contentPane.add(btnNewButton_fire1);

		JButton btnNewButton_fire2 = new JButton("");
		btnNewButton_fire2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire2.setBounds(422, 30, 80, 80);
		contentPane.add(btnNewButton_fire2);

		JButton btnNewButton_fire3 = new JButton("");
		btnNewButton_fire3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire3.setBounds(522, 30, 80, 80);
		contentPane.add(btnNewButton_fire3);

		JButton btnNewButton_fire4 = new JButton("");
		btnNewButton_fire4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire4.setBounds(622, 30, 80, 80);
		contentPane.add(btnNewButton_fire4);

		JButton btnNewButton_fire5 = new JButton("");
		btnNewButton_fire5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire5.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire5.setBounds(722, 30, 80, 80);
		contentPane.add(btnNewButton_fire5);

		JButton btnNewButton_fire6 = new JButton("");
		btnNewButton_fire6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire6.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire6.setBounds(822, 30, 80, 80);
		contentPane.add(btnNewButton_fire6);

		JButton btnNewButton_fire7 = new JButton("");
		btnNewButton_fire7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire7.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire7.setBounds(922, 30, 80, 80);
		contentPane.add(btnNewButton_fire7);

		JButton btnNewButton_fire8 = new JButton("");
		btnNewButton_fire8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire8.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire8.setBounds(1022, 30, 80, 80);
		contentPane.add(btnNewButton_fire8);

		JButton btnNewButton_fire9 = new JButton("");
		btnNewButton_fire9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_fire9.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fire.jpg")));
		btnNewButton_fire9.setBounds(1122, 30, 80, 80);
		contentPane.add(btnNewButton_fire9);

		JButton btnNewButton_water1 = new JButton("");
		btnNewButton_water1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//ÁGUA
		btnNewButton_water1.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water1.setBounds(1222, 30, 80, 80);
		contentPane.add(btnNewButton_water1);

		JButton btnNewButton_water2 = new JButton("");
		btnNewButton_water2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water2.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water2.setBounds(1222, 220, 80, 80);
		contentPane.add(btnNewButton_water2);

		JButton btnNewButton_water3 = new JButton("");
		btnNewButton_water3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water3.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water3.setBounds(1222, 120, 80, 80);
		contentPane.add(btnNewButton_water3);

		JButton btnNewButton_water4 = new JButton("");
		btnNewButton_water4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water4.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water4.setBounds(1222, 320, 80, 80);
		contentPane.add(btnNewButton_water4);

		JButton btnNewButton_water5 = new JButton("");
		btnNewButton_water5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water5.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water5.setBounds(1222, 420, 80, 80);
		contentPane.add(btnNewButton_water5);

		JButton btnNewButton_water6 = new JButton("");
		btnNewButton_water6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water6.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water6.setBounds(1222, 520, 80, 80);
		contentPane.add(btnNewButton_water6);

		JButton btnNewButton_water7 = new JButton("");
		btnNewButton_water7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water7.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water7.setBounds(1222, 620, 80, 80);
		contentPane.add(btnNewButton_water7);

		JButton btnNewButton_water8 = new JButton("");
		btnNewButton_water8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water8.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water8.setBounds(1122, 620, 80, 80);
		contentPane.add(btnNewButton_water8);

		JButton btnNewButton_water9 = new JButton("");
		btnNewButton_water9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water9.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water9.setBounds(1022, 620, 80, 80);
		contentPane.add(btnNewButton_water9);

		JButton btnNewButton_water10 = new JButton("");
		btnNewButton_water10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_water10.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/water.png")));
		btnNewButton_water10.setBounds(922, 620, 80, 80);
		contentPane.add(btnNewButton_water10);

		// Label que possui o mapa, posicionado no final para não ficar em cima dos
		// outros componentes!!!
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/Tabuleiro_Placeholder.jpg")));
//		lblNewLabel.setBounds(22, 19, 1280, 720);
//		contentPane.add(lblNewLabel);

		// Função para centralizar o programa na tela!
		setLocationRelativeTo(null);
	}
}
