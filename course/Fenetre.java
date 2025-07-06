package course;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame {
	//Les menus du jeu.
	JMenu partie = new JMenu("MENU"),
			regle = new JMenu("RÈGLE"),
			propos = new JMenu("?");
	
	JMenuItem nouv = new JMenuItem("Nouvelle partie"),
			savoir = new JMenuItem("Comment fonctionne le jeu ?"),
			apropos = new JMenuItem("À propos"),
			quitter = new JMenuItem("Sortir du jeu");
	
	JMenuBar bar = new JMenuBar();
	
	public Fenetre() {
		this.setTitle("Piece Runner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//Ajout des JMenuItem dans les JMenu qui leurs sont destinee.
		this.partie.add(nouv);
		this.partie.add(quitter);
		this.regle.add(savoir);
		this.propos.add(apropos);
		//--------
		//Ajout des actions qui doivent etre fait quand on clique sur les boutons des menus items.
		this.quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("src/out.png");
				int option = jop.showConfirmDialog(null, "Voulez-vous sortir du jeu ?", "À plus !", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, img);
				
				if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				}
			}
		});
		this.nouv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fenetre();
			}
		});
		this.savoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("src/read.png");
				String mess = "Bienvenue dans Piece Runner, l'objectif du jeu est de recolter le maximun de pieces possible.";
				mess += "\n Déplacez vous à l'aide des contrôleurs, évitez les voitures, et dirigez vous vers la gauche, droite, le haut ou le bas.";
				mess += "\n Les touches à maintenir pour les deplacements sont : A(pour allez à gauche), W(pour aller en haut, D(pour aller à droite) et S(pour aller en bas).";
				jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE, img);
			}
		});
		
		this.apropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("src/eti.png");
				String mess = "Bienvenue dans Piece Runner, je suis Dimitri MATHIEU, son concepteur.";
				mess += " Ce dernier est entièrement réalisé en Java.";
				mess += "\n Tous droits réservés Ⓒ 2025 Dimitri Mathieu";
				jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE, img);
			}
		});
		//------------
		this.bar.add(partie);
		this.bar.add(regle);
		this.bar.add(propos);
		this.setJMenuBar(bar);
		//-------------
		Route rt = new Route();
		this.add(rt);
		this.pack();
		
		this.setLocationRelativeTo(null);
		//Lancement du jeu via la methode lets_go();
		rt.lets_go();
		this.setVisible(true);
	}
	//Lancement de notre fenetre.
	public static void main(String[] args) {
		new Fenetre();
		
	}

}
