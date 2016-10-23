package co.edu.javeriana.objectify.presentacion.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class PanelReproductor extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelReproductor() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout(20, 20));
		
		JLabel lblCaratula = new JLabel("Caratula");
		add(lblCaratula, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblCancion = new JLabel("Cancion");
		lblCancion.setFont(new Font("Tahoma", Font.BOLD, 34));
		panel.add(lblCancion);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblAlbum);
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblArtista);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Play");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		panel_1.add(btnNewButton_1);

	}

}
