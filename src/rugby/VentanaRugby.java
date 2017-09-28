package rugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import deporte.AboutDialog;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/dislike.png")));
		mnArchivo.add(mntmSalir);
		
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
	}

}
