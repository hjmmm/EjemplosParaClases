import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.System.out;

public class TestReservasHotel {
	
	public static void main(String[] args) {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    Hotel hotel = new Hotel("OOP's place", 152000);
		try {
			for (int i=0; i<2; i++){
				// Leer los datos de las reservas
				int idReserva = leerYAgregarReserva(hotel, in);
				// Leer los datos de los huespedes y asociarlos a la reserva
				for(int j = 0; j<2; j++) {
					leerYAgregarHuesped(hotel, idReserva, in);
				}
				out.println(hotel.reporteReservas());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lee los datos de una reserva y la agrega a la reserva 
	 * @param hotel Hotel al que hay que agregarle la reserva que se lee
	 * @param idReserva Reserva a la que hay que relacionar el huesped
	 * @param in BufferedReader que se usa para leer la informacion proveniente del usuario
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */	
	private static void leerYAgregarHuesped(Hotel hotel, int idReserva, BufferedReader in) throws IOException {
		long id;
		String nombre;
		GregorianCalendar nacimiento;
		out.println("Ingrese los datos del huesped");
		id = leerLong("Identificación", in);
		nombre = leerCadena("Nombre", in);
		nacimiento = leerFecha("Fecha de nacimiento", in);
		hotel.agregarHuesped(idReserva, id, nombre, nacimiento);
	}

	/**
	 * Lee los datos de una reserva y la agrega a el hotel 
	 * @param hotel Hotel al que hay que agregarle la reserva que se lee
	 * @param in BufferedReader que se usa para leer la informacion proveniente del usuario
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 * @return Retorna el id de la reserva que se adiciono
	 */
	private static int leerYAgregarReserva(Hotel hotel, BufferedReader in) throws IOException {
		String numTarjeta;
		String tipoTarjeta;
		GregorianCalendar entrada;
		GregorianCalendar salida;
		out.println("Por favor introduzca una reserva");
		entrada = leerFecha("entrada", in);
		salida = leerFecha("salida", in);
		numTarjeta = leerCadena("Número tarjeta de credito", in);
		tipoTarjeta = leerCadena("Tipo tarjeta de credito", in);
		return hotel.agregarReserva(entrada, salida, numTarjeta, tipoTarjeta);
	}

	/**
	 * Lee una fecha por consola
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @param in BufferedReader que se usa para leer la informacion proveniente del usuario
	 * @return Número entero recibido
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */	
	private static GregorianCalendar leerFecha(String mensaje, BufferedReader in) throws IOException {
		int mes, dia, agno;
		Calendar resultado;
		agno = leerEntero("Año " + mensaje, in);
		mes = leerEntero("Mes " + mensaje, in) - 1; // Los meses en java empiezan en 0
		dia = leerEntero("Día " + mensaje, in);
		resultado = GregorianCalendar.getInstance();
		resultado.set(agno, mes, dia);
		return (GregorianCalendar)resultado;
	}
	
	/**
	 * Lee un entero por consola reintentando si el formato ingresado no corresponde
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @param in BufferedReader que se usa para leer la informacion proveniente del usuario
	 * @return Número entero recibido
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */
	private static int leerEntero(String mensaje, BufferedReader in) throws IOException {
		return (int)leerLong(mensaje, in);
	}

	/**
	 * Lee un long por consola reintentando si el formato ingresado no corresponde
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @param in BufferedReader que se usa para leer la informacion proveniente del usuario
	 * @return Número entero recibido
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */
	private static long leerLong(String mensaje, BufferedReader in) throws IOException { 
		try {
			out.println(mensaje + ":");		
			return Long.parseLong(in.readLine());
		} catch (NumberFormatException e) {
			out.println("Formato invalido, por favor intente nuevamente");
			return leerEntero(mensaje, in);
		}		
	}	
	
	/**
	 * Lee una cadena por consola presentando un mensaje al usuario
	 * @param mensaje Mensaje para presentar al usuario al momento de solicitar el entero 
	 * @param in BufferedReader que se usa para leer la informacion proveniente del usuario
	 * @return Cadena recibida
	 * @throws IOException En caso de una excepcion de tipo IOException durante la lectura
	 */
	private static String leerCadena(String mensaje, BufferedReader in) throws IOException { 
			out.println(mensaje + ":");		
			return in.readLine();
	}
	
}
