import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Huesped {
	private long id;
	private String nombre;
	private GregorianCalendar fechaNacimiento;
	
	public Huesped(long id, String nombre, GregorianCalendar nacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = nacimiento;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int calcularEdad() {
		GregorianCalendar hoy = new GregorianCalendar();
		int diferencia = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		if (fechaNacimiento.get(Calendar.MONTH) > hoy.get(Calendar.MONTH) || 
		        (fechaNacimiento.get(Calendar.MONTH) == hoy.get(Calendar.MONTH) 
		        && fechaNacimiento.get(Calendar.DATE) > hoy.get(Calendar.DATE))) {
			diferencia--;
		}
		return diferencia;
	}
	
	public String toString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return id + " nombre: " + nombre + " nacimiento: " + dateFormat.format(fechaNacimiento.getTime()) + " edad: " + calcularEdad();
	}
}
