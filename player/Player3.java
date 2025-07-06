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

public class Player3 extends JPanel {
	
	int x = 136;
	int y = -0;
	BufferedImage img;
	private Route rt;
	boolean demarrer = true;
	public Rectangle re3;
	
	public Player3(Route rt) {
		this.rt = rt;
		Timer timer = new Timer(14, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.start(); //C'est pour que mon composant se redessine via un timer
		re3 = new Rectangle(x, y, 64, 64);
		getImage();
	}
	
	public void getImage() {
		try {
			
			img = ImageIO.read(getClass().getResourceAsStream("/cars/car_green_4.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(this.demarrer) {
			y++;
			if(y > rt.getHeight()) {//Si le composant depasse la hauteur de notre panel, on le reinitialise a sa valeur d'origine
				y = -0;
			}
			re3.setBounds(x, y, 64, 64);
		}
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.drawImage(img, x, y, rt.title, rt.title, null);
	}

}
