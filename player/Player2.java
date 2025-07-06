package player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import course.Route;

public class Player2 extends JPanel {
	
	BufferedImage img;
	private boolean go = true;
	private Route rt;
	private int posX = 68;
	private int posY = -0;
	public Rectangle re2;
	
	public Player2(Route rt) {
		this.rt = rt;
		
		// Créer un Timer qui appelle update() toutes les 10 ms  
		Timer timer = new Timer(10, new ActionListener() {
		            @Override
		             public void actionPerformed(ActionEvent e) {
		                update();
		                repaint();
		            }
		        });
		        timer.start();
		        re2 = new Rectangle(posX, posY, 64, 64);
		getImage();
	}
	
	public void getImage() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/cars/car_red_5.png"));
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}
	
	public void update() {
		 if(go) {
	            posY++; 
	            if (posY > rt.getHeight()) {
	                posY = -0;
	            }
	            re2.setBounds(posX, posY, 64, 64);
	        }
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(Color.white);
		g.drawImage(img, posX, posY, rt.title, rt.title, null);
	}

}
