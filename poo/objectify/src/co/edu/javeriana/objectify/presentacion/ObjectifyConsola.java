package co.edu.javeriana.objectify.presentacion;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import co.edu.javeriana.objectify.archivos.ManejadorArchivos;
import co.edu.javeriana.objectify.negocio.Cancion;
import co.edu.javeriana.objectify.negocio.Objectify;
import co.edu.javeriana.objectify.negocio.Reproductor;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase de uso del sistema de música usando una interfaz por consola.
 * @author User
 *
 */
public class ObjectifyConsola {
	
	public static void main(String[] args) throws InterruptedException, IOException, ParseException{
		Objectify negocio = new Objectify();
		
		Reproductor reproductor = Reproductor.obtenerInstancia();
		reproductor.agregarACola(new Cancion(null, "C1", 100, "http://ocrmirror.org/files/music/remixes/Legend_of_Zelda_Twilight_Princess_Wistful_OC_ReMix.mp3"));
		reproductor.agregarACola(new Cancion(null, "C2", 100, "http://ocrmirror.org/files/music/remixes/Legend_of_Zelda_Ocarina_of_Time_Lullaby_of_the_Sky_OC_ReMix.mp3"));
		reproductor.agregarACola(new Cancion(null, "C3", 100, "http://ocrmirror.org/files/music/remixes/Legend_of_Zelda_Twilight_Princess_Zelda%27s_Lament_OC_ReMix.mp3"));		
		
		System.out.printf("Número de usuarios cargados: %d\n", ManejadorArchivos.cargarArchivoUsuarios(negocio, "usuarios.txt"));
		System.out.printf("Número de artistas cargados: %d\n", ManejadorArchivos.cargarArchivoArtistas(negocio, "artistas.json"));
		
		System.out.println(negocio);
		
		Scanner scanner = new Scanner(System.in);
		String comando = "q";
		while (!comando.equals("q")){
			if (comando.equals("p")) {
				Reproductor.obtenerInstancia().reproducir();
			}
			if (comando.equals("s")) {
				Reproductor.obtenerInstancia().pausar();
			}
			if (comando.equals("n")) {
				Reproductor.obtenerInstancia().siguiente();
			}
			
			comando = scanner.nextLine();
		}
		scanner.close();
		System.exit(0);		
	}

}
