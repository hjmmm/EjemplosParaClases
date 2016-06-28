package co.edu.javeriana.objectify.negocio;

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
	
	public Album(Artista artista, String titulo, String caratula, boolean exclusivo) {
		this.titulo = titulo;
		this.caratula = caratula;
		this.exclusivo = exclusivo;
		this.setArtista(artista);
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
	
}
