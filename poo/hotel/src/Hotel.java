import java.util.GregorianCalendar;

public class Hotel {

	private String nombre;
	private double tarifaBasica;
	private Reserva[] reservas;
	
	public Hotel(String nombre, double tarifaBase){
		this.nombre = nombre;
		this.tarifaBasica = tarifaBase;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTarifaBasica() {
		return tarifaBasica;
	}
	public void setTarifaBasica(double tarifaBasica) {
		this.tarifaBasica = tarifaBasica;
	}
	
	public String toString() {
		return nombre; 
	}
	
	public void agregarReserva(GregorianCalendar entrada, GregorianCalendar salida, String numTarjeta, String tipoTarjeta) {
		Reserva nuevaReserva = new Reserva(entrada, salida, numTarjeta, tipoTarjeta);
		Reserva[] nuevoArreglo = new Reserva[reservas.length + 1];
		System.arraycopy(reservas, 0, nuevoArreglo, 0, reservas.length);
		nuevoArreglo[nuevaReserva.getId()] = nuevaReserva;
	}

	
	public void agregarHuesped(int idReserva, int idHuesped, String nombre, GregorianCalendar nacimiento) {
		if (idReserva < reservas.length){
			reservas[idReserva].agregarHuesped(idHuesped, nombre, nacimiento);
		}		
	}
	
}
