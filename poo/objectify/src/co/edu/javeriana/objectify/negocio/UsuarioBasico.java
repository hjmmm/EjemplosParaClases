package co.edu.javeriana.objectify.negocio;

public class UsuarioBasico extends Usuario {

	public UsuarioBasico(String nombre) {
		super(nombre);
	}

	@Override
	public boolean puedeEscucharAlbum(Album album) {
		return !album.isExclusivo();
	}

}
