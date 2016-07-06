package co.edu.javeriana.objectify.negocio;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Clase fachada para el sistema de música. Permite el CRUD de usuarios, artistas, albumes,
 * canciones y conciertos entre otros. 
 * @author Javier Morales
 *
 */
public class Objectify {
	
	private Map<Long, Artista> artistas;
	private Map<Long, Concierto> conciertos;
	private Map<Long, Usuario> usuarios;
	
	public Objectify() {
		this.artistas = new HashMap<Long, Artista>();
		this.conciertos = new HashMap<Long, Concierto>();
		this.usuarios = new HashMap<Long, Usuario>();
	}	
	
	/**
	 * Crea un nuevo usuario en el sistema, si el usuario es pago la fecha de vencimiento de la 
	 * suscripcion es un año a partir de la fecha actual. 
	 * @param nombre
	 * @param pago
	 * @return Retorna el id del usuario creado
	 */
	public long agregarUsuario(String nombre, boolean pago) {
		Usuario usuario;
		if (pago) {
			usuario = new UsuarioPago(nombre, ZonedDateTime.now().plusYears(1));
		} else {
			usuario = new UsuarioBasico(nombre);
		}
		this.usuarios.put(usuario.getId(), usuario);
		return usuario.getId();
	}
	

	/**
	 * Crea un nuevo artista en el sistema y retorna el id del mismo.
	 * @param nombre
	 * @param descripcion
	 * @param generos
	 * @return Retorna el id del artista creado
	 */
	public long agregarArtista(String nombre, String descripcion, Collection<Genero> generos) {
		Artista artista = new Artista(nombre, descripcion, generos);
		this.artistas.put(artista.getId(), artista);
		return artista.getId();
	}
	
	/**
	 * Crea un nuevo album y lo agrega al artista con el id especificado. Adicionalmente notifica a todos los 
	 * usuarios que siguen al artista que el nuevo albúm esta disponible.
	 * @param idArtista
	 * @param titulo
	 * @param caratula
	 * @param exclusivo
	 */
	public void agregarAlbum(long idArtista, String titulo, String caratula, boolean exclusivo) {
		Artista artista = this.artistas.get(idArtista);
		artista.agregarAlbum(titulo, caratula, exclusivo);
	}
	
	/**
	 * Agrega una nueva cancion al albúm del artista especificado por idArtista.
	 * @param idArtista
	 * @param tituloAlbum
	 * @param nombre
	 * @param duracion
	 * @param rutaArchivo
	 */
	public void agregarCancion(long idArtista, String tituloAlbum, String nombre, int duracion, String rutaArchivo) {
		Artista artista = this.artistas.get(idArtista);
		artista.agregarCancion(tituloAlbum, nombre, duracion, rutaArchivo);
	}
	
	/**
	 * Agrega un concierto, sin artistas asignados, y lo añade a la lista de conciertos disponibles
	 * @param escenario
	 * @param ciudad
	 * @param pais
	 * @param fechaYHora
	 * @return Retorna el id del concierto creado
	 */
	public long agregarConcierto(String escenario, String ciudad, String pais, ZonedDateTime fechaYHora) {		
		Concierto concierto = new Concierto(escenario, ciudad, pais, fechaYHora);
		return concierto.getId();
	}
	
	
	/**
	 * Agrega un artista a un concierto y notifica a cada uno de los seguidores del artista del mismo.
	 * @param idConcierto
	 * @param idArtista
	 */
	public void agregarArtistaConcierto(long idConcierto, long idArtista) {
		Artista artista = this.artistas.get(idArtista);
		Concierto concierto = this.conciertos.get(idConcierto);
		// Agregar un artista a un concierto le permite al concierto notificar a los seguidores por medio del artista 
		concierto.agregarArtista(artista);
	}
	
	/**
	 * Agrega un usuario como seguidor de un artista
	 * @param idArtista
	 * @param idUsuario
	 */
	public void seguirArtista(long idArtista, long idUsuario) {
		Artista artista = this.artistas.get(idArtista);
		Usuario usuario = this.usuarios.get(idUsuario);
		usuario.seguirArtista(artista);
	}

	/**
	 * Remueve un usuario como seguidor de un artista
	 * @param idArtista
	 * @param idUsuario
	 */
	public void dejarDeSeguirArtista(long idArtista, long idUsuario) {
		Artista artista = this.artistas.get(idArtista);
		Usuario usuario = this.usuarios.get(idUsuario);
		usuario.dejarDeSeguirArtista(artista);
	} 
	
	/**
	 * Busca entre todos los artistas en el sistema los que tienen un nombre o 
	 * descripción que contenga la palabra ignorando mayusculas y minusculas.
	 * @param palabra
	 * @return Artistas con la palabra a buscar o una coleccion vacia 
	 */
	public Collection<Artista> buscarArtistasPorAproximacion(String palabra) {
		Set<Artista> resultado = new HashSet<Artista>();
		palabra = palabra.toLowerCase().trim();
		for (Artista artista : this.artistas.values()){
			// Nombres de artistas
			if (artista.getNombre().toLowerCase().contains(palabra) ||
				artista.getDescripcion().toLowerCase().contains(palabra)) {
				resultado.add(artista);
			}			
		}
		return resultado;
	}
	
	/**
	 * Verifica que el usuario sea un usuario pago y en caso de serlo, y que su suscripcion 
	 * se encuentre vigente, agrega la cancion correspondiente a la lista de favoritos  
	 * @param idUsuario
	 * @param idArtista
	 * @param posicionCancion
	 */
	public void agregarFavoritoUsuario(long idUsuario, long idArtista, String nombreAlbum, int posicionCancion) {
		Usuario usuario = this.usuarios.get(idUsuario);
		Artista artista = this.artistas.get(idArtista);
		if (usuario instanceof UsuarioPago) {
			UsuarioPago uPago = (UsuarioPago)usuario;
			uPago.agregarFavorita(artista.buscarCancion(nombreAlbum, posicionCancion));
		}
	}

}



