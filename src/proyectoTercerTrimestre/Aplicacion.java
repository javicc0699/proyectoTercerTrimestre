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
		
		List<Coche> coches = new ArrayList<>();
		List<Pieza> piezas = new ArrayList<>();
		
		
		
		crearCoche(coches);
		
	}
	
	public static void crearCoche(List<Coche> coches) {
		try {
		CocheDAO conexionCoche = new CocheDAO();
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce la matricula del coche (Máximo 7 caracteres): ");
		String matricula = scanner.nextLine();

		System.out.println("Introduce la marca del coche: ");
		String marca = scanner.nextLine();

		System.out.println("Introduce el modelo del coche: ");
		String modelo = scanner.nextLine();

		System.out.println("Introduce el año de fabricación: ");
		String anyo = scanner.nextLine();

		System.out.println("Introduce los caballos del coche: ");
		double cv = scanner.nextDouble();
		scanner.nextLine(); 

		System.out.println("Introduce los puntos de manejo del coche: ");
		double manejo = scanner.nextDouble();
		scanner.nextLine(); 

		
		Coche cocheNuevo = new Coche(matricula , marca , modelo , anyo , cv , manejo);
		conexionCoche.crearCoche(cocheNuevo);
		coches.add(cocheNuevo);
		
		System.out.println("Has guardado un " + marca + modelo + " en tu garaje!");
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public static void modificarCoche(List<Coche> coches , List<Pieza> piezas) {
		
		if(buscarCoche(coches) == null) {
			
			System.out.println("Coche no encontrado. Por favor introduce otra matricula. ");
			
		}else {
			
			
		}
	}
	
	public static Coche buscarCoche(List<Coche> coches) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a buscar: ");
        String matriculaBuscada = scanner.nextLine();

        for (Coche coche : coches) {
            if (coche.getMatricula().equalsIgnoreCase(matriculaBuscada)) {
                return coche;
            }
        }
        return null;
	}
	
}









/**
 * 
 * 		  // System.out.println("Introduce la matricula del coche (Máximo 7 caracteres): ");
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
         * 
         */
