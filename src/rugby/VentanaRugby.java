package rugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import deporte.AboutDialog;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.CardLayout;

public class VentanaRugby extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRugby frame = new VentanaRugby();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRugby() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (ancho/2) - (450/2); 
		int y = (alto/2) - (300/2);
		setBounds(x, y, 550, 420);
		JDialog.setDefaultLookAndFeelDecorated(true); //Decora las ventanas interactivas
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/like.png")));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/lock.png")));
		mnArchivo.add(mntmGuardar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutMe about = new AboutMe();
				about.setVisible(true);
			}
		});
		mntmAcercaDe.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/facebook.png")));
		mnAyuda.add(mntmAcercaDe);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda help = new Ayuda();
				help.setVisible(true);
			}
		});
		
		mntmAyuda.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/help.png")));
		mnAyuda.add(mntmAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.NORTH);
		
		JButton btnPlay = new JButton("Play");
		panelBotones.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		panelBotones.add(btnPause);
		
		JPanel panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new CardLayout(0, 0));
		
		Silbato pnlPresentacion = new Silbato();
		panelJuego.add(pnlPresentacion, "Silbato");
		
		Cancha pnlCancha = new Cancha();
		panelJuego.add(pnlCancha, "Cancha");
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				c.next(panelJuego);
				c.show(panelJuego, "Cancha");
			}
		});
		
		/*Acciones*/
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlCancha.isVisible()) {
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "No hay nada que pausar! ", "Pausar Juego", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				int reply;
				String partida;
				if(pnlCancha.isVisible()) {
					reply = JOptionPane.showConfirmDialog(contentPane, "Deseas guardar la partida?", "Guardar Partida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						if(reply == JOptionPane.YES_OPTION){	//Valida que si guardas la partida, le asignes un nombre
							partida = JOptionPane.showInputDialog(contentPane, "Nombre de la partida: ", "Guardar Partida", JOptionPane.QUESTION_MESSAGE);
								if(partida == null) {	//Valida que si cancelas, la partida no se guarda
									c.next(panelJuego);
									c.show(panelJuego, "Cancha");
								}
								else if(partida.equals("")) {
									JOptionPane.showMessageDialog(contentPane, "No has introducido un nombre. \nNo se puede guardar la partida!", "ERROR", JOptionPane.ERROR_MESSAGE);
									c.next(panelJuego);
									c.show(panelJuego, "Cancha");
								}
								else {
									JOptionPane.showMessageDialog(contentPane, "Tu partida se ha guardado correctamente! ");
									c.next(panelJuego);
									c.show(panelJuego, "Silbato");
								}
						}
						else if(reply == JOptionPane.NO_OPTION) {
							c.next(panelJuego);
							c.show(panelJuego, "Silbato");
						}
						else if(reply == JOptionPane.CANCEL_OPTION) {
							
						}
						else if(reply == JOptionPane.CLOSED_OPTION) {
							
						}
					//Validar las opciones
				}else
					JOptionPane.showMessageDialog(contentPane, "No has empezado a jugar!");
			}
		});
		
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				String partida;
				if(pnlCancha.isVisible()) {
					partida = JOptionPane.showInputDialog(contentPane, "Nombre de la partida: ", "Guardar Partida", JOptionPane.QUESTION_MESSAGE);
					if(partida == null) {	//Valida que si cancelas, la partida no se guarda
						c.next(panelJuego);
						c.show(panelJuego, "Cancha");
					}
					else if(partida.equals("")) {
						JOptionPane.showMessageDialog(contentPane, "No has introducido un nombre. \nNo se puede guardar la partida!", "ERROR", JOptionPane.ERROR_MESSAGE);
						c.next(panelJuego);
						c.show(panelJuego, "Cancha");
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Tu partida se ha guardado correctamente! ");
					}
					/* Guardar la partida en un archivo*/
				}else
					JOptionPane.showMessageDialog(contentPane, "No has iniciado un partido!");
			}
		});
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/dislike.png")));
		mnArchivo.add(mntmSalir);
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				int reply;
				String partida;
				if(pnlCancha.isVisible()) {
					reply = JOptionPane.showConfirmDialog(contentPane, "Deseas guardar la partida?", "Guardar Partida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						if(reply == JOptionPane.YES_OPTION){	//Valida que si guardas la partida, le asignes un nombre
							partida = JOptionPane.showInputDialog(contentPane, "Nombre de la partida: ", "Guardar Partida", JOptionPane.QUESTION_MESSAGE);
								if(partida == null) {	//Valida que si cancelas, la partida no se guarda
									c.next(panelJuego);
									c.show(panelJuego, "Cancha");
								}
								else if(partida.equals("")) {
									JOptionPane.showMessageDialog(contentPane, "No has introducido un nombre. \nNo se puede guardar la partida!", "ERROR", JOptionPane.ERROR_MESSAGE);
									c.next(panelJuego);
									c.show(panelJuego, "Cancha");
								}
								else {
									JOptionPane.showMessageDialog(contentPane, "Tu partida se ha guardado correctamente! ");
									System.exit(0);
								}
						}
						else if(reply == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
						else if(reply == JOptionPane.CANCEL_OPTION) {
							
						}
						else if(reply == JOptionPane.CLOSED_OPTION) {
							
						}
					//Validar las opciones
			}
				else {	//Si esta en la primer pantalla, se termina de todos modos
					System.exit(0);
				}
			}
		});
	}

}
