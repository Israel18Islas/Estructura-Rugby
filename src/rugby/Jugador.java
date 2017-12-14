package rugby;

import java.awt.event.KeyEvent;

public class Jugador extends Persona {

	public int Numero;
	private String Posicion;
	private int x;
	private int y;
	
	public Jugador(int i, int j) {
		
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNumero() {
		return this.Numero;
	}

	public void setNumero(int Numero) {
		this.Numero = Numero;
	}

	public String getPosicion() {
		return this.Posicion;
	}

	public void setPosicion(String Posicion) {
		this.Posicion = Posicion;
	}

	private void Correr() {
		// TODO - implement Jugador.Correr
		throw new UnsupportedOperationException();
	}

	private void Taclear() {
		// TODO - implement Jugador.Taclear
		throw new UnsupportedOperationException();
	}

	private void Pasarla() {
		// TODO - implement Jugador.Pasarla
		throw new UnsupportedOperationException();
	}

	public int HacerAnotacion() {
		// TODO - implement Jugador.HacerAnotacion
		throw new UnsupportedOperationException();
	}
	
	public Jugador mover(int code) {
		if(code==KeyEvent.VK_LEFT) {
			setX(getX()-5);
		}
		else if(code==KeyEvent.VK_RIGHT) {
			setX(getX()+5);
		}
		else if(code==KeyEvent.VK_UP) {
			setY(getY()-5);
		}
		else if(code==KeyEvent.VK_DOWN) {
			setY(getY()+5);
		}
			return this;
	}
	public void pausar() {
		
	}

}