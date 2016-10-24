package co.edu.javeriana.objectify.presentacion.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import co.edu.javeriana.objectify.negocio.Objectify;

public class PanelUsuarios extends JPanel implements IPanelObjectify {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Objectify negocio;
	
	public void setNegocio(Objectify negocio) {
		this.negocio = negocio;
	}

	/**
	 * Create the panel.
	 */
	public PanelUsuarios(Objectify negocio) {
		this.negocio = negocio;
		setName("Usuarios");
		setLayout(new BorderLayout(20, 15));
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Id", "Nombre", "Acciones" }));
		scrollPane.setViewportView(table);

	}

	@Override
	public void refrescar() {
		// TODO Auto-generated method stub
		
	}

}
