package co.edu.javeriana.objectify.negocio;

import java.util.Collection;
import java.util.HashSet;
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
	
	public Artista(String nombre, String descripcion, Collection<Genero> generos) {
		// El id se genera usando el consecutivo
		CONSECUTIVO++;
		this.id = CONSECUTIVO;		
		this.nombre = nombre;
		this.descripcion = descripcion;

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
	
}
