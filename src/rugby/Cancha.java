package rugby;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import deporte.Silbato;

public class Cancha extends JPanel {

	public String Porterias;
	public String Balon;
	public int x = 0;	//coordenada X
	public int y = 0;	//coordenada Y

	public String getPorterias() {
		return this.Porterias;
	}

	public void setPorterias(String Porterias) {
		this.Porterias = Porterias;
	}

	public String getBalon() {
		return this.Balon;
	}

	public void setBalon(String Balon) {
		this.Balon = Balon;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public Cancha() {

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagen=new ImageIcon(Silbato.class.getResource("/img/rugby.gif")).getImage();
		int x=getWidth()/2 - imagen.getWidth(this)/2;
		int y=getHeight()/2 - imagen.getHeight(this)/2;
		g.drawImage(imagen, x, y, this);

	}
}
