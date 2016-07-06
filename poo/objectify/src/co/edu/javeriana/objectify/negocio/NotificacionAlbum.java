package co.edu.javeriana.objectify.negocio;

public class NotificacionAlbum implements INotificacion {

	private Album album;
	
	public NotificacionAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String obtenerMensaje() {
		return String.format("El album %s de %s esta disponible.", this.album.getTitulo(), this.album.getArtista().getNombre());
	}

}
