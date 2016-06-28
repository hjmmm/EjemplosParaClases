package co.edu.javeriana.objectify.negocio;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase fachada para el sistema de música. Permite el CRUD de usuarios, artistas, albumes,
 * canciones y conciertos entre otros. 
 * @author Javier Morales
 *
 */
public class Objectify {
	
	private Map<Long, Artista> artistas;
	
	public Objectify() {
		this.artistas = new HashMap<Long, Artista>();
	}	

}
