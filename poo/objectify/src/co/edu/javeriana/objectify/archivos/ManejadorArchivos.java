package co.edu.javeriana.objectify.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import co.edu.javeriana.objectify.negocio.Genero;
import co.edu.javeriana.objectify.negocio.Objectify;

public class ManejadorArchivos {
	
	/**
	 * Carga los usuarios del sistema desde un archivo de texto de acuerdo al siguiente formato:
	 * 
	 * 
	 * Los usuarios se ingresan en un archivo de texto con los siguientes campos en una linea por cada usuario separados por punto y coma.
	 * 
	 * Tipo de usuario (valores posibles: PAGO, NORMAL)
	 * Nombre
	 * Fecha de vencimiento suscripcion (formato: yyyy-mm-dd)
	 * 
	 * Todos los campos son obligatorios a pesar de que la fecha de vencimiento es ignorada para los usuarios normales.
	 * Todos los campos pueden tener una cantidad libre de espacios en blanco antes o despues de la información pertinente que son ignorados por el sistema en el momento de la carga.
	 * Todas las lineas que comienzan por # son ignoradas al igual que cualquier linea vacia o que contenga solo espacios o tabuladores.
	 * 
	 * @param negocio
	 * @param ruta
	 * @return Número de usuarios cargados al sistema
	 * @throws FileNotFoundException
	 */
	public static int cargarArchivoUsuarios(Objectify negocio, String ruta) throws FileNotFoundException{
		File archivo = new File(ruta);
		return cargarArchivoUsuarios(negocio, archivo);
	}
	
	/**
	 * Carga los usuarios del sistema desde un archivo de texto de acuerdo al siguiente formato:
	 * 
	 * 
	 * Los usuarios se ingresan en un archivo de texto con los siguientes campos en una linea por cada usuario separados por punto y coma.
	 * 
	 * Tipo de usuario (valores posibles: PAGO, NORMAL)
	 * Nombre
	 * Fecha de vencimiento suscripcion (formato: yyyy-mm-dd)
	 * 
	 * Todos los campos son obligatorios a pesar de que la fecha de vencimiento es ignorada para los usuarios normales.
	 * Todos los campos pueden tener una cantidad libre de espacios en blanco antes o despues de la información pertinente que son ignorados por el sistema en el momento de la carga.
	 * Todas las lineas que comienzan por # son ignoradas al igual que cualquier linea vacia o que contenga solo espacios o tabuladores.
	 * 
	 * @param negocio
	 * @param archivo
	 * @return Número de usuarios cargados al sistema
	 * @throws FileNotFoundException
	 */
	public static int cargarArchivoUsuarios(Objectify negocio, File archivo) throws FileNotFoundException{
		InputStream flujo = new FileInputStream(archivo);
		Scanner scanner = new Scanner(flujo);
		int cargados = 0;
		while (scanner.hasNext()) {
			String linea = scanner.nextLine().trim();
			if (linea.startsWith("#") || linea.isEmpty()) {
				// Las lineas que inician con # son consideradas comentarios y las vacias son ignoradas
				continue;
			}
			StringTokenizer tokenizer = new StringTokenizer(linea, ";");
			String tipo = tokenizer.nextToken().trim();
			String nombre = tokenizer.nextToken().trim();
			String fechaCadena = tokenizer.nextToken().trim();
			ZonedDateTime fecha = ZonedDateTime.of(LocalDate.parse(fechaCadena, DateTimeFormatter.ISO_DATE), LocalTime.of(23, 59), ZoneId.systemDefault());			
			negocio.agregarUsuario(nombre, tipo.equals("PAGO"), fecha);
			cargados++;
		}
		scanner.close();
		return cargados;		
	}
	
	/**
	 * Carga los usuarios del sistema desde un archivo JSON de acuerdo al siguiente ejemplo:
	 * 
	 * {
	 * 	"artistas": [
	 * 		{
	 * 			"nombre" : "Pink Floyd",
	 * 			"descripcion" : "Pink Floyd es una banda de rock británica, considerada un icono cultural del siglo xx y una de las bandas más influyentes en la historia de la música, que obtuvo gran popularidad gracias a su música psicodélica que evolucionó hacia el rock progresivo con el paso del tiempo.",
	 *			"generos" : [ "ROCK" ], 
	 * 			"albumes" : [
	 * 			 	{
	 * 			 		"titulo" : "Dark side of the moon",
	 * 			 		"caratula" : "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png",
	 * 			 		"exclusivo" : true,
	 * 			 		"canciones" : [
	 * 			 			{ "nombre" : "Speak to me", "duracion" : 67, "rutaArchivo" : "1.mp3" },
	 * 			 			{ "nombre" : "Breathe", "duracion" : 169, "rutaArchivo" : "2.mp3" },
	 * 			 			{ "nombre" : "On the run", "duracion" : 225, "rutaArchivo" : "3.mp3" }
	 * 			 		]
	 * 			 	},
	 * 			 	{
	 *
	 *			 		"titulo" : "Animals",
	 *			 		"caratula" : "https://upload.wikimedia.org/wikipedia/en/7/74/Pink_Floyd-Animals-Frontal.jpg",
	 *			 		"exclusivo" : false,
	 *			 		"canciones" : [
	 *			 			{ "nombre" : "Pigs on the wing 1", "duracion" : 85, "rutaArchivo" : "1.mp3" },
	 *			 			{ "nombre" : "Dogs", "duracion" : 1023, "rutaArchivo" : "2.mp3" },
	 *			 			{ "nombre" : "Pigs (Three diferent ones)", "duracion" : 685, "rutaArchivo" : "3.mp3" },
	 *			 			{ "nombre" : "Sheep", "duracion" : 625, "rutaArchivo" : "4.mp3" },
	 *			 			{ "nombre" : "Pigs on the wing 2", "duracion" : 83, "rutaArchivo" : "5.mp3" }
	 *			 		]
	 *			 	}
	 *			 	
	 *			]
	 *		}
	 *	]
	 *}
	 * 
	 * La duración de las canciones estan dadas en segundos.
	 * 
	 * @param negocio
	 * @param ruta
	 * @return Número de artistas cargados al sistema
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static int cargarArchivoArtistas(Objectify negocio, String ruta) throws IOException, ParseException {
		File archivo = new File(ruta);
		return cargarArchivoArtistas(negocio, archivo);
	}

	/**
	 * Carga los usuarios del sistema desde un archivo JSON de acuerdo al siguiente ejemplo:
	 * 
	 * {
	 * 	"artistas": [
	 * 		{
	 * 			"nombre" : "Pink Floyd",
	 * 			"descripcion" : "Pink Floyd es una banda de rock británica, considerada un icono cultural del siglo xx y una de las bandas más influyentes en la historia de la música, que obtuvo gran popularidad gracias a su música psicodélica que evolucionó hacia el rock progresivo con el paso del tiempo.",
	 *			"generos" : [ "ROCK" ], 
	 * 			"albumes" : [
	 * 			 	{
	 * 			 		"titulo" : "Dark side of the moon",
	 * 			 		"caratula" : "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png",
	 * 			 		"exclusivo" : true,
	 * 			 		"canciones" : [
	 * 			 			{ "nombre" : "Speak to me", "duracion" : 67, "rutaArchivo" : "1.mp3" },
	 * 			 			{ "nombre" : "Breathe", "duracion" : 169, "rutaArchivo" : "2.mp3" },
	 * 			 			{ "nombre" : "On the run", "duracion" : 225, "rutaArchivo" : "3.mp3" }
	 * 			 		]
	 * 			 	},
	 * 			 	{
	 *
	 *			 		"titulo" : "Animals",
	 *			 		"caratula" : "https://upload.wikimedia.org/wikipedia/en/7/74/Pink_Floyd-Animals-Frontal.jpg",
	 *			 		"exclusivo" : false,
	 *			 		"canciones" : [
	 *			 			{ "nombre" : "Pigs on the wing 1", "duracion" : 85, "rutaArchivo" : "1.mp3" },
	 *			 			{ "nombre" : "Dogs", "duracion" : 1023, "rutaArchivo" : "2.mp3" },
	 *			 			{ "nombre" : "Pigs (Three diferent ones)", "duracion" : 685, "rutaArchivo" : "3.mp3" },
	 *			 			{ "nombre" : "Sheep", "duracion" : 625, "rutaArchivo" : "4.mp3" },
	 *			 			{ "nombre" : "Pigs on the wing 2", "duracion" : 83, "rutaArchivo" : "5.mp3" }
	 *			 		]
	 *			 	}
	 *			 	
	 *			]
	 *		}
	 *	]
	 *}
	 * 
	 * La duración de las canciones estan dadas en segundos.
	 * 
	 * @param negocio
	 * @param archivo
	 * @return Número de artistas cargados al sistema
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static int cargarArchivoArtistas(Objectify negocio, File archivo) throws IOException, ParseException {
		InputStream flujo = new FileInputStream(archivo);
		JSONObject json = (JSONObject)JSONValue.parseWithException(new InputStreamReader(flujo, Charset.forName("UTF-8")));
		int cargados = 0;
		if (json.containsKey("artistas")) {
				// Hay artistas en el archivo
				JSONArray artistas = (JSONArray)json.get("artistas");				
				for (int i = 0; i< artistas.size(); i++) {
					JSONObject artista = (JSONObject)artistas.get(i);
					JSONArray generos = (JSONArray)artista.get("generos");
					Collection<Genero> generosLeidos = leerGeneros(generos);
					long idArtista = negocio.agregarArtista(artista.get("nombre").toString(), artista.get("descripcion").toString(), generosLeidos);
					JSONArray albumes = (JSONArray)artista.get("albumes");
					cargarAlbumesEnArtista(negocio, idArtista, albumes);					
					cargados++;
				}
		}
		flujo.close();
		return cargados;
	}
	
	
	private static Collection<Genero> leerGeneros(JSONArray generos) {
		List<Genero> leidos = new ArrayList<Genero>();
		for (int i = 0; i<generos.size(); i++) {
			Genero genero = Genero.valueOf(generos.get(i).toString());
			leidos.add(genero);
		}
		return leidos;
	}	

	private static void cargarAlbumesEnArtista(Objectify negocio, long idArtista, JSONArray albumes) {
		for (int i = 0; i<albumes.size(); i++) {
			JSONObject album = (JSONObject)albumes.get(i);
			String titulo = album.get("titulo").toString();
			JSONArray canciones = (JSONArray)album.get("canciones");
			negocio.agregarAlbum(idArtista, titulo, album.get("caratula").toString(), (Boolean)album.get("exclusivo"));
			cargarCancionesEnAlbum(negocio, idArtista, titulo, canciones);
		}
	}

	private static void cargarCancionesEnAlbum(Objectify negocio, long idArtista, String tituloAlbum, JSONArray canciones) {
		for (int i = 0; i<canciones.size(); i++) {
			JSONObject cancion = (JSONObject)canciones.get(i);
			negocio.agregarCancion(idArtista, tituloAlbum, cancion.get("nombre").toString(), ((Number)cancion.get("duracion")).intValue(), cancion.get("rutaArchivo").toString());
		}		
	}	
	
	/**
	 * Serializa un objeto de clase Objectify a un archivo.
	 * @param negocio
	 * @param ruta
	 * @throws IOException 
	 */
	public static void SerializarObjectify(Objectify negocio, String ruta) throws IOException {
		File archivo = new File(ruta);
		SerializarObjectify(negocio, archivo);
	}

	/**
	 * Serializa un objeto de clase Objectify a un archivo.
	 * @param negocio
	 * @param archivo
	 * @throws IOException 
	 */
	public static void SerializarObjectify(Objectify negocio, File archivo) throws IOException {
		OutputStream flujo = new FileOutputStream(archivo);
		ObjectOutputStream flujoObjetos = new ObjectOutputStream(flujo);
		flujoObjetos.writeObject(negocio);
		flujoObjetos.close();
	}	
	
	/**
	 * Lee un archivo con un objeto de tipo Objectify serializado y lo carga a memoria. 
	 * @param ruta
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Objectify DesserializarObjectify(String ruta) throws ClassNotFoundException, IOException {
		File archivo = new File(ruta);
		return DesserializarObjectify(archivo);
	}

	/**
	 * Lee un archivo con un objeto de tipo Objectify serializado y lo carga a memoria. 
	 * @param archivo
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Objectify DesserializarObjectify(File archivo) throws ClassNotFoundException, IOException {
		Objectify negocio;
		InputStream flujo = new FileInputStream(archivo);
		ObjectInputStream flujoObjetos = new ObjectInputStream(flujo);
		negocio = (Objectify) flujoObjetos.readObject();
		flujoObjetos.close();		
		return negocio;
	}
	
	
}
