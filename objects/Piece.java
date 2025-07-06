package objects;

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


public class Piece extends JPanel {
	public BufferedImage img;
	int x = 134;
	int y = 68;
	int x1 = 208;
	int y1 = 134;
	int x2 = 408;
	int y2 = 208;
	int x3 = 476;
	int y3 = 68;
	int x4 = 272;
	int y4 = 208;
	public boolean piece = true;
	public Rectangle rectPie;
	public Rectangle rectPie2;
	public Rectangle rectPie3;
	public Rectangle rectPie4;
	public Rectangle rectPie5;
	Route rt;
	
	
	
	public Piece(Route rt) {
		this.rt = rt;
		Timer time = new Timer(9, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		time.start();
		rectPie = new Rectangle(x, y, 50, 50);
		rectPie2 = new Rectangle(x1, y1, 50, 50);
		rectPie3 = new Rectangle(x2, y2, 50, 50);
		rectPie4 = new Rectangle(x3, y3, 50, 50);
		rectPie5 = new Rectangle(x4, y4, 50, 50);
		resetPosition();
	
		getImage();
	}
	
	public void getImage() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/objet/coin.png")); 
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void resetPosition() {
        // Réinitialiser la position de la pièce à une nouvelle position aléatoire
        x = (int) (Math.random() * (748 - rt.title));
        y = (int) (Math.random() * (rt.longueur - rt.title));
        
        x1 = (int) (Math.random() * (748 - rt.title));
        y1 = (int) (Math.random() * (rt.longueur - rt.title));
        
        x2 = (int) (Math.random() * (748 - rt.title));
        y2 = (int) (Math.random() * (rt.longueur - rt.title));
        
        x3 = (int) (Math.random() * (748 - rt.title));
        y3 = (int) (Math.random() * (rt.longueur - rt.title));
        
        x4 = (int) (Math.random() * (748 - rt.title));
        y4 = (int) (Math.random() * (rt.longueur - rt.title));
        
        rectPie = new Rectangle(x, y, rt.title, rt.title);
        rectPie2 = new Rectangle(x1, y1, rt.title, rt.title);
        rectPie3 = new Rectangle(x2, y2, rt.title, rt.title);
        rectPie4 = new Rectangle(x3, y3, rt.title, rt.title);
        rectPie5 = new Rectangle(x4, y4, rt.title, rt.title);
        
    }
	
	public void update() {
		if(piece) {
			y ++;
			y1++;
			y2++;
			y3++;
			y4++;
			if(y > rt.getHeight() || y1 > rt.getHeight() || y2 > rt.getHeight() || y3 > rt.getHeight() || y4 > rt.getHeight()) {
				y = 68;
				y1 = 134;
				y2 = 208;
				y3 = 68;
				y4 = 208;
			}
			rectPie.setBounds(x, y, 50, 50);
			rectPie2.setBounds(x1, y1, 50, 50);
			rectPie3.setBounds(x2, y2, 50, 50);
			rectPie4.setBounds(x3, y3, 50, 50);
			rectPie5.setBounds(x4, y4, 50, 50);
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		if(img != null) {
			g.drawImage(img, x, y, 50, 50, null );
			g.drawImage(img, x1, y1, 50, 50, null);
			g.drawImage(img, x2, y2, 50, 50, null);
			g.drawImage(img, x3, y3, 50, 50, null);
			g.drawImage(img, x4, y4, 50, 50, null);
			
			
		}
		
	}
}
