package co.edu.javeriana.objectify.negocio;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproduccion {
	
	private String nombre;
	private List<Cancion> canciones;
	
	public ListaDeReproduccion(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList<Cancion>(); 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		return new ArrayList<Cancion>(canciones);
	}
	
	public void agregarCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}
	
	public void eliminarCancion(int posicion) {
		this.canciones.remove(posicion);
	}

}
