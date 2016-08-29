package co.edu.javeriana.objectify.negocio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

@SuppressWarnings("serial")
public class Reproductor extends JFXPanel {
	
	private static Reproductor instancia;	
	private Queue<Cancion> colaReproduccion; 
	private Cancion reproduciendo;
	private MediaPlayer player;
	private Usuario usuarioActivo; 
	
	private Reproductor() {
		colaReproduccion = new LinkedList<Cancion>();		
	}
	
	public static synchronized Reproductor obtenerInstancia() {
		if (instancia == null) {
			instancia = new Reproductor();
		}
		return instancia;
	}
	
	/**
	 * Agrega una cancion a la cola de reproducción actual verificando si el usuarioActivo tiene 
	 * acceso al album al que pertenece la canción 
	 * @param cancion 
	 * @return true si se agrega la canción false de lo contrario
	 */
	public boolean agregarACola(Cancion cancion) {
		if (usuarioActivo == null || usuarioActivo.puedeEscucharAlbum(cancion.getAlbum())){
			colaReproduccion.add(cancion);
			return true;
		}
		return false;
	}

	/**
	 * Agrega un album a la cola de reproducción actual verificando si el usuarioActivo tiene 
	 * acceso al mismo 
	 * @param album  
	 * @return true si se agrega la canción false de lo contrario
	 */	
	public boolean agregarACola(Album album) {
		if (usuarioActivo == null || usuarioActivo.puedeEscucharAlbum(album)){
			this.colaReproduccion.addAll(album.getCanciones());
			return true;
		}
		return false;
	}
	
	public void limpiarCola() {
		// Se acabo el papel higienico, por suerte no lo necesitamos
		this.colaReproduccion.clear();
	}
	public synchronized void reproducir() {
		if (this.player != null) {
			this.player.play();
		} else {
			try {
				URL url;
				this.reproduciendo = this.colaReproduccion.poll();
				this.reproduciendo.aumentarReproducciones();
				if (this.reproduciendo != null) {
					System.out.printf("Reproduciendo: %s\n",this.reproduciendo.getNombre());
					url = new URL(this.reproduciendo.getRutaArchivo());
			        Media media = new Media(url.toString());
			        this.player = new MediaPlayer(media);
			        this.player.setOnEndOfMedia(new Runnable() {						
						@Override
						public void run() {							
							player = null;
							Reproductor.obtenerInstancia().reproducir();
						}
					});
			        this.player.play();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void ordenarCancionesPorNombre() {
		Collections.sort((List<Cancion>)colaReproduccion);
	}
	
	public void ordenarCancionesPorAlbumYDuracion(){
		Collections.sort((List<Cancion>)colaReproduccion, new CancionAlbumYDuracionComparator());
	}
	
	public void siguiente() {
		this.player.stop();
		this.player = null;
		reproducir();
	}

	public void pausar() {
		this.player.pause();
	}
	
	public Collection<Cancion> getColaReproduccion() {
		return new ArrayList<Cancion>(this.colaReproduccion);
	}

	@Override
	public String toString() {
		return "Reproduciendo: " + reproduciendo + "\nCola: " + colaReproduccion;
	}

	public Usuario getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Usuario usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

}
