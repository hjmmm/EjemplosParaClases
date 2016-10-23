package co.edu.javeriana.objectify.presentacion.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelAgregarUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PanelAgregarUsuario() {
		setLayout(new BorderLayout(20, 15));
		
		JLabel lblNewLabel = new JLabel("Agregar Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_2.add(lblNombre, "cell 0 0,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setMinimumSize(new Dimension(200, 20));
		txtNombre.setPreferredSize(new Dimension(200, 20));
		panel_2.add(txtNombre, "cell 1 0");
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		panel_2.add(lblTipo, "cell 0 1,alignx trailing");
		
		JRadioButton rdbtnBasico = new JRadioButton("Basico");
		buttonGroup.add(rdbtnBasico);
		rdbtnBasico.setSelected(true);
		panel_2.add(rdbtnBasico, "flowx,cell 1 1");
		
		JRadioButton rdbtnPago = new JRadioButton("Pago");
		buttonGroup.add(rdbtnPago);
		panel_2.add(rdbtnPago, "cell 1 1");
		
		JButton btnGuardar = new JButton("Guardar");
		panel_2.add(btnGuardar, "cell 1 2");
		
	}

}
