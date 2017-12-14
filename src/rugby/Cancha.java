package rugby;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import deporte.Silbato;

public class Cancha extends JPanel implements CanchaInterfaz{

	private JLabel jugador;
	public String Porterias;
	public String Balon;
	public int x = 0;	//coordenada X
	public int y = 0;	//coordenada Y
	
	public Cancha() {
		setLayout(null);
		
		jugador = new JLabel();
		jugador.setIcon(new ImageIcon(Cancha.class.getResource("/img/player1.png")));
		jugador.setOpaque(true);
		jugador.setBounds(10, 10, 32, 32);
		add(jugador);
		
		ControladorJugador control = new ControladorJugador(this);
		addKeyListener(control);
		
	}

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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagen=new ImageIcon(Silbato.class.getResource("/img/TerrenoRugby.png")).getImage();
		int x=getWidth()/2 - imagen.getWidth(this)/2;
		int y=getHeight()/2 - imagen.getHeight(this)/2;
		g.drawImage(imagen, x, y, this);

	}

	@Override
	public int getJugadorX() {
		// TODO Auto-generated method stub
		return jugador.getX();
	}

	@Override
	public int getJugadorY() {
		// TODO Auto-generated method stub
		return jugador.getY();
	}

	@Override
	public void actualizar(int x, int y) {
		// TODO Auto-generated method stub
		jugador.setBounds(x, y, 30, 30);
	}
}
