package co.edu.javeriana.objectify.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Representa un album creado por un artista y el conjunto de canciones que lo componen
 * @author Javier Morales
 *
 */
public class Album {
	
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

	@Override
	public String toString() {
		return "\n\tAlbum [titulo=" + titulo + ", caratula=" + caratula + ", exclusivo=" + exclusivo + ", canciones=" + canciones + "]";
	}
	
}
