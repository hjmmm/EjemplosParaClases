package co.edu.javeriana.objectify.negocio;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPago extends Usuario {

	private static final long serialVersionUID = 1L;
	
	public static final float COSTO_SUSCRIPCION_MES = 11000; 

	private ZonedDateTime vencimientoSuscripcion;
	private List<Cancion> favoritas;
	private final float valorPagado;
	
	public UsuarioPago(String nombre, ZonedDateTime vencimientoSuscripcion) {
		super(nombre);
		this.vencimientoSuscripcion = vencimientoSuscripcion;
		this.favoritas = new ArrayList<Cancion>();
		this.valorPagado = COSTO_SUSCRIPCION_MES;
	}

	public UsuarioPago(String nombre, ZonedDateTime vencimientoSuscripcion, float descuento) {
		super(nombre);
		this.vencimientoSuscripcion = vencimientoSuscripcion;
		this.favoritas = new ArrayList<Cancion>();
		this.valorPagado = COSTO_SUSCRIPCION_MES - COSTO_SUSCRIPCION_MES * descuento;
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

	@Override
	public String toString() {
		return super.toString() + String.format(" Vencimiento: %tF", vencimientoSuscripcion);
	}

	public float getValorPagado() {
		return valorPagado;
	}	

}
