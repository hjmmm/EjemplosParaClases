import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Reserva {
	private static int CONSECUTIVO = 0;
	private int id;
	private GregorianCalendar fechaEntrada;
	private GregorianCalendar fechaSalida;
	// Nunca deberiamos guardar una tarjeta de credito asi por seguridad
	private String numeroTarjetaCredito;
	private String tipoTarjetaCredito;
	private double valor;
	private Huesped[] huespedes;
	
	public Reserva(GregorianCalendar entrada, GregorianCalendar salida, String numTarjeta, String tipoTarjeta) {
		this.fechaEntrada = entrada;
		this.fechaSalida = salida;
		this.numeroTarjetaCredito = numTarjeta;
		this.tipoTarjetaCredito = tipoTarjeta;
		this.id = CONSECUTIVO++;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GregorianCalendar getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(GregorianCalendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public GregorianCalendar getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(GregorianCalendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getNumeroTarjetaCredito() {
		return numeroTarjetaCredito;
	}
	public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
		this.numeroTarjetaCredito = numeroTarjetaCredito;
	}
	public String getTipoTarjetaCredito() {
		return tipoTarjetaCredito;
	}
	public void setTipoTarjetaCredito(String tipoTarjetaCredito) {
		this.tipoTarjetaCredito = tipoTarjetaCredito;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}	
	
	public double calcularValor(double tarifaBase) {
		double valorTotal = 0;
		int diasReserva = (int)Math.ceil((fechaSalida.getTimeInMillis() - fechaEntrada.getTimeInMillis())/(1000 * 3600 * 24));
		if (huespedes == null) { return valorTotal; }
		for(Huesped huesped : huespedes) {
			double valorPorHuesped = tarifaBase * diasReserva;
			if (huesped.calcularEdad() < 12) {
				valorPorHuesped = valorPorHuesped / 2;
			}
			valorTotal += valorPorHuesped;
		}
		return valorTotal;
	}
	
	public void agregarHuesped(long id, String nombre, GregorianCalendar nacimiento) {
		Huesped nuevoHuesped = new Huesped(id, nombre, nacimiento);
		int nuevoTamagno = huespedes != null ? huespedes.length + 1 : 1; 
		Huesped[] nuevoArreglo = new Huesped[nuevoTamagno];
		if (huespedes != null) {
			System.arraycopy(huespedes, 0, nuevoArreglo, 0, huespedes.length);
		}
		nuevoArreglo[nuevoArreglo.length - 1] = nuevoHuesped;
		huespedes = nuevoArreglo;
	}
	
	public String reporteHuespedes() {
		String datosHuespedes = "";
		if (huespedes == null) {
			return datosHuespedes;
		}
		for(Huesped huesped : huespedes) {
			datosHuespedes += "Huesped: " + huesped.toString() + System.lineSeparator();
		}
		return datosHuespedes;
	}
	
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return id + " entrada: " +  dateFormat.format(fechaEntrada.getTime()) + " salida: " + dateFormat.format(fechaSalida.getTime()) 
				+ " tarjeta #: " + numeroTarjetaCredito + " tarjeta tipo: " + tipoTarjetaCredito;
	}
}
