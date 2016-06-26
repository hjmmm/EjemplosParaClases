package co.edu.javeriana.objectify.negocio;

public class Album {
	
	private String titulo;
	private String caratula;
	private boolean exclusivo;
	
	public Album(String titulo, String caratula, boolean exclusivo) {
		this.titulo = titulo;
		this.caratula = caratula;
		this.exclusivo = exclusivo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public boolean isExclusivo() {
		return exclusivo;
	}

	public void setExclusivo(boolean exclusivo) {
		this.exclusivo = exclusivo;
	}	
	
}
