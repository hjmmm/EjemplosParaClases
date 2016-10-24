package co.edu.javeriana.objectify.presentacion.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class FrameAcercaDe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameAcercaDe() {
		setTitle("Acerca de...");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 516, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea lblObjectifyEsUn = new JTextArea("Objectify es un proyecto gratuito creado para explicar Programaci\u00F3n Orientada a objetos. Pretende ser un clon de algunas funcionalidades de Spotify.\r\nAutor: Javier Morales\r\n\r\nSe provee bajo The MIT License (MIT)\r\nCopyright (c) 2016 Javier Morales\r\n\r\nPara obtener el c\u00F3digo fuente visite:\r\nhttps://github.com/hjmmm/EjemplosParaClases/");
		lblObjectifyEsUn.setEditable(false);
		lblObjectifyEsUn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObjectifyEsUn.setWrapStyleWord(true);
		lblObjectifyEsUn.setLineWrap(true);
		lblObjectifyEsUn.setTabSize(3);
		lblObjectifyEsUn.setRows(10);
		contentPane.add(lblObjectifyEsUn, BorderLayout.CENTER);
	}

}
