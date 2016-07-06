package co.edu.javeriana.objectify.negocio;

import java.util.LinkedList;
import java.util.Queue;

public class Reproductor {
	
	private static Reproductor instancia;	
	private Queue<Cancion> colaReproduccion; 
	
	private Reproductor() {
		colaReproduccion = new LinkedList<Cancion>();
	}
	
	public static Reproductor obtenerInstancia() {
		if (instancia == null) {
			instancia = new Reproductor();
		}
		return instancia;
	}
	
	public void agregarACola(Cancion cancion) {
		colaReproduccion.add(cancion);		
	}

	public void limpiarCola() {
		// Se acabo el papel higienico, por suerte no lo necesitamos
		this.colaReproduccion.clear();
	}
	
	public void reproducir() {
		
	}
	
	public void pausar() {
		
	}
	
}
