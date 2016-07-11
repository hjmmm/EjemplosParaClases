package co.edu.javeriana.objectify.negocio;

public class NotificacionConcierto implements INotificacion {

	private static final long serialVersionUID = 1L;

	private Concierto concierto;
	
	public NotificacionConcierto(Concierto concierto) {
		this.concierto = concierto;
	}

	@Override
	public String obtenerMensaje() {
		return String.format("Hay un concierto de %s en %s. Fecha: %3tF", this.concierto.getArtistas(), this.concierto.getCiudad(), this.concierto.getFechaYHora());
	}

}
