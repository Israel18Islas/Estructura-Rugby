package rugby;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import rugby.Jugador;
import rugby.CanchaInterfaz;

public class ControladorJugador extends KeyAdapter{

	private Jugador jug;
	private CanchaInterfaz vista;
	
	public ControladorJugador(CanchaInterfaz vista) {
		this.vista=vista;
		jug = new Jugador(vista.getJugadorX(),vista.getJugadorY());
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		//System.out.println(e.getKeyText(code));
		jug=jug.mover(code);
		vista.actualizar(jug.getX(),jug.getY());
	}
}
