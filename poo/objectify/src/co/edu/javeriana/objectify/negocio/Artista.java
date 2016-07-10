package co.edu.javeriana.objectify.negocio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Representa un artista en el sistema junto con sus albumes
 * @author Javier Morales
 *
 */
public class Artista {
	
	private static long CONSECUTIVO = 0;
	
	private long id;
	private String nombre;
	private String descripcion;
	private Set<Genero> generos;
	private Set<Usuario> seguidores;
	private Map<String, Album> albumes;
	
	public Artista(String nombre, String descripcion, Collection<Genero> generos) {
		// El id se genera usando el consecutivo
		CONSECUTIVO++;
		this.id = CONSECUTIVO;		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.seguidores = new HashSet<Usuario>();
		this.albumes = new HashMap<String, Album>();

		// Para evitar que clases extrernas tengan referencias al estado interno del objeto copiamos la lista de generos
		this.generos = new HashSet<Genero>(generos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public Collection<Genero> getGeneros() {
		// No retornamos directamente la collecion para evitar que otras clases tengan referencias al estado interno
		return new HashSet<Genero>(this.generos);
	}

	public void agregarSeguidor(Usuario usuario) {
		this.seguidores.add(usuario);
	}

	public void quitarSeguidor(Usuario seguidor) {
		this.seguidores.remove(seguidor);
	}

	public void agregarAlbum(String titulo, String caratula, boolean exclusivo) {
		Album album = new Album(this, titulo, caratula, exclusivo);
		this.albumes.put(titulo, album);
		// Envie una notificacion de albúm nuevo a cada uno de los usuarios que siguen al artista
		for(Usuario usuario : this.seguidores) {
			usuario.recibirNotificacion(new NotificacionAlbum(album));
		}
	}

	public void agregarCancion(String tituloAlbum, String nombre, int duracion, String rutaArchivo) {
		Album album = this.albumes.get(tituloAlbum);
		album.agregarCancion(nombre, duracion, rutaArchivo);		
	}

	public void notificarSeguidoresConcierto(Concierto concierto) {
		// Envie una notificacion del concierto a cada uno de los usuarios que siguen al artista
		for(Usuario usuario : this.seguidores) {
			usuario.recibirNotificacion(new NotificacionConcierto(concierto));
		}
	}

	public Cancion buscarCancion(String nombreAlbum, int posicionCancion) {
		Album album = this.albumes.get(nombreAlbum);
		return album.buscarCancion(posicionCancion);
	}

	@Override
	public String toString() {
		return "\nArtista [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", generos=" + generos
				+ ", seguidores=" + seguidores + ", albumes=" + albumes + "]";
	}	
	
}
