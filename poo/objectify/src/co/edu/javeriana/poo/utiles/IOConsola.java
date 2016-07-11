package co.edu.javeriana.poo.utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

public class IOConsola {
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static PrintStream out = System.out; 
	
	/**
	 * Lee una fecha por consola
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @return Número entero recibido
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */	
	public static LocalDate leerFecha(String mensaje) throws IOException {
		int mes, dia, agno;
		agno = leerEntero("Año " + mensaje);
		mes = leerEntero("Mes " + mensaje);
		dia = leerEntero("Día " + mensaje);
		return LocalDate.of(agno, mes, dia);
	}
	
	/**
	 * Lee un entero por consola reintentando si el formato ingresado no corresponde
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @return Número entero recibido
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */
	public static int leerEntero(String mensaje) throws IOException {
		return (int)leerLong(mensaje);
	}

	/**
	 * Lee un long por consola reintentando si el formato ingresado no corresponde
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @return Número entero recibido
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */
	public static long leerLong(String mensaje) throws IOException { 
		try {
			out.println(mensaje + ":");		
			return Long.parseLong(in.readLine());
		} catch (NumberFormatException e) {
			out.println("Formato invalido, por favor intente nuevamente");
			return leerEntero(mensaje);
		}		
	}	
	
	/**
	 * Lee una cadena por consola presentando un mensaje al usuario
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @return Cadena recibida
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */
	public static String leerCadena(String mensaje) throws IOException { 
			out.println(mensaje + ":");		
			return in.readLine();
	}


}
