package co.edu.javeriana.objectify.negocio;

/**
 * Representa una cancion como parte de un album en el sistema
 * @author Javier Morales
 *
 */
public class Cancion {
	
	private String nombre;
	/**
	 * Duracion de la cancion en segundos
	 */
	private int duracion;
	private long reproducciones;
	private String rutaArchivo;	
	private Album album;
	
	public Cancion(Album album, String nombre, int duracion, long reproducciones, String rutaArchivo) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.reproducciones = reproducciones;
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
	public void setReproducciones(long reproducciones) {
		this.reproducciones = reproducciones;
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
		
}