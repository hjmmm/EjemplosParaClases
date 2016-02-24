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
	
	public int agregarReserva(GregorianCalendar entrada, GregorianCalendar salida, String numTarjeta, String tipoTarjeta) {
		Reserva nuevaReserva = new Reserva(entrada, salida, numTarjeta, tipoTarjeta);
		int nuevoTamagno = reservas != null ? reservas.length + 1 : 1; 
		Reserva[] nuevoArreglo = new Reserva[nuevoTamagno];
		if (reservas != null) {
			System.arraycopy(reservas, 0, nuevoArreglo, 0, reservas.length);
		}
		nuevoArreglo[nuevaReserva.getId()] = nuevaReserva;
		reservas = nuevoArreglo;
		return nuevaReserva.getId();
	}
	
	public void agregarHuesped(int idReserva, long idHuesped, String nombre, GregorianCalendar nacimiento) {
		if (idReserva < reservas.length){
			reservas[idReserva].agregarHuesped(idHuesped, nombre, nacimiento);
		}		
	}
	
	public String reporteReservas() {
		String datosReservas = "";
		for(Reserva reserva : reservas) {
			datosReservas += "Reserva: " + reserva.toString() + System.lineSeparator();
			datosReservas += "Costo total: " + reserva.calcularValor(tarifaBasica) + System.lineSeparator();
			datosReservas += reserva.reporteHuespedes();
		}
		return datosReservas;
	}
	
}
