package co.edu.javeriana.objectify.negocio;

import java.net.URL;

public class ReproduccionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private URL ruta; 
	
	public ReproduccionException(Exception causa, URL rutaArchivo) {
		super(causa);
		this.ruta = rutaArchivo;
	}
	
	public String toString() {
		return "Problema cargando archivo para reproducir en ruta: " + ruta
				+ super.toString();
	}
	
	public URL getRuta(){
		return ruta;
	}

}
