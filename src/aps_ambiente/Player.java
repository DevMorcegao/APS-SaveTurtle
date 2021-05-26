package aps_ambiente;//Pacote do jogo.

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
// import utilizados

public class Player { // Classe principal 
	
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private boolean isVisivel;
	
	public Player() { // metodo construtor
		this.x= 100;
		this.y = 728/2;	
		isVisivel= true;
		
	}// metodo construtor
	
	public void load() {  // carrega o player
		ImageIcon referencia = new ImageIcon("res\\tartaruga@0.75x.png"); // imagem do player
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}//carrega player
	
	public void update() { // atualiza os movimentos
		x += dx;
		y += dy;
	}// atualiza os movimentos
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	
	public void keypressed(KeyEvent tecla) { // comandos de teclado
		int codigo  = tecla.getKeyCode();
		
		if(codigo== KeyEvent.VK_UP) {
			dy = -3;
		}//if
		if(codigo== KeyEvent.VK_DOWN) {
			dy = 3;
		}//if		
		if(codigo== KeyEvent.VK_LEFT) {
			dx = -3;
		}//if
		if(codigo== KeyEvent.VK_RIGHT) {
			dx = 3;
		}//if
		
	}// comandos de teclado
	
	public void keyRelease(KeyEvent tecla) { // comandos de teclado
		int codigo  = tecla.getKeyCode();
		
		if(codigo== KeyEvent.VK_UP) {
			dy = 0;
		}//if
		if(codigo== KeyEvent.VK_DOWN) {
			dy = 0;
		}//if		
		if(codigo== KeyEvent.VK_LEFT) {
			dx = 0;
		}//if
		if(codigo== KeyEvent.VK_RIGHT) {
			dx = 0;
		}//if
		
	}// comandos de teclado
	
	

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
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
	
}//classe