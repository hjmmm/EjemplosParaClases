package co.edu.javeriana.objectify.negocio;

import java.io.Serializable;

/**
 * Representa una cancion como parte de un album en el sistema
 * @author Javier Morales
 *
 */
public class Cancion implements Serializable, Comparable<Cancion> {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	/**
	 * Duracion de la cancion en segundos
	 */
	private int duracion;
	private long reproducciones;
	private String rutaArchivo;	
	private Album album;
	
	public Cancion(Album album, String nombre, int duracion, String rutaArchivo) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.reproducciones = 0;
		this.rutaArchivo = rutaArchivo;
		this.setAlbum(album);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public long getReproducciones() {
		return reproducciones;
	}
	public void aumentarReproducciones() {
		this.reproducciones++;
	}
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "\n\t\tCancion [nombre=" + nombre + ", duracion=" + duracion + ", reproducciones=" + reproducciones
				+ ", rutaArchivo=" + rutaArchivo + "]";
	}

	@Override
	public int compareTo(Cancion o) {
		return this.nombre.compareTo(o.nombre);
	}
		
}
