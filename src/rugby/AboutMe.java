package rugby;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class AboutMe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutMe dialog = new AboutMe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutMe(){
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (ancho/2) - (450/2); 
		int y = (alto/2) - (300/2);
		setBounds(x, y, 550, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblUniversidadAutonoma = new JLabel("Universidad Autonoma de Baja California");
			lblUniversidadAutonoma.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			lblUniversidadAutonoma.setHorizontalAlignment(SwingConstants.CENTER);
			lblUniversidadAutonoma.setIcon(new ImageIcon(AboutMe.class.getResource("/img/uabc.png")));
			contentPanel.add(lblUniversidadAutonoma, BorderLayout.NORTH);
		}
		{
			JLabel label = new JLabel("       ");
			label.setIcon(new ImageIcon(AboutMe.class.getResource("/img/snoopy.png")));
			contentPanel.add(label, BorderLayout.EAST);
		}
		{
			JPanel panelDatos = new JPanel();
			contentPanel.add(panelDatos, BorderLayout.CENTER);
			panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
			{
				JLabel label = new JLabel("             ");
				panelDatos.add(label);
				label.setFont(new Font("Tahoma", Font.PLAIN, 24));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setIcon(null);
			}
			{
				JLabel lblNewLabel = new JLabel("Tomas Israel Islas Jimenez");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panelDatos.add(lblNewLabel);
				lblNewLabel.setIcon(null);
			}
			{
				JLabel lblTomasislasuabcedumx = new JLabel("tomas.islas@uabc.edu.mx");
				lblTomasislasuabcedumx.setHorizontalAlignment(SwingConstants.CENTER);
				panelDatos.add(lblTomasislasuabcedumx);
			}
			{
				JLabel lblIngEnComputacion = new JLabel("Ing. en Computacion");
				lblIngEnComputacion.setHorizontalAlignment(SwingConstants.CENTER);
				panelDatos.add(lblIngEnComputacion);
			}
			{
				JLabel lbltomasislasjr = new JLabel("/tomas.islas.jr");
				lbltomasislasjr.setHorizontalAlignment(SwingConstants.CENTER);
				panelDatos.add(lbltomasislasjr);
				lbltomasislasjr.setIcon(new ImageIcon(AboutMe.class.getResource("/img/facebook.png")));
			}
		}
		{
			JPanel panelAuxiliar = new JPanel();
			contentPanel.add(panelAuxiliar, BorderLayout.WEST);
			panelAuxiliar.setLayout(new BoxLayout(panelAuxiliar, BoxLayout.Y_AXIS));
			{
				JLabel label = new JLabel("                       ");
				label.setFont(new Font("Tahoma", Font.PLAIN, 24));
				panelAuxiliar.add(label);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("Aceptar");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
					}
				});
				btnOk.setActionCommand("Cancel");
				buttonPane.add(btnOk);
			}
		}
	}

}
