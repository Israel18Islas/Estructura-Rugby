package rugby;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Silbato extends JPanel {

	/**
	 * Create the panel.
	 */
	public Silbato() {

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagen=new ImageIcon(Silbato.class.getResource("/img/rugbystart.png")).getImage();
		int x=getWidth()/2 - imagen.getWidth(this)/2;
		int y=getHeight()/2 - imagen.getHeight(this)/2;
		g.drawImage(imagen, x, y, this);
		
		g.setColor(Color.BLUE);
		FontMetrics font = g.getFontMetrics();
		int anchoCadena = font.stringWidth("Juego");
		int xCadena = getWidth()/2 - anchoCadena/2;
		int yCadena = getHeight()/2 + imagen.getHeight(this)/2+20;
		g.drawString("Juego", xCadena, yCadena);
	}
}
