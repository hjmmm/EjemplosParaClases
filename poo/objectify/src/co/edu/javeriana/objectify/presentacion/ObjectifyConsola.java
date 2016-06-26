package co.edu.javeriana.objectify.presentacion;

import co.edu.javeriana.objectify.negocio.Objectify;

/**
 * Clase de uso del sistema de música usando una interfaz por consola.
 * @author User
 *
 */
public class ObjectifyConsola {
	
	public static void main(String[] args){
		Objectify negocio = new Objectify();
		
		System.out.println(negocio);
	}

}
