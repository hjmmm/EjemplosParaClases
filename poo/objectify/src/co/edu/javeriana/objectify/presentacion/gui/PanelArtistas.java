package co.edu.javeriana.objectify.presentacion.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import co.edu.javeriana.objectify.negocio.Album;
import co.edu.javeriana.objectify.negocio.Artista;
import co.edu.javeriana.objectify.negocio.Objectify;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelArtistas extends JPanel implements IPanelObjectify {

	private static final long serialVersionUID = 1L;

	private Objectify negocio;
	private JComboBox<Artista> cmbArtistas;
	private JScrollPane pnlScroll;
	private JPanel pnlAlbumes;
	
	public void setNegocio(Objectify negocio) {
		this.negocio = negocio;
	}		

	/**
	 * Create the panel.
	 */
	public PanelArtistas(Objectify negocio) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				refrescar();
			}
		});
		this.negocio = negocio;
		setName("Artistas");
		
		setLayout(new BorderLayout(20, 15));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Artistas");
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Artista:");
		panel_1.add(lblNewLabel_1);
		
		cmbArtistas = new JComboBox<Artista>();
		cmbArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrescarTablas(cmbArtistas.getModel().getSelectedItem());
			}
		});
		panel_1.add(cmbArtistas);
		
		pnlScroll = new JScrollPane();
		add(pnlScroll, BorderLayout.CENTER);
		
		pnlAlbumes = new JPanel();
		pnlScroll.setViewportView(pnlAlbumes);
		pnlAlbumes.setLayout(new BoxLayout(pnlAlbumes, BoxLayout.Y_AXIS));

	}
	
	@Override
	public void refrescar() {		
		DefaultComboBoxModel<Artista> modeloArtistas = new DefaultComboBoxModel<Artista>();
		this.negocio.getArtistas().forEach(a -> modeloArtistas.addElement(a));
		this.cmbArtistas.setModel(modeloArtistas);
		refrescarTablas(cmbArtistas.getModel().getSelectedItem());
	}
	
	private void refrescarTablas(Object seleccion){
		this.pnlAlbumes.removeAll();
		Artista artista = (Artista)seleccion;
		if (seleccion != null) {
			for(Album album : artista.getAlbumes()) {
				PanelAlbum pnlAlbum = new PanelAlbum(album);
				this.pnlAlbumes.add(pnlAlbum);
			}
		}
	}

}
