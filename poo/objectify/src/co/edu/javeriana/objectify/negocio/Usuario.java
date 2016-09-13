package co.edu.javeriana.objectify.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static long CONSECUTIVO = 0;
	
	private long id;
	private String nombre;
	private Set<Artista> artistasSeguidos;
	private List<INotificacion> notificaciones;

	public Usuario(String nombre) {
		// El id se genera usando el consecutivo
		CONSECUTIVO++;
		this.id = CONSECUTIVO;
		this.setNombre(nombre);
		this.artistasSeguidos = new HashSet<Artista>();
		this.notificaciones = new ArrayList<INotificacion>();
	}
	
	public Usuario() {
		this("Desconocido");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}
	
	public void seguirArtista(Artista artista) {
		this.artistasSeguidos.add(artista);
	}
	
	public void dejarDeSeguirArtista(Artista artista) {
		this.artistasSeguidos.remove(artista);
	}
	
	public void recibirNotificacion(INotificacion notificacion) {
		this.notificaciones.add(notificacion);
	}
	
	public void borrarNotificaciones() {
		this.notificaciones.clear();
	}	
	
	public abstract boolean puedeEscucharAlbum(Album album);

	@Override
	public String toString() {
		return String.format("Id: %d \t Nombre: %s", id, nombre);
	}

}
