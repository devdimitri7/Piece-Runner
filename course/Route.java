package course;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.Player;
import objects.Piece;
import player.Player1;
import player.Player10;
import player.Player11;
import player.Player2;
import player.Player3;
import player.Player4;
import player.Player5;
import player.Player6;
import player.Player7;
import player.Player8;
import player.Player9;

public class Route extends JPanel implements Runnable {
	//Taille de nos joueur;
	public final int title = 68;
	//nombre de colone.
	public final int col = 12;
	//nombre de ligne.
	public final int row = 8;
	
	public final int largeur = title * col;
	public final int longueur = title * row;
	//Thread.
	Thread th;
	//nombre d'image par seconde.
	int FPS = 60;
	//les classes controle, joueur et la classe qui ajoutera les tuiles.
	TileMap tileMap = new TileMap(this);
	Control ct = new Control();
	Player1 pl = new Player1(this, ct);
	Player2 pl2 = new Player2(this);
	Player3 pl3 = new Player3(this);
	Player4 pl4 = new Player4(this);
	Player5 pl5 = new Player5(this);
	Player6 pl6 = new Player6(this);
	Player7 pl7 = new Player7(this);
	Player8 pl8 = new Player8(this);
	Player9 pl9 = new Player9(this);
	Player10 pl10 = new Player10(this);
	Player11 pl11 = new Player11(this);
	
	public boolean collisionOn = false;
	
	public Clip clip;
	public Clip clip1;
	//la classe de notre objet piece.
	Piece pie = new Piece(this);
	
	private boolean piece = false;
	
	public int hasPie = 0;
	//la classe qui se chargera d'affiche les pieces recolte et les messages.
	Ui ui = new Ui(this);
	
	

	public Route() {
		
		this.setPreferredSize(new Dimension(largeur, longueur));
		this.setBackground(Color.gray);
		this.setDoubleBuffered(true);
		this.setFocusable(true);

		this.addKeyListener(ct); 
	}
	
	public void lets_go() {
		th = new Thread(this);
		th.start();
		loadson("song/audio/game-mode.wav");
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	//Notre boucle de jeu.
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		
		while(th != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if(delta >= 1) {
				update();
				collision();
				colliPie();
				repaint();
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				//System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
		
	}
	//Methode de la mise a jour des composants du jeu.
	public void update() {
		
		//Player1
		pl.update();
		//Player2
		pl2.update();
		//Player3
		pl3.update();
		//Player4
		pl4.update();
		//Player5
		pl5.update();
		//Player6
		pl6.update();
		//Player7
		pl7.update();
		//Player8
		pl8.update();
		//Player9
		pl9.update();
		//Player10
		pl10.update();
		//Player11
		pl11.update();
	
	}
	//methode qui va dessiner tous nos autre classe dans le panneau principal.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//Map
		tileMap.draw(g2);
		//Player1
		pl.draw(g2);
		//Player2
		pl2.draw(g2);
		//player3
		pl3.draw(g2);
		//Player4
		pl4.draw(g2);
		//Player5
		pl5.draw(g2);
		//Player6
		pl6.draw(g2);
		//Player7
		pl7.draw(g2);
		//Player8
		pl8.draw(g2);
		//Player9
		pl9.draw(g2);
		//Player10
		pl10.draw(g2);
		//Player11
		pl11.draw(g2);
		
		//Objet
		pie.draw(g2);
		
		//
		ui.draw(g2);
		
		
		if(collisionOn == true) {
			Font font = new Font("Courier", Font.BOLD, 50);
			g.setFont(font);
			
			g.setColor(Color.white);
			g.fillRect(250, 70, 270, 40);
			
			g.setColor(Color.black);
			g.drawString("Game over", 250, 100);
			
		}
		
		g2.dispose();
	}
	//la methode de detection des collision entre Player1 et les autres voitures.
	public void collision() {
		if(pl.re.intersects(pl4.re4)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl3.re3)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl2.re2)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl5.re5)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl6.re6)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl7.re7)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl8.re8)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl9.re9)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl10.re10)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else if(pl.re.intersects(pl11.re11)) {
			collisionOn = true;
			endGame();
			clip.stop();
		}
		else {
			collisionOn = false;
		}
	}
	//La methode qui est appelee quand le joueur perd la partie.
	public void endGame() {
		System.out.println("Vous avez perdu !");
		th = null;
		try {
			File audio = new File("song/audio/fini.wav");
			AudioInputStream sc = AudioSystem.getAudioInputStream(audio);
			Clip wav = AudioSystem.getClip();
			wav.open(sc);
			wav.start();
			
			 wav.addLineListener(event -> {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    wav.close();
	                }
	            });
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//Methode de musique, vous pouvez ajouter le chemin de votre musique dans le constructeur de la methode.
	public void loadson(String FilePath) {
		
		try {
			File audioSrc = new File(FilePath);
			AudioInputStream ais = AudioSystem.getAudioInputStream(audioSrc);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Methode de collection des piece au moment de la collision.
	public void colliPie() {
		piece = false;
		if(pl.re.intersects(pie.rectPie) || pl.re.intersects(pie.rectPie2) || pl.re.intersects(pie.rectPie3) || pl.re.intersects(pie.rectPie4) || pl.re.intersects(pie.rectPie5)){
			hasPie++;
			 try {
		            // Charger et jouer le son de la pièce
		            File audioSrc = new File("song/audio/coin.wav");
		            AudioInputStream ais = AudioSystem.getAudioInputStream(audioSrc);
		            Clip clipPiece = AudioSystem.getClip();
		            clipPiece.open(ais);
		            clipPiece.start();

		            // Arrêter le son après sa lecture
		            clipPiece.addLineListener(event -> {
		                if (event.getType() == LineEvent.Type.STOP) {
		                    clipPiece.close();
		                }
		            });


		            // Réinitialiser la position de la pièce
		            pie.resetPosition();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
		
	}
	

}
