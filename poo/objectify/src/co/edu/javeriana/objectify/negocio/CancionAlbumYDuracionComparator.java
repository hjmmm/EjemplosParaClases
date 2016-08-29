package co.edu.javeriana.objectify.negocio;

import java.util.Comparator;

public class CancionAlbumYDuracionComparator implements Comparator<Cancion> {

	@Override
	public int compare(Cancion cancion1, Cancion cancion2) {
		int compararAlbum = cancion1.getAlbum().compareTo(cancion2.getAlbum());
		// Si los albumes son iguales, compare duraciones
		if (compararAlbum == 0) {
			// Si la duración de la primera es menor, pongala antes
			if (cancion1.getDuracion() < cancion2.getDuracion()) {
				return -1;
			}
			// Si es mayor, debe ir despues 
			if (cancion1.getDuracion() > cancion2.getDuracion()) {
				return 1;
			}
			// Si son iguales, se retorna 0 para indicar este hecho
			return 0;
		}
		return compararAlbum;
	}
	
	

}
