package aps_ambiente; //Pacote do jogo.

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
//Import utilizado.

public class Inimigo3 { // Classe principal 
	
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	
	
	private static int VELOCIDADE = 2; //velocidade do inimigo
	
	public Inimigo3 (int x, int y) {// classe construtor 
		this.x = x;
		this.y = y;
		isVisivel = true;
	}// classe construtor 
	
	public void load() { // carrega o inimigo
		ImageIcon referencia = new ImageIcon("res\\saco-lixo.png");
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}// carrega o inimigo
	
	public void update() { //atualiza inimigo 
		this.x -= VELOCIDADE;
	
	}//update
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	
	
}//classe principal