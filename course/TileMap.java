package course;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileMap {
	
	Route rt;
	public Tile[] tile;
	public int mapTileNum[][];
	//les rectangles de collision des tuiles(image).
	public Rectangle rect;
	public Rectangle rect1;
	public Rectangle rect2;
	public Rectangle rect3;
	public Rectangle rect4;
	public Rectangle rect5;
	public Rectangle rect6;
	public Rectangle rect7;
	//-----------------------
	public Rectangle rect8;
	public Rectangle rect9;
	public Rectangle rect10;
	public Rectangle rect11;
	public Rectangle rect12;
	public Rectangle rect13;
	public Rectangle rect14;
	public Rectangle rect15;
	
	
	
	public TileMap(Route rt) {
		this.rt = rt;
		tile = new Tile[10];
		mapTileNum = new int[rt.col][rt.row];
		rect = new Rectangle(0, 0, rt.title, rt.title);
		rect1 = new Rectangle(0, 68, rt.title, rt.title);
		rect2 = new Rectangle(0, 136, rt.title, rt.title);
		rect3 = new Rectangle(0, 204, rt.title, rt.title);
		rect4 = new Rectangle(0, 272, rt.title, rt.title);
		rect5 = new Rectangle(0, 340, rt.title, rt.title);
		rect6 = new Rectangle(0, 408, rt.title, rt.title);
		rect7 = new Rectangle(0, 476, rt.title, rt.title);
		
		//---------------------
		rect8 = new Rectangle(748, 0, 68, rt.title);
		rect9 = new Rectangle(748, 68, rt.title, rt.title);
		rect10 = new Rectangle(748, 136, rt.title, rt.title);
		rect11 = new Rectangle(748, 204, rt.title, rt.title);
		rect12 = new Rectangle(748, 272, rt.title, rt.title);
		rect13 = new Rectangle(748, 340, rt.title, rt.title);
		rect14 = new Rectangle(748, 408, rt.title, rt.title);
		rect15 = new Rectangle(748, 476, rt.title, rt.title);
		
		
		
	
		getImage();
		loadmap("/maps/map01.txt");

	}
	
	public void getImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/maps/trackSVG.png"));
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/maps/arbre.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/maps/blok.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/maps/mer.png"));
			tile[3].collision = true;
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/maps/sab.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/maps/ve.png"));
			tile[5].collision = true;
			
						
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadmap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < rt.col && row < rt.row) {
				String line = br.readLine();
				
				while(col < rt.col) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == rt.col) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		//pour ajouter les tuiles ont addition les taille pour les place l'un apres l'autre en les metant en x et en y
		/*g.drawImage(tile[0].image, 0, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 68, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 136, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 204, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 272, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 340, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 408, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 476, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 544, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 612, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 680, 0, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 748, 0, rt.title, rt.title, null);
		
		//--------------------------------------------------------
		g.drawImage(tile[0].image, 0, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 68, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 136, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 204, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 272, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 340, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 408, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 476, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 544, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 612, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 680, 48, rt.title, rt.title, null);
		g.drawImage(tile[0].image, 748, 48, rt.title, rt.title, null); */
		
		//methode plus simple pour dessiner entierement le panneau.
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < rt.col && row < rt.row) {
			
			int tileNum = mapTileNum[col][row];
			
			g.drawImage(tile[tileNum].image, x, y, rt.title, rt.title, null);
			col++;
			x += rt.title;
			
			if(col == rt.col) {
				col = 0;
				x = 0;
				row++;
				y += rt.title;
			}
		}
	}

}
