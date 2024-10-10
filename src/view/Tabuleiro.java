package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControleCasa;
import controller.ControlePersonagem;

public class Tabuleiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private Background contentPane;
	private boolean isRolling = false;
	//Instanciando os atributos controle para utilizar o método MVC, onde o View comunica com Controle
	private ControleCasa controleCasa = new ControleCasa();
	private ControlePersonagem controlePersonagem = new ControlePersonagem();
	private boolean inGame = true;
	private boolean canRoll = true;
	//Atributo que é utilizado no método de roll de dado.
	Random random = new Random();
	
	//Coordenadas do tabuleiro abaixo, a partir do inicio!
	private int inicioX = 300;
	private int inicioY = 11;
	// Coordenadas X e Y para cada tipo de casa
	private int[][] coordsX = { 
			{ 400, 500, 600, 700, 800, 900, 1000 }, // Fogo
			{ 1000, 1000, 1000, 1000, 1000, 1000, 900 }, // Água
			{ 800, 700, 600, 500, 400, 400, 400 }, // Vento
			{ 400, 400, 400, 500, 600, 700, 800 }, // Gelo
			{ 900, 900, 900, 900, 900, 800, 700 }, // Eletricidade
			{ 600, 500, 500, 500, 500, 600, 700 }, // Areia
			{ 800, 800, 800, 700, 600, 600, 700 }, // Escuridão e Final
	};
	private int[][] coordsY = { 
			{ 11, 11, 11, 11, 11, 11, 11 }, // Fogo
			{ 101, 201, 301, 401, 501, 601, 601 }, // Água
			{ 601, 601, 601, 601, 601, 501, 401 }, // Vento
			{ 301, 201, 101, 101, 101, 101, 101 }, // Gelo
			{ 101, 201, 301, 401, 501, 501, 501 }, // Eletricidade
			{ 501, 501, 401, 301, 201, 201, 201 }, // Areia
			{ 201, 301, 401, 401, 401, 301, 301 }, // Escuridão e Final
	};
	
	//Atributo de Turno, para contabilizar qual label de player mover!
	private int turno = 0;
	
	//Atributo array de Labels para armazenar as fotos dos personagens minimazadas, utilizadas no Tabuleiro!
	private JLabel[] lbl_charactermini = new JLabel[4];
	
	//A partir daqui é o construtor do frame, qnd inicializado executa tudo dentro do construtor!
	public Tabuleiro() {
		
		// Não permite mexer o tamanho da pagina
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tamanho da página
		setBounds(100, 100, 1296, 759);
		
		//ContentPane agora é background classe ja feita com a imagem!
		contentPane = new Background("/images/mapa.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// A seguir os labels de texto dos jogadores!
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

		//Labels de Jogadores abaixo, para inserir a foto dos personagens!
		JLabel[] lbl_player = new JLabel[4];
		JLabel[] lbl_bordaPlayer = new JLabel[4];
		int[] playerX = { 97, 97, 97, 97 };
		int[] playerY = { 55, 155, 255, 355 };
		int[] bordaPX = { 90, 90, 90, 90 };
		int[] bordaPY = { 48, 148, 248, 348 };
		
		//Loop que coloca todos os labels no contentPane com imagem Vazia!
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
		
		//Label invisivel que aparece após apertar o botão de selecionar personagem! Escreve qual jogador deve selecionar!
		JLabel sel_player = new JLabel("");
		sel_player.setHorizontalAlignment(SwingConstants.CENTER);
		sel_player.setBounds(50, 503, 140, 14);
		contentPane.add(sel_player);


		// A seguir os botões para selecionar os personagens e array com os objetos de personagem instanciados!
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
				controlePersonagem.setPersonagem(1);
				escolherPersonagemVisual(controlePersonagem.getPersonagem(),lbl_player, btn_characters, sel_player);
				
			}
		});
		btn_characters[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlePersonagem.setPersonagem(2);
				escolherPersonagemVisual(controlePersonagem.getPersonagem(),lbl_player, btn_characters, sel_player);
			}
		});
		btn_characters[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlePersonagem.setPersonagem(3);
				escolherPersonagemVisual(controlePersonagem.getPersonagem(),lbl_player, btn_characters, sel_player);
			}
		});
		btn_characters[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlePersonagem.setPersonagem(4);
				escolherPersonagemVisual(controlePersonagem.getPersonagem(),lbl_player, btn_characters, sel_player);
			}
		});
		
		//Botão de selecionar, quando utilizado ativa os botões de personagem para serem selecionados!
		JButton btn_selecionarPlayer = new JButton("Selecionar Players");
		btn_selecionarPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_selecionarPlayer.setVisible(false);
				mudarPersonagemVisual(lbl_player, btn_characters, sel_player);
			}
		});
		btn_selecionarPlayer.setBounds(50, 503, 140, 14);
		contentPane.add(btn_selecionarPlayer);

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// BIOMAS

		JLabel inicioLabel = new JLabel();

		inicioLabel.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/inicio.png")));
		inicioLabel.setBounds(inicioX, inicioY, 80, 80);
		contentPane.add(inicioLabel);

		JLabel[][] labels = new JLabel[7][7];


		// Icones de Elementos das Casas
		String[] icons = { "/images/fire.png", 
				"/images/water.png", 
				"/images/wind.png", 
				"/images/ice.png", 
				"/images/electric.png", 
				"/images/sand.png", 
				"/images/dark.png", 
		};

		HashMap<Integer, JLabel> casas = new HashMap<>();

		int idCasa = 0; // Idzando (nao pensei em outro nome) casas
		
		//Coloca cada casa em sua respectiva coordenada!
		for (int tipo = 0; tipo < labels.length; tipo++) {
			int length = coordsX[tipo].length;
			labels[tipo] = new JLabel[length];

			for (int i = 0; i < length; i++) {
				labels[tipo][i] = new JLabel();
				if ((tipo*7)+i != 48) {
					labels[tipo][i].setIcon(new ImageIcon(Tabuleiro.class.getResource(icons[tipo])));
				}else {
					labels[tipo][i].setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/fim.png")));
				}
				labels[tipo][i].setBounds(coordsX[tipo][i], coordsY[tipo][i], 80, 80);
				contentPane.add(labels[tipo][i]);

				// Adiciona a label ao HashMap com ID
				casas.put(idCasa++, labels[tipo][i]);
				//Método para criar o tabuleiro dentro do controleCasa!
				controleCasa.setTabuleiro(i,tipo);
			}

		}
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		
		//Linha pra simular o caminho
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/mapa2.png")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		// Função para centralizar o programa na tela!
		setLocationRelativeTo(null);
	}
	//A partir daqui já nao está no construtor, são os métodos!
	
	 //Método para fazer o visual de rolar o dado!
	void rollVisual() {
		//Checa se o turno é 4, se for 4 volta pro 0 (player 1)
		if (turno == 4)
			turno = 0;
		//Aumenta o turno para ir até o proximo jogador
		turno += 1;
		//Cria o label do dado na tela!
		JLabel lbl_DiceRoll = new JLabel("");
		lbl_DiceRoll.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/dice1.png")));
		lbl_DiceRoll.setBounds(463, 401, 256, 256);
		contentPane.add(lbl_DiceRoll, 1);
		//Se não tiver rolando, permite rolar o dado!
		if (!isRolling) {
			isRolling = true;
			// Setei o dado visivel na tela
			lbl_DiceRoll.setVisible(true);
			//Thread serve para poder usar o sleep, é um método com recursos de espera de segundos!
			Thread thread = new Thread() {
				public void run() {
					try {
						for (int i = 0; i < 15; i++) {
							//Seta o ultimo roll como um random de 1 a 6 (faz isso 15 vezes mas só armazena o ultimo!)
							controlePersonagem.getPlayerInstanciado(turno - 1).setLastRoll(random.nextInt(6) + 1);
							// Peguei o url da imagem do dado e setei
							String urldice = new String("/images/dice"
									+ (controlePersonagem.getPlayerInstanciado(turno - 1).getLastRoll()) + ".png");
							lbl_DiceRoll.setIcon(new ImageIcon(Tabuleiro.class.getResource(urldice)));
							// Espera 0.1 segundos pra fazer de novo
							Thread.sleep(100);
						}
						// Espera 1 segundos com o valor final
						Thread.sleep(1000);
						// Adiciona 1 no total de rolagens
						controlePersonagem.adicionarTotalRolagem(turno - 1);
						// Se tirou 6, adiciona 1 ao total de MaxDice
						if (controlePersonagem.getPlayerInstanciado(turno - 1).getLastRoll() == 6) {
							controlePersonagem.adicionarMaxdice(turno - 1);
						}
						// Se tirou 1, adiciona 1 ao total de MinDice
						else if (controlePersonagem.getPlayerInstanciado(turno - 1).getLastRoll() == 1) {
							controlePersonagem.adicionarMindice(turno - 1);
						}
						// Faz o dado ficar invisivel de novo e remove ele!
						lbl_DiceRoll.setVisible(false);
						contentPane.remove(lbl_DiceRoll);
						contentPane.revalidate();
						contentPane.repaint();
						// Reseta o valor de isRolling para poder rolar de novo!
						Thread.sleep(1000);
						isRolling = false;
						//Executa o metodo de andar personagem, passando qual o turno para saber o jogador e o personagem deste jogador!
						andarPersonagens(controlePersonagem.getPlayerInstanciado(turno - 1).getPersonagem(), turno);
						//Executa o metodo para devolver o botão de roll no mapa, para o proximo jogador rolar!
						instanciarButtonRoll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			//Executa a thread!
			thread.start();
		} else {
			// Se o valor de isRolling é true, o dado ainda está sendo rolado, portanto deve
			// esperar
			JOptionPane.showMessageDialog(null, "Espere o dado terminar de rolar!");
		} 
	}
	void escolherPersonagemVisual(int personagem, JLabel[] lbl_player, JButton[] btn_characters, JLabel sel_player) {
		//Se personagem ja foi escolhido, não permite!
		if (controlePersonagem.getLista_personagens().contains(personagem)) {
			JOptionPane.showMessageDialog(null, "Personagem Ja Escolhido!");
			return;
		}
		//Adiciona personagem a lista de escolhidos!
		controlePersonagem.getLista_personagens().add(personagem);
		//Avisa que +1 personagem foi selecionado!
		controlePersonagem.setCharacters_selected(controlePersonagem.getCharacters_selected()+1);
		//Muda visual do Jogador para o personagem selecionado!
		mudarPersonagemVisual(lbl_player, btn_characters, sel_player);
		
	}
	
	void mudarPersonagemVisual(JLabel[] lbl_player, JButton[] btn_characters, JLabel sel_player) {
		//Coloca visivel o Label ("Selecinar Jogador tal")
		sel_player.setVisible(true);
		sel_player.setText("Selecionar Player " + (controlePersonagem.getCharacters_selected() + 1));
		
		//Se ainda não selecionaram ninguém, faça todos os personagens ficarem visiveis!
		if (controlePersonagem.getCharacters_selected() == 0) {
			for (int i = 0; i < 4; i++) {
				btn_characters[i].setVisible(true);
			}
			return;
		}
		//Se ja selecionaram, seta o lbl do personagem como o escolhido
		lbl_player[controlePersonagem.getCharacters_selected() - 1]
				.setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/character" + (controlePersonagem.getPersonagem()) + ".jpg")));
		//Se ja selecionaram todos
		if (controlePersonagem.getCharacters_selected() == 4) {
			//Invisivel o label de ("Selecionar Jogador tal")
			sel_player.setVisible(false);
			//Invisivel todos os botões de personagens!
			for (int i = 0; i < 4; i++) {
				btn_characters[i].setVisible(false);
			}
			//Permite o start do jogo!
			instanciarButtonStart();
		}
	}
	void instanciarButtonStart() {
		//JButton de começar o jogo após os players selecionarem os jogadores!
		JButton buttonStart = new JButton("Start!");
		buttonStart.setBounds(75,500,80,30);
		contentPane.add(buttonStart);
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Some com o botão de start
				buttonStart.setVisible(false);
				//Instancia os personagens
				controlePersonagem.instanciarPersonagens();
				//Instancia o botão de rolar o dado
				instanciarButtonRoll();
				//Executa o primeiro metodo de andar (Esse primeiro só coloca no inicio!)
				andarPersonagens(0,-1);
			}
		});
	}
	void instanciarButtonRoll() {
		//JButton de começar as rolagens
		JButton buttonRoll = new JButton("Roll!");
		buttonRoll.setBounds(75,500,80,30);
		contentPane.add(buttonRoll,1);
		buttonRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inGame && canRoll) {
					//Some com o botão
					buttonRoll.setVisible(false);
					contentPane.remove(buttonRoll);
					contentPane.revalidate();
					contentPane.repaint();
					//Executa o método de rolagem
					rollVisual();
				}
			}
		});
	}
	void andarPersonagens(int personagem,int turno) {
		//Impede de rolar enquanto tiver alguem andando!
		canRoll = false;
		//Coordenadas especificas para cada personagem!
		int coordSoma[][] = {{0,0},{40,0},{0,40},{40,40}};
		//Se turno for -1 (Esse valor pode ser qualquer um, coloquei -1 só pra simbolizar que nunca vai ser -1 durante o jogo, então esse é o momento de começar o jogo!
		if(turno == -1) {
			//Instancia os personagens na primeira casa, pois o jogo acabou de começar!
			for(int i = 0;i < controlePersonagem.getCharacters_selected();i++) {
				lbl_charactermini[i] = new JLabel("");
				lbl_charactermini[i].setIcon(new ImageIcon(Tabuleiro.class.getResource("/images/charactermini"+(i+1)+".png")));
				lbl_charactermini[i].setBounds(inicioX + coordSoma[i][0],inicioY+coordSoma[i][1],40,40);
				contentPane.add(lbl_charactermini[i],2);
				canRoll = true;
				}
		}
		//Se turno for diferente de -1, o jogo já começou!
		else {
			Thread thread = new Thread() {
				public void run() {
					try {
						//Pega o último roll do personagem do turno atual!
						int roll = controlePersonagem.getPlayerInstanciado(turno-1).getLastRoll();
						int casaAtual = 0;
						int tipo = 0;
						//Faz um for de acordo com o roll dele (Se ele tirou 3, andará 3 vezes)
						for(int i = 0;i < roll*10;i++) {
							//Pega o valor da casa atual após andar!
							casaAtual = controlePersonagem.getPlayerInstanciado(turno-1).getCasaAtual()+1;
							//Se a casa atual passar de 48, voltar para 48 pois é a casa final!
							if(casaAtual > 48) {
								casaAtual = 48;
								break;
							}
							else {
								controlePersonagem.getPlayerInstanciado(turno-1).walkCasaAtual(1);
							}
							//Pega o tipo da casa atual após andar!
							tipo = controleCasa.getCasa(casaAtual).getTipo();
							//Andar o personagem para a casa selecionada!
							lbl_charactermini[personagem-1].setBounds(coordsX[tipo][casaAtual -(tipo*7)]+coordSoma[personagem-1][0],coordsY[tipo][casaAtual-(tipo*7)]+coordSoma[personagem-1][1],40,40);
							//Espera 0.5 segundo para rodar de novo!
							Thread.sleep(300);
						}
						if(casaAtual == 48) {
							controlePersonagem.setConcludedStep(turno-1, 7);
							finalizarJogo();
						}
						else {
							controlePersonagem.setConcludedStep(turno-1,tipo);
						}
						canRoll = true;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			thread.start();
			}
		}
	void finalizarJogo() {
		Scoreboard scoreboard = new Scoreboard(controlePersonagem);
		inGame = false;
		this.dispose();
	}
}
