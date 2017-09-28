package rugby;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Font;

public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (ancho/2) - (450/2); 
		int y = (alto/2) - (300/2);
		setBounds(x, y, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JLabel label = new JLabel(" ");
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setIcon(new ImageIcon(Ayuda.class.getResource("/img/helpblue2.png")));
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("  ");
			contentPanel.add(label);
		}
		{
			JLabel lblReglas = new JLabel("Reglas");
			lblReglas.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblReglas.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblReglas.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblReglas);
		}
		{
			JLabel lblHkjhkjjkshjkdhsk = new JLabel("Cada Jugador debe hacer anotaciones");
			lblHkjhkjjkshjkdhsk.setIcon(new ImageIcon(Ayuda.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
			lblHkjhkjjkshjkdhsk.setAlignmentX(Component.CENTER_ALIGNMENT);
			contentPanel.add(lblHkjhkjjkshjkdhsk);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
