package co.edu.javeriana.objectify.negocio;

/**
 * Generos disponibles en el sistema. Se usa una enumeracion a manera de ejemplo, en un 
 * sistema de producción seria deseable que los generos pudieran crearse a voluntad
 * de los administradores de la aplicación.
 * Descripciones tomadas de Wikipedia.
 *  
 * @author Javier Morales
 *
 */
public enum Genero {	
	ROCK("Rock", "El rock es un término amplio que agrupa a una variedad de géneros musicales.1 Su forma originaria, conocida como rock and roll, surgió mayormente de la combinación de dos géneros anteriores como eran el rhythm and blues y el country. La música rock también se nutrió fuertemente del blues y el folk, e incorporó influencias del jazz, la música clásica y otras fuentes."),
	JAZZ("Jazz", "El jazz es un género musical nacido a finales del siglo XIX en Estados Unidos, que se expandió de forma global a lo largo de todo el siglo XX."),
	BLUES("Blues", "El blues (cuyo significado es melancolía o tristeza) es un género musical vocal e instrumental, basado en la utilización de notas de blues y de un patrón repetitivo, que suele seguir una estructura de doce compases."),
	CLASSICAL("Música clasica", "La música clásica es la corriente musical que comprende principalmente la música producida o basada en las tradiciones de la música litúrgica y secular de Occidente, principalmente Europa Occidental."),
	POP("Música Pop", "La música pop (del inglés pop music, contracción de popular music) es un género de música popular que tuvo su origen a finales de los años 1950 como una derivación del rock and roll, en combinación con otros géneros musicales que estaban de moda en aquel momento."),
	METAL("Metal", "El heavy metal, o simplemente metal1 2 3 —en español traducido literalmente como «metal pesado»— , es un género musical que nació a mediados de los sesenta y principios de los setenta en el Reino Unido y en los Estados Unidos, cuyos orígenes provienen del blues rock, hard rock y del rock psicodélico."),
	LATINA("Música Latina", "La música de América Latina, también llamada música latinoamericana, música latina o “ritmos latinos”, es la música cultivada en los países de América Latina.");
	
	private String nombre;
	private String descripcion;
	
	Genero(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
}
