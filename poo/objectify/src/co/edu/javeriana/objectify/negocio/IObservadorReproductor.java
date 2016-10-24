package co.edu.javeriana.objectify.negocio;

public interface IObservadorReproductor {
	/**
	 * Método invocado cuando el ususario del reproductor es actualizado.
	 * Si el usuario cierra sesión el parámetro es null.
	 * @param nuevoUsuario Nuevo usuario. Puede ser null en caso de un cierre de sesión.
	 */
	void onUsuarioCambiado(Usuario nuevoUsuario);
	/**
	 * Método invocado cuando la canción que se reproduce cambia. 
	 * La nuevaCanon puede ser null si se acaba la lista de reproducción o el usuario usa la opción de stop.
	 * @param nuevaCancion
	 */
	void onCancionCambiada(Cancion nuevaCancion);
}
