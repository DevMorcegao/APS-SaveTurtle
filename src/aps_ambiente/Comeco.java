package aps_ambiente; // pacote do jogo 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
// import utilizado

public class Comeco extends JPanel implements ActionListener { // classe
	private Image fundo;
	private Player player;
	private Timer timer;
	private List<Inimigo1> inimigo1;
	private List<Inimigo2> inimigo2;
	private List<Inimigo3> inimigo3;


	private boolean emJogo;

	public Comeco() { //metodo construtor 
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res\\fundo-mar-poluido.jpg"); // imagem de fundo 
		fundo = referencia.getImage();

		player = new Player();
		player.load();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		inicializaInimigos1();
		inicializaInimigos2();
		inicializaInimigos3();


		emJogo = true;

	}// constructor

	public void inicializaInimigos1() { // inicializa e confugura como o inimigo vai aparecer 
		int coordenadas[] = new int[80]; // quantidade de vezes que o inimigo aparece
		inimigo1 = new ArrayList<Inimigo1>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 80000 + 1024); // velocidade e onde vai aparecer
			int y = (int) (Math.random() * 650 + 30);  // velocidade e onde vai aparecer 
			inimigo1.add(new Inimigo1(x, y));
		} // inicializa e confugura como o inimigo vai aparecer 

	}// inicializaInimigos

	public void inicializaInimigos2() { // inicializa e confugura como o inimigo vai aparecer 
		int coordenadas[] = new int[80]; // quantidade de vezes que o inimigo aparece
		inimigo2 = new ArrayList<Inimigo2>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 180000 + 1024); // velocidade e onde vai aparecer 
			int y = (int) (Math.random() * 650 + 30); // velocidade e onde vai aparecer 
			inimigo2.add(new Inimigo2(x, y));
		} // inicializa e confugura como o inimigo vai aparecer 

	}// inicializaInimigos

	public void inicializaInimigos3() { // inicializa e confugura como o inimigo vai aparecer 
		int coordenadas[] = new int[80]; // quantidade de vezes que o inimigo aparece
		inimigo3 = new ArrayList<Inimigo3>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 200000 + 1024); // velocidade e onde vai aparecer 
			int y = (int) (Math.random() * 650 + 30); // velocidade e onde vai aparecer 
			inimigo3.add(new Inimigo3(x, y)); 
		} // inicializa e confugura como o inimigo vai aparecer 

	}// inicializa e confugura como o inimigo vai aparecer 



	// inicializaInimigos

	public void paint(Graphics g) { // laco de repeticao para pintar onde passa o inimigo e renderizar imagens
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo == true) {
			graficos.drawImage(fundo, 0, 0, null);
			

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
			
			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 in = inimigo1.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			} // for
			for (int o = 0; o < inimigo2.size(); o++) {
				Inimigo2 in = inimigo2.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			} 
			for (int o = 0; o < inimigo3.size(); o++) {
				Inimigo3 in = inimigo3.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			} 

		} // if
		else {
			ImageIcon fimJogo = new ImageIcon("res\\game-over.jpeg"); // fim de jogo, quano player colide com os inimigos
			graficos.drawImage(fimJogo.getImage(), 0, 0, 1024, 728, null);
		} // else

		g.dispose();

	}// paint

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();

		for (int o = 0; o < inimigo1.size(); o++) {
			Inimigo1 in = inimigo1.get(o);
			if (in.isVisivel()) {
				in.update();
			} // if

		} // for

		for (int o = 0; o < inimigo2.size(); o++) {
			Inimigo2 in = inimigo2.get(o);
			if (in.isVisivel()) {
				in.update();
			} // if

		} // for
		for (int o = 0; o < inimigo3.size(); o++) {
			Inimigo3 in = inimigo3.get(o);
			if (in.isVisivel()) {
				in.update();
			} // if

		} // for
		
		checarColisoes();

		repaint();

	}// laco de repeticao para pintar onde passa o inimigo e renderizar imagens

	public void checarColisoes() { // colisoes com inimigos 
		Rectangle formaNave = player.getBounds();
		Rectangle formaInimigo1;
		Rectangle formaInimigo2;
		Rectangle formaInimigo3;
		

		for (int i = 0; i < inimigo1.size(); i++) {
			Inimigo1 tempInimigo1 = inimigo1.get(i);
			formaInimigo1 = tempInimigo1.getBounds();
			if (formaNave.intersects(formaInimigo1)) {
				player.setVisivel(false);
				tempInimigo1.setVisivel(false);
				emJogo = false;
			} // if
		} // for
		for (int i = 0; i < inimigo2.size(); i++) {
			Inimigo2 tempInimigo2 = inimigo2.get(i);
			formaInimigo2 = tempInimigo2.getBounds();
			if (formaNave.intersects(formaInimigo2)) {
				player.setVisivel(false);
				tempInimigo2.setVisivel(false);
				emJogo = false;
			} // if
		} // for
		for (int i = 0; i < inimigo3.size(); i++) {
			Inimigo3 tempInimigo3 = inimigo3.get(i);
			formaInimigo3 = tempInimigo3.getBounds();
			if (formaNave.intersects(formaInimigo3)) {
				player.setVisivel(false);
				tempInimigo3.setVisivel(false);
				emJogo = false;
			} // if
		} // for

		
	} // colisoes com inimigos 

	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			player.keypressed(e);
		}// keyPressed

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}// keyRelease

	}// classe TecladoAdapter
}// classe