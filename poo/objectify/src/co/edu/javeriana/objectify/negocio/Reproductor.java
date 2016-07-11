package co.edu.javeriana.objectify.negocio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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
	
	private Reproductor() {
		colaReproduccion = new LinkedList<Cancion>();		
	}
	
	public static synchronized Reproductor obtenerInstancia() {
		if (instancia == null) {
			instancia = new Reproductor();
		}
		return instancia;
	}
	
	public void agregarACola(Cancion cancion) {
		colaReproduccion.add(cancion);		
	}

	public void agregarACola(Album album) {
		this.colaReproduccion.addAll(album.getCanciones());
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

}
