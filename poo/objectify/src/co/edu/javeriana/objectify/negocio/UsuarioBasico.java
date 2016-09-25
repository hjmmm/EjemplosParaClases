package co.edu.javeriana.objectify.negocio;

public final class UsuarioBasico extends Usuario {

	private static final long serialVersionUID = 1L;

	public UsuarioBasico(String nombre) {
		super(nombre);
	}
	
	public UsuarioBasico() {}

	@Override
	public final boolean puedeEscucharAlbum(Album album) {
		return !album.isExclusivo();
	}

}
