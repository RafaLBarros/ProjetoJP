package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tabuleiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// Cria o primeiro valor de personagem, inicializado no equivalente a vazio.
	private int personagem = 0;
	// Cria o primeiro valor de personagem selecionado!
	ArrayList<Integer> lista_personagens = new ArrayList<Integer>();
	private boolean isRolling = false;
	private int characters_selected = 0;

	Random random = new Random();

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
		setBounds(100, 100, 1296, 759);
		contentPane = new JPanel();
		// Coloquei a cor do background branca para mesclar com o mapa!
		contentPane.setBackground(new Color(255, 255, 255));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// A seguir os labels de escolher personagem!
		JLabel lblNewLabel_1 = new JLabel("Jogador 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(88, 30, 60, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Jogador 2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(88, 130, 60, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Jogador 3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(88, 230, 60, 23);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Jogador 4");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(88, 330, 60, 23);
		contentPane.add(lblNewLabel_4);

		/*
		 * A seguir botões para pressionar após selecionar qual personagem quer! Quero
		 * mudar a forma que isso funciona, mas não tenho ideias ainda, aceito sugestões
		 * Quero também que quando uma pessoa selecione um personagem, a outra não possa
		 * selecionar o mesmo! (JA ADICIONADO) ~Rafael
		 */
		JLabel[] lbl_player = new JLabel[4];
		JLabel[] lbl_bordaPlayer = new JLabel[4];
		int[] playerX = { 97, 97, 97, 97 };
		int[] playerY = { 55, 155, 255, 355 };
		int[] bordaPX = { 90, 90, 90, 90 };
		int[] bordaPY = { 48, 148, 248, 348 };

		for (int i = 0; i < lbl_player.length; i++) {
			lbl_player[i] = new JLabel();
			lbl_bordaPlayer[i] = new JLabel();
			lbl_bordaPlayer[i].setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/border.png")));
			lbl_player[i].setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/character0.jpg")));
			lbl_player[i].setHorizontalAlignment(SwingConstants.CENTER);
			lbl_player[i].setBounds(playerX[i], playerY[i], 40, 40);
			lbl_bordaPlayer[i].setBounds(bordaPX[i], bordaPY[i], 55, 55);
			contentPane.add(lbl_player[i]);
			contentPane.add(lbl_bordaPlayer[i]);
		}
		JLabel sel_player = new JLabel("");
		sel_player.setHorizontalAlignment(SwingConstants.CENTER);
		sel_player.setBounds(50, 503, 140, 14);
		contentPane.add(sel_player);

		// A seguir os botões para selecionar os personagens!
		JButton[] btn_characters = new JButton[4];
		int[] characterX = { 25, 75, 125, 175 };
		int[] characterY = { 542, 542, 542, 542 };
		for (int i = 0; i < btn_characters.length; i++) {
			btn_characters[i] = new JButton();
			btn_characters[i]
					.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/character" + (i + 1) + ".jpg")));
			btn_characters[i].setBounds(characterX[i], characterY[i], 40, 40);
			contentPane.add(btn_characters[i]);
			btn_characters[i].setVisible(false);
		}
		btn_characters[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 1;
				if (lista_personagens.contains(personagem)) {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
					return;
				}
				lista_personagens.add(personagem);
				characters_selected += 1;
				mudarPersonagem(lbl_player, btn_characters, sel_player);

			}
		});
		btn_characters[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 2;
				if (lista_personagens.contains(personagem)) {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
					return;
				}
				lista_personagens.add(personagem);
				characters_selected += 1;
				mudarPersonagem(lbl_player, btn_characters, sel_player);
			}
		});
		btn_characters[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 3;
				if (lista_personagens.contains(personagem)) {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
					return;
				}
				lista_personagens.add(personagem);
				characters_selected += 1;
				mudarPersonagem(lbl_player, btn_characters, sel_player);
			}
		});
		btn_characters[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personagem = 4;
				if (lista_personagens.contains(personagem)) {
					JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
					return;
				}
				lista_personagens.add(personagem);
				characters_selected += 1;
				mudarPersonagem(lbl_player, btn_characters, sel_player);
			}
		});

		JButton btn_selecionarPlayer = new JButton("Selecionar Players");
		btn_selecionarPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_selecionarPlayer.setVisible(false);
				mudarPersonagem(lbl_player, btn_characters, sel_player);
			}
		});

		btn_selecionarPlayer.setBounds(50, 503, 140, 14);
		contentPane.add(btn_selecionarPlayer);
		/*
		 * Animação do DiceRoll instanciada antes para que o método saiba onde chamar!
		 * 
		 */
		JLabel lblNewLabel_DiceRoll = new JLabel("");
		lblNewLabel_DiceRoll.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/dice1.png")));
		lblNewLabel_DiceRoll.setBounds(463, 401, 256, 256);
		contentPane.add(lblNewLabel_DiceRoll);
		lblNewLabel_DiceRoll.setVisible(false);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// BIOMAS

		JLabel inicioLabel = new JLabel();
		int inicioX = 300;
		int inicioY = 11;

		inicioLabel.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/inicio.png")));
		inicioLabel.setBounds(inicioX, inicioY, 80, 80);
		contentPane.add(inicioLabel);

		JLabel[][] labels = new JLabel[8][7];

		// Coordenadas X e Y para cada tipo de casa
		int[][] coordsX = { 
				{ 400, 500, 600, 700, 800, 900, 1000 }, // Fogo
				{ 1000, 1000, 1000, 1000, 1000, 1000, 900 }, // Água
				{ 800, 700, 600, 500, 400, 400, 400 }, // Vento
				{ 400, 400, 400, 500, 600, 700, 800 }, // Gelo
				{ 900, 900, 900, 900, 900, 800, 700 }, // Eletricidade
				{ 600, 500, 500, 500, 500, 600, 700 }, // Areia
				{ 800, 800, 800, 700, 600, 600 }, // Escuridão
				{ 700 } // Final
		};

		int[][] coordsY = { 
				{ 11, 11, 11, 11, 11, 11, 11 }, // Fogo
				{ 101, 201, 301, 401, 501, 601, 601 }, // Água
				{ 601, 601, 601, 601, 601, 501, 401 }, // Vento
				{ 301, 201, 101, 101, 101, 101, 101 }, // Gelo
				{ 101, 201, 301, 401, 501, 501, 501 }, // Eletricidade
				{ 501, 501, 401, 301, 201, 201, 201 }, // Areia
				{ 201, 301, 401, 401, 401, 301 }, // Escuridão
				{ 301 } // Final
		};

		// Icones de Elementos das Casas
		String[] icons = { "/images/fire.jpg", 
				"/images/water.png", 
				"/images/wind.png", 
				"/images/ice.png", 
				"/images/electric.png", 
				"/images/sand.png", 
				"/images/dark.png", 
				"/images/fim.png" 
		};


//		for (int tipo = 0; tipo < labels.length; tipo++) {
//			int length = coordsX[tipo].length; 
//			labels[tipo] = new JLabel[length]; 
//
//			for (int i = 0; i < length; i++) {
//				labels[tipo][i] = new JLabel();
//				labels[tipo][i].setIcon(new ImageIcon(Tabuleiro.class.getResource(icons[tipo])));
//				labels[tipo][i].setBounds(coordsX[tipo][i], coordsY[tipo][i], 80, 80);
//				contentPane.add(labels[tipo][i]);
//			}
//		}

		HashMap<Integer, JLabel> casas = new HashMap<>();

		int idCasa = 0; // Idzando (nao pensei em outro nome) casas

	
		for (int tipo = 0; tipo < labels.length; tipo++) {
			int length = coordsX[tipo].length;
			labels[tipo] = new JLabel[length];

			for (int i = 0; i < length; i++) {
				labels[tipo][i] = new JLabel();
				labels[tipo][i].setIcon(new ImageIcon(Tabuleiro.class.getResource(icons[tipo])));
				labels[tipo][i].setBounds(coordsX[tipo][i], coordsY[tipo][i], 80, 80);
				contentPane.add(labels[tipo][i]);

				// Adiciona a label ao HashMap com ID
				casas.put(idCasa++, labels[tipo][i]);
				System.out.println(idCasa);
			}

		}
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		
		//Linha pra simular o caminho
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/mapa2.png")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);

		// Label que possui o mapa, posicionado no final para não ficar em cima dos
		// outros componentes!!!
		JLabel lblNewLabel_Mapa = new JLabel("");
		lblNewLabel_Mapa.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_Mapa.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/mapa.jpg")));
		lblNewLabel_Mapa.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel_Mapa);

		// Função para centralizar o programa na tela!
		setLocationRelativeTo(null);
	}

	void roll(JLabel DiceRoll) {
		if (!isRolling) {
			isRolling = true;
			// Setei o dado visivel na tela
			DiceRoll.setVisible(true);
			Thread thread = new Thread() {
				public void run() {
					try {
						for (int i = 0; i < 15; i++) {
							// Peguei o url da imagem do dado e setei
							String urldice = new String("/images/dice" + (random.nextInt(6) + 1) + ".png");
							DiceRoll.setIcon(new ImageIcon(Tabuleiro.class.getResource(urldice)));
							// Espera 0.1 segundos pra fazer de novo
							Thread.sleep(100);
						}
						// Espera 3 segundos com o valor final
						Thread.sleep(3000);
						// Faz o dao ficar invisivel de novo
						DiceRoll.setVisible(false);
						// Reseta o valor de isRolling para poder rolar de novo!
						isRolling = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();
		} else {
			// Se o valor de isRolling é true, o dado ainda está sendo rolado, portanto deve
			// esperar
			JOptionPane.showMessageDialog(null, "Espere o dado terminar de rolar!");
		}
	}

	void mudarPersonagem(JLabel[] lbl_player, JButton[] btn_characters, JLabel sel_player) {
		sel_player.setVisible(true);
		sel_player.setText("Selecionar Player " + (characters_selected + 1));
		if (characters_selected == 0) {
			for (int i = 0; i < 4; i++) {
				btn_characters[i].setVisible(true);
			}
			return;
		}
		lbl_player[characters_selected - 1]
				.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/character" + (personagem) + ".jpg")));
		if (characters_selected == 4) {
			sel_player.setVisible(false);
			for (int i = 0; i < 4; i++) {
				btn_characters[i].setVisible(false);
			}
		}
	}
}
