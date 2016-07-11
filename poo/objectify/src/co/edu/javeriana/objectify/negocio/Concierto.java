package co.edu.javeriana.objectify.negocio;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Representa un concierto de un artista determinado incluyendo el lugar en el que se celebrara.
 * @author Javier Morales
 *
 */
public class Concierto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static long CONSECUTIVO = 0;
	
	private long id;
	private String escenario;
	private String ciudad;
	private String pais;
	private List<Artista> artistas;
	private ZonedDateTime fechaYHora;
	
	public Concierto(String escenario, String ciudad, String pais, ZonedDateTime fechaYHora) {
		// El id se genera usando el consecutivo
		CONSECUTIVO++;
		this.id = CONSECUTIVO;
		this.escenario = escenario;
		this.ciudad = ciudad;
		this.pais = pais;
		this.setFechaYHora(fechaYHora);
		this.artistas = new ArrayList<Artista>();
	}
	
	public String getEscenario() {
		return escenario;
	}
	public void setEscenario(String escenario) {
		this.escenario = escenario;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Collection<Artista> getArtistas() {
		return new ArrayList<Artista>(this.artistas);
	}
	public long getId() {
		return id;
	}
	public ZonedDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(ZonedDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public void agregarArtista(Artista artista) {
		this.artistas.add(artista);
		artista.notificarSeguidoresConcierto(this);
	}	
}
