package co.edu.javeriana.objectify.presentacion;

import java.awt.EventQueue;

import co.edu.javeriana.objectify.presentacion.gui.FrameObjectify;

/**
 * Clase de uso del sistema de música usando una interfaz grafica.
 * @author Javier Morales
 *
 */
public class ObjectifyGUI {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameObjectify frame = new FrameObjectify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
