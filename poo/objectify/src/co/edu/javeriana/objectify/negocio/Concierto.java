package co.edu.javeriana.objectify.negocio;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa un concierto de un artista determinado incluyendo el lugar en el que se celebrara.
 * @author Javier Morales
 *
 */
public class Concierto {
	
	private static long CONSECUTIVO = 0;
	
	private long id;
	private String escenario;
	private String ciudad;
	private String pais;
	private Artista artista;
	private ZonedDateTime fechaYHora;
	
	public Concierto(String escenario, String ciudad, String pais, Artista artista, ZonedDateTime fechaYHora) {
		// El id se genera usando el consecutivo
		CONSECUTIVO++;
		this.id = CONSECUTIVO;
		this.escenario = escenario;
		this.ciudad = ciudad;
		this.pais = pais;
		this.artista = artista;
		this.setFechaYHora(fechaYHora);
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
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
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
	
}
