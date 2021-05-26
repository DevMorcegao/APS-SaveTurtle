package aps_ambiente; //Pacote do jogo.

import javax.swing.ImageIcon;  
import javax.swing.JFrame;

//Import utilizado.

public class Tela extends JFrame{ // Classe principal 
  
	public Tela (){ // metodo construtor.
		add(new Comeco()); // adicona classe Comeco
    	setTitle("Jogo Aps 3 º semestre"); // Tituto da pgina 
    	ImageIcon icone = new ImageIcon("res\\icon.png");// imagem do icone.
        this.setIconImage(icone.getImage());

		setSize(1024,728); // dimensoes da tela do jogo 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}// constructor
             
	public static void main (String [] args){
		new Tela();
	}// main
    
	
  
}//class Tela