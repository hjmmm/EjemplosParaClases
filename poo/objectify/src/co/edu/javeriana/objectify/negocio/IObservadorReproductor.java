package co.edu.javeriana.objectify.negocio;

public interface IObservadorReproductor {
	/**
	 * M�todo invocado cuando el ususario del reproductor es actualizado.
	 * Si el usuario cierra sesi�n el par�metro es null.
	 * @param nuevoUsuario Nuevo usuario. Puede ser null en caso de un cierre de sesi�n.
	 */
	void onUsuarioCambiado(Usuario nuevoUsuario);
	/**
	 * M�todo invocado cuando la canci�n que se reproduce cambia. 
	 * La nuevaCanon puede ser null si se acaba la lista de reproducci�n o el usuario usa la opci�n de stop.
	 * @param nuevaCancion
	 */
	void onCancionCambiada(Cancion nuevaCancion);
}
