package co.edu.javeriana.objectify.negocio;

public class UsuarioBasico extends Usuario {

	private static final long serialVersionUID = 1L;

	public UsuarioBasico(String nombre) {
		super(nombre);
	}

	@Override
	public boolean puedeEscucharAlbum(Album album) {
		return !album.isExclusivo();
	}

}
