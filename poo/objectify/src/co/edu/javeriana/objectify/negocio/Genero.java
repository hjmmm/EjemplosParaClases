package co.edu.javeriana.objectify.negocio;

/**
 * Generos disponibles en el sistema. Se usa una enumeracion a manera de ejemplo, en un 
 * sistema de producci�n seria deseable que los generos pudieran crearse a voluntad
 * de los administradores de la aplicaci�n.
 * Descripciones tomadas de Wikipedia.
 *  
 * @author Javier Morales
 *
 */
public enum Genero {	
	ROCK("Rock", "El rock es un t�rmino amplio que agrupa a una variedad de g�neros musicales.1 Su forma originaria, conocida como rock and roll, surgi� mayormente de la combinaci�n de dos g�neros anteriores como eran el rhythm and blues y el country. La m�sica rock tambi�n se nutri� fuertemente del blues y el folk, e incorpor� influencias del jazz, la m�sica cl�sica y otras fuentes."),
	JAZZ("Jazz", "El jazz es un g�nero musical nacido a finales del siglo XIX en Estados Unidos, que se expandi� de forma global a lo largo de todo el siglo XX."),
	BLUES("Blues", "El blues (cuyo significado es melancol�a o tristeza) es un g�nero musical vocal e instrumental, basado en la utilizaci�n de notas de blues y de un patr�n repetitivo, que suele seguir una estructura de doce compases."),
	CLASSICAL("M�sica clasica", "La m�sica cl�sica es la corriente musical que comprende principalmente la m�sica producida o basada en las tradiciones de la m�sica lit�rgica y secular de Occidente, principalmente Europa Occidental."),
	POP("M�sica Pop", "La m�sica pop (del ingl�s pop music, contracci�n de popular music) es un g�nero de m�sica popular que tuvo su origen a finales de los a�os 1950 como una derivaci�n del rock and roll, en combinaci�n con otros g�neros musicales que estaban de moda en aquel momento."),
	METAL("Metal", "El heavy metal, o simplemente metal1 2 3 �en espa�ol traducido literalmente como �metal pesado�� , es un g�nero musical que naci� a mediados de los sesenta y principios de los setenta en el Reino Unido y en los Estados Unidos, cuyos or�genes provienen del blues rock, hard rock y del rock psicod�lico."),
	LATINA("M�sica Latina", "La m�sica de Am�rica Latina, tambi�n llamada m�sica latinoamericana, m�sica latina o �ritmos latinos�, es la m�sica cultivada en los pa�ses de Am�rica Latina.");
	
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
