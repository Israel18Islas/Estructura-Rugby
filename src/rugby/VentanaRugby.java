package rugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javax.swing.JFileChooser;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
		int x = (ancho/2) - (550/2); 
		int y = (alto/2) - (700/2);
		setBounds(x, y, 700, 500);
		JDialog.setDefaultLookAndFeelDecorated(true); //Decora las ventanas interactivas
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/like.png")));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/open.png")));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/lock.png")));
		mnArchivo.add(mntmGuardar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/facebook.png")));
		mnAyuda.add(mntmAcercaDe);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
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
		
		JLabel lblMensajes = new JLabel("");
		lblMensajes.setEnabled(false);
		panelBotones.add(lblMensajes);
		
		JPanel panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new CardLayout(0, 0));
		
		Silbato pnlPresentacion = new Silbato();
		panelJuego.add(pnlPresentacion, "Silbato");
		
		Cancha pnlCancha = new Cancha();
		panelJuego.add(pnlCancha, "Cancha");

		Pausa pnlPausa = new Pausa();
		panelJuego.add(pnlPausa, "Pausa");
		
		/*Acciones*/
		
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutMe about = new AboutMe();
				about.setVisible(true);
				CardLayout c = (CardLayout) panelJuego.getLayout();
				c.next(panelJuego);
				c.show(panelJuego, "Pausa");
			}
		});
		
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*CardLayout c = (CardLayout) panelJuego.getLayout();
				c.next(panelJuego);
				c.show(panelJuego, "Pausa");*/
				Ayuda help = new Ayuda();
				help.setVisible(true);
			}
		});
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				btnPlay.setFocusable(true);
				btnPause.setFocusable(false);
				pnlCancha.setFocusable(true);
			
				if(pnlPresentacion.isVisible()) {
					c.next(panelJuego);
					c.show(panelJuego, "Cancha");
					btnPlay.setEnabled(false);
					btnPause.setEnabled(true);
					pnlCancha.actualizar(0, 0);
				}
				else if(pnlCancha.isVisible()){
					btnPlay.setEnabled(false);
					btnPause.setEnabled(true);
					lblMensajes.setVisible(false);
					
					
				}
				else if(pnlPausa.isVisible()) {
					c.next(panelJuego);
					c.show(panelJuego, "Cancha");
					btnPlay.setEnabled(false);
					btnPause.setEnabled(true);
					lblMensajes.setVisible(false);
					
				}
				
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlCancha.isVisible()) {
					lblMensajes.setVisible(true);
					lblMensajes.setEnabled(true);
					lblMensajes.setText("Juego en Pausa. " );
					btnPlay.setEnabled(true);
					btnPause.setEnabled(false);	
					
					CardLayout c = (CardLayout) panelJuego.getLayout();
					c.next(panelJuego);
					c.show(panelJuego, "Pausa");
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "No hay nada que pausar! ", "Pausar Juego", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		/*Implementar que se desactiven los botones en la pantalla de inicio*/
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				if(pnlCancha.isVisible() || pnlPausa.isVisible()) {
					int reply = JOptionPane.showConfirmDialog(contentPane, "Deseas guardar la partida actual?", "Guardar Partida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						if(reply == JOptionPane.YES_OPTION){	//Valida que si guardas la partida, le asignes un nombre
							JFileChooser seleccion = new JFileChooser();
							int code = seleccion.showSaveDialog(contentPane);
							if(code == JFileChooser.APPROVE_OPTION) {
								try {
									FileOutputStream file = new FileOutputStream(seleccion.getSelectedFile());
									ObjectOutputStream oos = new ObjectOutputStream(file);
									oos.writeObject(pnlCancha);
									file.close();
									oos.close();
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								JOptionPane.showMessageDialog(contentPane, "Tu partida se ha con exito! ");
								c.next(panelJuego);
								c.show(panelJuego, "Silbato");
								btnPlay.setEnabled(true);
								btnPause.setEnabled(true);
							}
						}
						/*se regresa al inicio*/
						else if(reply == JOptionPane.NO_OPTION) {
							c.next(panelJuego);
							c.show(panelJuego, "Silbato");
							btnPlay.setEnabled(true);
							btnPause.setEnabled(true);
							
						}
						else if(reply == JOptionPane.CANCEL_OPTION) {
							/*si cancelas, el programa no se cierra*/
						}
						else if(reply == JOptionPane.CLOSED_OPTION) {
							
						}
					}else
					JOptionPane.showMessageDialog(contentPane, "No has empezado a jugar!");
				
			}
		});
		
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser seleccion = new JFileChooser(); //Objeto para guardar
				JFileChooser abrir = new JFileChooser();	//Objeto para abrir
				int code;	//Variable para guardar
				int open = 0;	//Variable para abir
				if(pnlCancha.isVisible() || pnlPausa.isVisible()) {
					int reply = JOptionPane.showConfirmDialog(contentPane, "Deseas guardar la partida actual?", "Guardar Partida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						if(reply == JOptionPane.YES_OPTION){	//Valida que si guardas la partida, le asignes un nombre
							code = seleccion.showSaveDialog(contentPane);
							if(code == JFileChooser.APPROVE_OPTION) {
								try {
									FileOutputStream file = new FileOutputStream(seleccion.getSelectedFile());
									ObjectOutputStream oos = new ObjectOutputStream(file);
									oos.writeObject(pnlCancha);
									file.close();
									oos.close();
								} catch (FileNotFoundException e1) {
									//TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(contentPane, "Tu partida se ha guardado con exito! ");
								open = abrir.showOpenDialog(contentPane);
								if(open == JFileChooser.APPROVE_OPTION) {
									try {
										FileInputStream archivo = new FileInputStream(abrir.getSelectedFile()); 
										ObjectInputStream ois = new ObjectInputStream(archivo);
										ois.readObject();
									}catch (FileNotFoundException e1) {
										//TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								else if(open == JFileChooser.CANCEL_OPTION) {
									/*El programa no abre nada*/
								}
							}
							else if(code == JFileChooser.CANCEL_OPTION) {
								/*Esta opcion valida que si cancelas el guardar, el programa no se cierra*/
							}
						}
						else if(reply == JOptionPane.NO_OPTION) { 	//Si decides no guardar, se dirige abrir el la partida
							open = abrir.showOpenDialog(contentPane);
							if(open == JFileChooser.APPROVE_OPTION) {
								try {
									FileInputStream archivo = new FileInputStream(abrir.getSelectedFile()); 
									ObjectInputStream ois = new ObjectInputStream(archivo);
									ois.readObject();
								}catch (FileNotFoundException e1) {
									//TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if(open == JFileChooser.CANCEL_OPTION) {
								/*El programa no abre nada*/
							}
						}
						else if(reply == JOptionPane.CANCEL_OPTION) {
							/*Esta opcion valida que si cancelas salir, el programa no abre nada ni se cierra*/
						}
						else if(reply == JOptionPane.CLOSED_OPTION) {
							
						}
				}
				else {
					//Esto valida que si estas en el inicio, abres directamente la partida
					open = abrir.showOpenDialog(contentPane);
					if(open == JFileChooser.APPROVE_OPTION) {
						try {
							FileInputStream archivo = new FileInputStream(abrir.getSelectedFile()); 
							ObjectInputStream ois = new ObjectInputStream(archivo);
							ois.readObject();
						}catch (FileNotFoundException e1) {
							//TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(open == JFileChooser.CANCEL_OPTION) {
						/*El programa no abre nada*/
					}
				}
		}
		});
		
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pnlCancha.isVisible() || pnlPausa.isVisible()) {
						JFileChooser seleccion = new JFileChooser();
						int code = seleccion.showSaveDialog(contentPane);
						if(code == JFileChooser.APPROVE_OPTION) {
							try {
								FileOutputStream file = new FileOutputStream(seleccion.getSelectedFile());
								ObjectOutputStream oos = new ObjectOutputStream(file);
								oos.writeObject(pnlCancha);
								file.close();
								oos.close();
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(contentPane, "Tu partida se ha guardado correctamente! ");
						}
						else if(code == JFileChooser.CANCEL_OPTION) {
							/*Esta opcion valida que si cancelas el guardar, el programa no se cierra*/
						}	
				}else
					JOptionPane.showMessageDialog(contentPane, "No has iniciado un partido!");
			}
		});
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(VentanaRugby.class.getResource("/img/dislike.png")));
		mnArchivo.add(mntmSalir);
		
		//implementar que pregunte primero si quiere salir y despues si quiere guardar
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply;
				if(pnlCancha.isVisible() || pnlPausa.isVisible()) {
					reply = JOptionPane.showConfirmDialog(contentPane, "Deseas guardar la partida actual?", "Guardar Partida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						if(reply == JOptionPane.YES_OPTION){	//Valida que si guardas la partida, le asignes un nombre
							JFileChooser seleccion = new JFileChooser();
							int code = seleccion.showSaveDialog(contentPane);
							if(code == JFileChooser.APPROVE_OPTION) {
								try {
									FileOutputStream file = new FileOutputStream(seleccion.getSelectedFile());
									ObjectOutputStream oos = new ObjectOutputStream(file);
									oos.writeObject(pnlCancha);
									file.close();
									oos.close();
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(contentPane, "Tu partida se ha guardado con exito!\nHasta Luego.");
								System.exit(0);
							}
							else if(code == JFileChooser.CANCEL_OPTION) {
								/*Esta opcion valida que si cancelas el guardar, el programa no se cierra*/
							}
						}
						else if(reply == JOptionPane.NO_OPTION) {
							System.exit(0); /*Si decides no guardar, el programa se cierra*/
						}
						else if(reply == JOptionPane.CANCEL_OPTION) {
							/*Esta opcion valida que si cancelas salir, el programa no se cierra*/
						}
						else if(reply == JOptionPane.CLOSED_OPTION) {
							
						}
				}
				/*Si esta en la primer pantalla no guarda nada, se termina de todos modos
				 *  pero primero pregunta si quiere salirse del juego */
				else {	
					int salir = JOptionPane.showConfirmDialog(contentPane, "Estas seguro que quieres salir del juego? ", "Salir del Juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(salir == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					else{
						//Se queda en el juego
					}
				}
			}
		});
	}
}
