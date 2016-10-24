package co.edu.javeriana.objectify.presentacion.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import co.edu.javeriana.objectify.negocio.Cancion;
import co.edu.javeriana.objectify.negocio.IObservadorReproductor;
import co.edu.javeriana.objectify.negocio.ReproduccionException;
import co.edu.javeriana.objectify.negocio.Reproductor;
import co.edu.javeriana.objectify.negocio.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelReproductor extends JPanel implements IObservadorReproductor {

	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario;
	private JLabel lblCaratula;
	private JLabel lblCancion;
	private JLabel lblAlbum;
	private JLabel lblArtista;
	private JButton btnPause;

	/**
	 * Create the panel.
	 */
	public PanelReproductor() {
		setName("Reproductor");
		
		// Registrar este panel como observador del reproductor
		Reproductor.obtenerInstancia().agregarObservador(this);
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout(20, 20));
		
		lblCaratula = new JLabel("");
		add(lblCaratula, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[136px][]", "[41px][22px][22px][][]"));
		
		lblCancion = new JLabel("");
		lblCancion.setFont(new Font("Tahoma", Font.BOLD, 34));
		panel.add(lblCancion, "cell 0 0,growx,aligny center");
		
		lblAlbum = new JLabel("");
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblAlbum, "cell 0 1,alignx left,aligny center");
		
		lblArtista = new JLabel("");
		lblArtista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblArtista, "cell 0 2,alignx left,aligny center");
		
		lblUsuario = new JLabel("-");
		panel.add(lblUsuario, "cell 0 4");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reproductor.obtenerInstancia().reproducir();
				} catch (ReproduccionException e1) {
					JOptionPane.showMessageDialog(getParent(), "Se encontro un error al reproducir:\n"+e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reproductor.obtenerInstancia().siguiente();
				} catch (ReproduccionException e1) {
					JOptionPane.showMessageDialog(getParent(), "Se encontro un error al reproducir:\n"+e1, "Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		
		btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Reproductor.obtenerInstancia().pausar();
			}
		});
		panel_1.add(btnPause);
		panel_1.add(btnNewButton_1);

	}

	@Override
	public void onUsuarioCambiado(Usuario nuevoUsuario) {
		if (nuevoUsuario != null) {
			this.lblUsuario.setText("Usuario: " + nuevoUsuario);
		} else {
			this.lblUsuario.setText("-");
		}
	}

	@Override
	public void onCancionCambiada(Cancion nueva) {
		if (nueva != null) {
			this.lblAlbum.setText(nueva.getAlbum().getTitulo());
			this.lblArtista.setText(nueva.getAlbum().getArtista().getNombre());
			this.lblCancion.setText(nueva.getNombre());
		} else {
			this.lblAlbum.setText("");
			this.lblArtista.setText("");
			this.lblCancion.setText("");			
		}
	}

}
