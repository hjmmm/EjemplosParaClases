package co.edu.javeriana.objectify.presentacion.gui;

import javax.swing.JPanel;

import co.edu.javeriana.objectify.negocio.Album;
import co.edu.javeriana.objectify.negocio.Artista;
import co.edu.javeriana.objectify.negocio.Cancion;
import co.edu.javeriana.objectify.negocio.Objectify;
import co.edu.javeriana.objectify.negocio.Reproductor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAlbum extends JPanel {
	
	private Album album;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelAlbum(Album album) {
		this.album = album;		
		setLayout(new BorderLayout(0, 0));		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[104px][][][][][][][][][][][]", "[17px]"));
		
		JLabel lblNombre = new JLabel(album.getTitulo());
		panel.add(lblNombre, "cell 0 0,growx,aligny top");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);		
		
		JButton btnAgregarTodo = new JButton("Agregar todo");
		btnAgregarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reproductor.obtenerInstancia().agregarACola(album);
			}
		});
		panel.add(btnAgregarTodo, "cell 11 0,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Object nombreColumnas[] = {"Cancion", "Duracion"};
		Object canciones[] = this.album.getCanciones().toArray();
		DefaultTableModel modelo = new DefaultTableModel(nombreColumnas, this.album.getCanciones().size()){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) { return false; }
			@Override
			public Object getValueAt(int row, int column) {
				Cancion cancion  = (Cancion)canciones[row];
				switch(column) {
					case 0:
						return cancion.getNombre();
					case 1:
						return cancion.getDuracion();
				}
				return "";
			}
		};
		
		table.setModel(modelo);
		

	}

}
