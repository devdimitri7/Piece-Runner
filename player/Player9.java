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

public class Player9 extends JPanel {
	
	BufferedImage img;
	Route rt;
	int x = 544;
	int y = -0;
	private boolean go = true;
	public Rectangle re9;
	
	public Player9(Route rt) {
		this.rt= rt;
		Timer time = new Timer(8, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		time.start();
		re9 = new Rectangle(x, y, 64, 64);
		getImage();
		
		}
	
	public void getImage() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/cars/car_green_1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(this.go) {
			y++;
			if(y > rt.getHeight()) {
				y = -0;
			}
			re9.setBounds(x, y, 64, 64);
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.drawImage(img, x, y, rt.title, rt.title, null);
	}

}
