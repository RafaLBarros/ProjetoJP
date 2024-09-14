package view;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class Background extends JPanel
{
  public static BufferedImage image;
 
  public Background ()
  {
	//Puxa tudo da classe superior, classe pai
    super();
    //Lê o arquivo de imagem background que a gente quer
    try
    {               
      image = ImageIO.read(Tabuleiro.class.getResource("/images/mapa.jpg"));
    }
    catch (IOException e)
    {

    }
  }
  //Sobrecarga do método para pintar o JPanel com a imagem que a gente utilizou!
  public void paintComponent(Graphics g)
  {
	//Pinta utilizando a imagem carregada acima
    g.drawImage(image, 0, 0, null);
    //Método para garantir que o background carregue a imagem após pintá-la, basicamente um update!
    repaint();
  }
}