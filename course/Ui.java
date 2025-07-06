package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

public class Ui {
	Route rt;
	public String message = " : $";
	Font arial_40;
	BufferedImage img;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	

	
	public Ui(Route rt) {
		this.rt = rt;
		arial_40 = new Font("Arial", Font.PLAIN, 30);
		piece();
		
	}
	public void piece() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/objet/piece.png"));
			
		}catch(IOException e) {
			e.printStackTrace();		}
	}
	
	public void draw(Graphics2D g) {
		if(rt.th != null) {
			g.setFont(arial_40);
			g.setColor(Color.yellow);
			g.drawImage(img,17, 28, 30, 30, null);
			g.drawString(message + rt.hasPie, rt.title/2, 50);
			
			//TIME
			playTime +=(double)1/60;
			g.drawString(""+dFormat.format(playTime), 748, 38);
		}else {
			g.setFont(arial_40);
			g.setColor(Color.yellow);
			g.drawImage(img,17, 28, 30, 30, null);
			g.drawString(message + rt.hasPie, rt.title/2, 50);
			
			//TIME
			Font f = new Font("Arial", Font.BOLD, 29);
			
			g.setColor(Color.white);
			g.fillRect(300, 100, 190, 40);
			
			g.setColor(Color.black);
			playTime +=(double)1/60;
			g.drawString("Score : "+dFormat.format(playTime), 300, 134);
			
		}
		
	}


}

