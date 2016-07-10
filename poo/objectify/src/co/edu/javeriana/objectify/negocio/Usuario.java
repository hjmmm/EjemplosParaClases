package co.edu.javeriana.objectify.negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Usuario {
	
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
		artista.agregarSeguidor(this);
		this.artistasSeguidos.add(artista);
	}
	
	public void dejarDeSeguirArtista(Artista artista) {
		artista.quitarSeguidor(this);
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
		return "\n\tUsuario [id=" + id + ", nombre=" + nombre + ", notificaciones=" + notificaciones + "]";
	}

}
