package proyectoTercerTrimestre;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aplicacion {
	public static void main(String[] args){
		
		crearCoche();
		
	}
	
	public static void crearCoche() {
		try {
		CocheDAO conexionCoche = new CocheDAO();
		PiezasCocheDAO conexionPiezas = new PiezasCocheDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		  // System.out.println("Introduce la matricula del coche (Máximo 7 caracteres): ");
        // String matricula = scanner.nextLine();
        String matricula = "1111AAA"; // Valor por defecto

        // System.out.println("Introduce la marca del coche: ");
        // String marca = scanner.nextLine();
        String marca = "Seat"; // Valor por defecto

        // System.out.println("Introduce el modelo del coche: ");
        // String modelo = scanner.nextLine();
        String modelo = "Toledo"; // Valor por defecto

        // System.out.println("Introduce el año de fabricación: ");
        // String anyo = scanner.nextLine();
        String anyo = "1999"; // Valor por defecto

        // System.out.println("Introduce los caballos del coche: ");
        // double cv = scanner.nextDouble();
        double cv = 300; // Valor por defecto
        // scanner.nextLine(); 

        // System.out.println("Introduce los puntos de manejo del coche: ");
        // double manejo = scanner.nextDouble();
        double manejo = 10; // Valor por defecto
        // scanner.nextLine();
		
		Coche cocheNuevo = new Coche(matricula , marca , modelo , anyo , cv , manejo);
		
		conexionCoche.crearCoche(cocheNuevo);
		conexionPiezas.crearPiezas(matricula);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
