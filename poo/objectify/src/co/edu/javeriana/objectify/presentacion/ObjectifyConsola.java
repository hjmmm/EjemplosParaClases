package co.edu.javeriana.objectify.presentacion;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.edu.javeriana.objectify.archivos.ManejadorArchivos;
import co.edu.javeriana.objectify.negocio.Album;
import co.edu.javeriana.objectify.negocio.Artista;
import co.edu.javeriana.objectify.negocio.Genero;
import co.edu.javeriana.objectify.negocio.Objectify;
import co.edu.javeriana.objectify.negocio.Reproductor;
import co.edu.javeriana.objectify.negocio.Usuario;
import co.edu.javeriana.poo.utiles.IOConsola;

/**
 * Clase de uso del sistema de música usando una interfaz por consola.
 * @author User
 *
 */
public class ObjectifyConsola {
	
	private static PrintStream out = System.out;
	
	public static void main(String[] args) throws IOException {
		
		Objectify negocio = new Objectify();
		Reproductor reproductor = Reproductor.obtenerInstancia();
		
		while (true){
			int opcion = menu();
			try {
				switch(opcion) {
					case 1:
						reproductor.reproducir();
						break;
					case 2:
						reproductor.pausar();
						break;
					case 3:
						reproductor.siguiente();
						break;
					case 4:
						verUsuarios(negocio);
						break;
					case 5:
						verArtistas(negocio);
						break;
					case 6:
						verAlbumesArtista(negocio);
						break;
					case 7:
						out.println(reproductor);
						break;
					case 11:
						out.printf("%d usuarios cargados.\n", ManejadorArchivos.cargarArchivoUsuarios(negocio, IOConsola.leerCadena("Ruta al archivo")));						
						break;
					case 12:
						out.printf("%d artistas cargados.\n", ManejadorArchivos.cargarArchivoArtistas(negocio, IOConsola.leerCadena("Ruta al archivo")));					
						break;
					case 13:
						negocio = ManejadorArchivos.DesserializarObjectify(IOConsola.leerCadena("Ruta al archivo"));
						out.println("Se han cargado los datos del sistema.");
						break;
					case 14:
						ManejadorArchivos.SerializarObjectify(negocio, IOConsola.leerCadena("Ruta al archivo"));
						out.println("Los datos del sistema han sido guardados.");						 
						break;
					case 15:
						mostrarGeneros();
						break;
					case 0:
						out.println("Hasta la proxima!");
						System.exit(0);
						break;
				}				
			} catch (Exception e) {
				out.println("Se ha detectado un error: " + e.getMessage());
				e.printStackTrace();
			}
		}		
	}

	private static void verAlbumesArtista(Objectify negocio) throws IOException {
		long idArtista = IOConsola.leerEntero("Id artista");
		Artista artista = negocio.buscarArtistaPorId(idArtista);
		if (artista != null) {			
			List<Album> albumes = new ArrayList<Album>(artista.getAlbumes());
			out.println("Artista: " + artista.getNombre());
			for (int i = 0; i < albumes.size(); i++) {
				Album album = albumes.get(i);
				out.printf("%d. %s\n", i+1, album.getTitulo());
			}
			int albumSeleccionado = IOConsola.leerEntero("Album para agregar a la cola de reproducción (0 = ninguno)");
			if (albumSeleccionado > 0 && albumSeleccionado <= albumes.size()) {
				Reproductor.obtenerInstancia().agregarACola(albumes.get(albumSeleccionado-1));
			}
		} else {
			out.println("El artista no existe.");
		}
	}

	private static void verArtistas(Objectify negocio) {
		Collection<Artista> artistas = negocio.getArtistas();
		for (Artista a : artistas) {
			out.println(a);
		}
	}

	private static void verUsuarios(Objectify negocio) {
		Collection<Usuario> usuarios = negocio.getUsuarios();
		for (Usuario u : usuarios) {
			out.println(u);
		}
	}
	
	private static void mostrarGeneros() {
		System.out.println();
		for(Genero g : Genero.values()){
			System.out.printf("Nombre: %s\n%s\n\n", g.toString(), g.getDescripcion());
		}
	}

	private static int menu() throws IOException {
		out.println();
		out.println("Bienvenido a Objectify!");
		out.println("Estas son las opciones disponibles:");
		out.println("1. Reproducir");
		out.println("2. Pausar");
		out.println("3. Siguiente");
		out.println("4. Ver todos los usuarios");
		out.println("5. Ver todos los artistas");
		out.println("6. Ver albumes artista");
		out.println("7. Ver cola de reproducción");
		out.println("11. Cargar usuarios");
		out.println("12. Cargar artistas, albumes y canciones");
		out.println("13. Cargar todo");
		out.println("14. Guardar todo");
		out.println("15. Mostrar generos");
		out.println("0. Salir");
		return IOConsola.leerEntero("Seleccione una opción");
	}

}
