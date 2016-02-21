import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestReservasHotel {
	
	public static void main(String[] args) {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    Hotel hotel = new Hotel("Javier's place", 200);
		try {
			System.out.printf("El hotel esta creado: %s", hotel.getNombre());
			System.out.println();
			in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
