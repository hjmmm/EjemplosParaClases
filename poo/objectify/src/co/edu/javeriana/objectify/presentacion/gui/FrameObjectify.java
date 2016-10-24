package co.edu.javeriana.objectify.presentacion.gui;

import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import co.edu.javeriana.objectify.archivos.ManejadorArchivos;
import co.edu.javeriana.objectify.negocio.Objectify;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FrameObjectify extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Objectify objectify;

	/**
	 * Create the frame.
	 */
	public FrameObjectify() {
			
		final JFrame esteFrame = this;
		this.objectify = new Objectify();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCargarArtistas = new JMenuItem("Cargar artistas...");
		mntmCargarArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Crear el FileChooser en la ruta actual
					JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
					// Establecer el tipo de archivos que queremos permitir
			        FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo JSON Artistas", "json"); 
			        chooser.setFileFilter(filtroDeArchivos);
			        chooser.setAcceptAllFileFilterUsed(false);
					// Abrir el FileChooser y capturar el resultado
					int resultado = chooser.showOpenDialog(esteFrame);
					// Verificar el resultado
					if (resultado == JFileChooser.APPROVE_OPTION) {
						// Invocar el método adecuado de ManejadorArchivos
						int artistasCargados = ManejadorArchivos.cargarArchivoArtistas(objectify, chooser.getSelectedFile());
						// Y presentar el resultado al usuario
						JOptionPane.showMessageDialog(esteFrame, artistasCargados + " artista(s) cargados.");
					}
				} catch (Exception exp) {
					// Si ocurre un error, reportarlo al usuario 
					JOptionPane.showMessageDialog(esteFrame, "Error cargando artistas:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
					// Y no sobra imprimir el stackTrace
					exp.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmCargarArtistas);
		
		JMenuItem mntmCargarUsuarios = new JMenuItem("Cargar usuarios...");
		mntmCargarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Crear el FileChooser en la ruta actual
					JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
					// Establecer el tipo de archivos que queremos permitir
			        FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo Usuarios", "txt"); 
			        chooser.setFileFilter(filtroDeArchivos);
			        chooser.setAcceptAllFileFilterUsed(false);
					// Abrir el FileChooser y capturar el resultado
					int resultado = chooser.showOpenDialog(esteFrame);
					// Verificar el resultado
					if (resultado == JFileChooser.APPROVE_OPTION) {
						// Invocar el método adecuado de ManejadorArchivos
						int usuariosCargados = ManejadorArchivos.cargarArchivoUsuarios(objectify, chooser.getSelectedFile());
						// Y presentar el resultado al usuario
						JOptionPane.showMessageDialog(esteFrame, usuariosCargados + " usuario(s) cargados.");
					}
				} catch (Exception exp) {
					// Si ocurre un error, reportarlo al usuario 
					JOptionPane.showMessageDialog(esteFrame, "Error cargando usuarios:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
					// Y no sobra imprimir el stackTrace
					exp.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmCargarUsuarios);
		
		JMenuItem mntmCargarTodo = new JMenuItem("Cargar todo...");
		mntmCargarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Crear el FileChooser en la ruta actual
					JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
					// Establecer el tipo de archivos que queremos permitir
			        FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo Objectify", "obj"); 
			        chooser.setFileFilter(filtroDeArchivos);
			        chooser.setAcceptAllFileFilterUsed(false);
					// Abrir el FileChooser y capturar el resultado
					int resultado = chooser.showOpenDialog(esteFrame);
					// Verificar el resultado
					if (resultado == JFileChooser.APPROVE_OPTION) {
						// Invocar el método adecuado de ManejadorArchivos
						objectify = ManejadorArchivos.DesserializarObjectify(chooser.getSelectedFile());
						// Y presentar el resultado al usuario
						JOptionPane.showMessageDialog(esteFrame, "Sistema cargado correctamente.");
					}
				} catch (Exception exp) {
					// Si ocurre un error, reportarlo al usuario 
					JOptionPane.showMessageDialog(esteFrame, "Error cargando el sistema:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
					// Y no sobra imprimir el stackTrace
					exp.printStackTrace();
				}
			}
		});				
		mnArchivo.add(mntmCargarTodo);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Guardar todo...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Crear el FileChooser en la ruta actual
					JFileChooser chooser = new JFileChooser(new File(".").getCanonicalPath());
					// Establecer el tipo de archivos que queremos permitir
			        FileFilter filtroDeArchivos = new FileNameExtensionFilter("Archivo Objectify", "obj"); 
			        chooser.setFileFilter(filtroDeArchivos);
			        chooser.setAcceptAllFileFilterUsed(false);
					// Abrir el FileChooser y capturar el resultado
					int resultado = chooser.showSaveDialog(esteFrame);
					// Verificar el resultado
					if (resultado == JFileChooser.APPROVE_OPTION) {
						// Invocar el método adecuado de ManejadorArchivos
						ManejadorArchivos.SerializarObjectify(objectify, chooser.getSelectedFile());
						// Y presentar el resultado al usuario
						JOptionPane.showMessageDialog(esteFrame, "Sistema guardado correctamente.");
					}
				} catch (Exception exp) {
					// Si ocurre un error, reportarlo al usuario 
					JOptionPane.showMessageDialog(esteFrame, "Error guardando el sistema:\n"+exp, "Error", JOptionPane.ERROR_MESSAGE);
					// Y no sobra imprimir el stackTrace
					exp.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmNewMenuItem);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = JOptionPane.showConfirmDialog(esteFrame, "¿Esta seguro de que quiere salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameAcercaDe().setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new PanelReproductor();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new PanelArtistas();
		contentPane.add(panel_1, BorderLayout.CENTER);
	}

}
