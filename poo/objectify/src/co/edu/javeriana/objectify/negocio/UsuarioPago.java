package co.edu.javeriana.objectify.negocio;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPago extends Usuario {

	private ZonedDateTime vencimientoSuscripcion;
	private List<Cancion> favoritas;
	
	public UsuarioPago(String nombre, ZonedDateTime vencimientoSuscripcion) {
		super(nombre);
		this.vencimientoSuscripcion = vencimientoSuscripcion;
		this.favoritas = new ArrayList<Cancion>();
	}
	
	public boolean suscripcionVigente(){
		return ZonedDateTime.now().isBefore(vencimientoSuscripcion);
	}	
	
	@Override
	public boolean puedeEscucharAlbum(Album album) {
		return !album.isExclusivo() || suscripcionVigente();
	}
	
	public void renovarSuscripcion() {
		this.vencimientoSuscripcion = this.vencimientoSuscripcion.plusYears(1);
	}

	public void agregarFavorita(Cancion cancion) {
		if (suscripcionVigente()) {
			this.favoritas.add(cancion);
		}
	}

}
