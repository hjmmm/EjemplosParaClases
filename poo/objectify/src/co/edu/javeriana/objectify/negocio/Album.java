package co.edu.javeriana.objectify.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Representa un album creado por un artista y el conjunto de canciones que lo componen
 * @author Javier Morales
 *
 */
public class Album implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String titulo;
	private String caratula;
	private boolean exclusivo;
	private Artista artista;
	private List<Cancion> canciones;
	
	public Album(Artista artista, String titulo, String caratula, boolean exclusivo) {
		this.titulo = titulo;
		this.caratula = caratula;
		this.exclusivo = exclusivo;
		this.setArtista(artista);
		this.canciones = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public boolean isExclusivo() {
		return exclusivo;
	}

	public void setExclusivo(boolean exclusivo) {
		this.exclusivo = exclusivo;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public void agregarCancion(String nombre, int duracion, String rutaArchivo) {		
		Cancion cancion = new Cancion(this, nombre, duracion, rutaArchivo);
		this.canciones.add(cancion);
	}
	
	public Collection<Cancion> getCanciones() {
		return new ArrayList<>(this.canciones);
	}

	public Cancion buscarCancion(int posicionCancion) {
		return this.canciones.get(posicionCancion);
	}

	public Cancion buscarCancion(String nombreCancion) {
		for(Cancion cancion : this.canciones) {
			if (compararCadenasSimple(nombreCancion, cancion.getNombre())){
				return cancion;
			}
		}
		return null;
	}
	
	/**
	 * Método auxiliar para comparar cadenas sin tener en cuenta espacios al inicio y fin ni 
	 * hacer distincion entre mayusculas y minusculas. 
	 * Este método debería ser parte de una librería de funciones utilitarias o de la clase 
	 * canción. Esta aqui solo para mostrar crear un método privado auxiliar.     
	 * @param cadena1
	 * @param cadena2 
	 * @return true si las cadenas son iguales dentro de los parametros de la comparación
	 */
	private boolean compararCadenasSimple(String cadena1, String cadena2) {
		// Si cadena1 es null cadena2 debe serlo tambien para que sean iguales
		if (cadena1 == null) { return cadena2 == null; } 
		// Si en este punto cadena2 es null las cadenas no son iguales
		if (cadena2 == null) { return false; }
		// A ambas cadenas se le aplican las mismas operaciones
		cadena1 = cadena1.trim().toLowerCase();
		cadena2 = cadena2.trim().toLowerCase();
		// Finalmente retoramos el resultado de equals despues de simplificar las cadenas 
		return cadena1.equals(cadena2);
	}
	
	@Override
	public String toString() {
		return "\n\tAlbum [titulo=" + titulo + ", caratula=" + caratula + ", exclusivo=" + exclusivo + ", canciones=" + canciones + "]";
	}
	
}
