package player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.swing.JPanel;

import course.Control;
import course.Route;
import course.TileMap;
import objects.Piece;

public class Player1 extends JPanel {
	
	BufferedImage img, img2, img3, img4;
	
	String voiture = "ale";
	int x = 408;
	int y = 476;
	int speed = 4;
	
	Clip clip;
	
	int spriteCounter = 0;
	int spriteNum = 1;
	int spriteSpeed = 10;
	Route rt;
	Control ct;
	public Rectangle re;
	
	private boolean collision = false;
	private boolean collision1 = false;
	private boolean collision2 = false;
	private boolean collision3 = false;
	private boolean collision4 = false;
	private boolean collision5 = false;
	private boolean collision6 = false;
	private boolean collision7 = false;
	//---------------
	private boolean collision8 = false;
	private boolean collision9 = false;
	private boolean collision10 = false;
	private boolean collision11 = false;
	private boolean collision12 = false;
	private boolean collision13 = false;
	private boolean collision14 = false;
	private boolean collision15 = false;
	//--------
	
	private boolean piece = false;
	
	
	TileMap tl;
	
	public Player1(Route rt, Control ct) {
		
		this.rt = rt;
		this.ct = ct;
		re = new Rectangle(x, y, 60, 60);
		tl = new TileMap(rt);
		image();
		
	}
	
	public void image() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/cars/car_blue_1.png"));
			rt.collisionOn = true;
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
			if(ct.up == true || ct.down == true || ct.left == true || ct.right == true) {
				if(ct.up) {
					voiture = "ale";
					y -= speed;
					
				}
				else if(ct.down) {
					voiture = "desann";
					y += speed;
					
				}
				else if(ct.left) {
					voiture = "goch";
					x -= speed;
					
				}
				else if(ct.right) {
					voiture = "dwat";
					x += speed;
					
				}
				
			}
			//Instruction pour que Player1 ne depasse pas la longueur de l'interface
			if(y < 0) {
				y = 0;// ne depasse pas la limite superieur
			} else if(y > rt.longueur - rt.title) {
				y = rt.longueur - rt.title;// ne depasse pas la limite superieur
			}
			//instruction pour que Player1 ne depasse pas la largeur de l'interface
			if(x < 0) {
				x = 0;
			} else if(x > rt.largeur - rt.title) {
				x = rt.largeur - rt.title;
				
			}
			
			
			collisionOn();
//Alors la dans ma methode update(), chaque fois que Player1 entre en collision avec une tuile. je remets a jour sa position en l'avancant d'une tuile en arriere.
			//c'est que ca donne un effet de barrage quand il entre en collision, qu'on voit qu'il bouge, mais tout en restant en place(l'image se redessine a chaque col;ision dans la nouvelle position de x et y.
			if(collision) {
				x = 68;
				y = 0;
			}
			
			if(collision1) {
				x = 68;
				y = 68;
			}
			
			if(collision2) {
				x = 68;
				y = 136;
			}
			
			if(collision3) {
				x = 68;
				y = 204;
			}
			
			if(collision4) {
				x = 68;
				y = 272;
			}
			
			if(collision5) {
				x = 68;
				y = 340;
			}
			
			if(collision6) {
				x = 68;
				y = 408;
			}
			
			if(collision7) {
				x = 68;
				y = 476;
			}
			//------------------
			
			if(collision8) {
				x = 680;
				y = 0;
			}
			
			if(collision9) {
				x = 680;
				y = 68;
			}
			
			if(collision10) {
				x = 680;
				y = 136;
			}
			
			if(collision11) {
				x = 680;
				y = 204;
			}
			
			if(collision12) {
				x = 680;
				y = 272;
			}
			
			if(collision13) {
				x = 680;
				y = 340;
			}
			
			if(collision14) {
				x = 680;
				y = 408;
			}
			
			if(collision15) {
				x = 680;
				y = 476;
			}
			
			
			
			//rt.collision(thi);
			re.setBounds(x, y, 60, 60);
			

			spriteCounter++;
			if(spriteCounter >= spriteSpeed) {
				spriteNum ++;
				
				if(voiture.equals("ale") && spriteNum > 1) {
					spriteNum = 1;
				}
				else if(voiture.equals("desann")  && spriteNum > 1) {
					spriteNum = 1;
				}
				else if(voiture.equals("goch")  && spriteNum > 1) {
					spriteNum = 1;
				}
				else if(voiture.equals("dwat")  && spriteNum > 1) {
					spriteNum = 1;
				}
				spriteCounter = 0;
		      }
		}
	
	//J'ai creee cette methode de collision en prenant compte des position de chaque tuile dont Player1 pourra entrer en colision avec.
	public void collisionOn() {
		collision = false;
		if(re.intersects(tl.rect)) {
			collision = true;
			 try {
		            // Charger et jouer le son de la pièce
		            File audioSrc = new File("song/audio/pneu.wav");
		            AudioInputStream ais = AudioSystem.getAudioInputStream(audioSrc);
		            Clip clipPneu = AudioSystem.getClip();
		            clipPneu.open(ais);
		            clipPneu.start();

		            // Arrêter le son après sa lecture
		            clipPneu.addLineListener(event -> {
		                if (event.getType() == LineEvent.Type.STOP) {
		                    clipPneu.close();
		                }
		            });

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			
		
		}
		collision1 = false;
		if(re.intersects(tl.rect1)) {
			collision1 = true;
			
		}
		collision2 = false;
		if(re.intersects(tl.rect2)) {
			collision2 = true;
			
		}
		collision3 = false;
		if(re.intersects(tl.rect3)) {
			collision3 = true;
			
		}
		collision4 = false;
		if(re.intersects(tl.rect4)) {
			collision4 = true;
			
		}
		collision5 = false;
		if(re.intersects(tl.rect5)) {
			collision5 = true;
			
		}
		collision6 = false;
		if(re.intersects(tl.rect6)) {
			collision6 = true;
			
		}
		collision7 = false;
		if(re.intersects(tl.rect7)) {
			collision7 = true;
			
		}
		//-----------------------------
		collision8 = false;
		if(re.intersects(tl.rect8)) {
			collision8 = true;
			
			
		}
		collision9 = false;
		if(re.intersects(tl.rect9)) {
			collision9 = true;
			
		}
		collision10 = false;
		if(re.intersects(tl.rect10)) {
			collision10 = true;
			
		}
		collision11 = false;
		if(re.intersects(tl.rect11)) {
			collision11 = true;
			
		}
		collision12 = false;
		if(re.intersects(tl.rect12)) {
			collision12 = true;
			
		}
		collision13 = false;
		if(re.intersects(tl.rect13)) {
			collision13 = true;
			
		}
		collision14 = false;
		if(re.intersects(tl.rect14)) {
			collision14 = true;
			
		}
		collision15 = false;
		if(re.intersects(tl.rect15)) {
			collision15 = true;
			
		}
					
	}
	
	
	
	public void draw(Graphics2D g) {
		//super.paintComponent(g);
        BufferedImage imga = null;
		
		if(voiture.equals("ale")) {
			if(spriteNum == 1) {
				imga = img;
			}
		}
		else if(voiture.equals("desann")) {
			if(spriteNum == 1) {
				imga = img;
			}
		}
		else if(voiture.equals("goch")) {
			if(spriteNum == 1) {
				imga = img;
			}
		}
		else if(voiture.equals("dwat")) {
			if(spriteNum == 1) {
				imga = img;
			}
		}
		
        g.setColor(Color.white);
		
		g.drawImage(imga, x, y, rt.title, rt.title, null);
		
	}


}
