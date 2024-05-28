package proyectoTercerTrimestre;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aplicacion {
	public static void main(String[] args) {
		PiezaDAO piezaDAO = new PiezaDAO();
		List<Coche> coches = new ArrayList<>();
		List<Pieza> piezas = new ArrayList<>();
		recogerCochesSQL(coches);
		recogerPiezasSQL(piezas);
		menuPrincipal(coches, piezas);

	}

	public static void menuPrincipal(List<Coche> coches, List<Pieza> piezas) {

		Scanner scanner = new Scanner(System.in);
		int seleccion;

		do {
			mensajesDelMenu();
			seleccion = scanner.nextInt();

			switch (seleccion) {
			case 1:
				crearCoche(coches);
				esperarUsuario();
				break;

			case 2:
				borrarCoche(coches);
				esperarUsuario();
				break;

			case 3:
				mostrarTodosLosCoches(coches);
				esperarUsuario();
				break;

			case 4:
				mostrarCocheConPiezas(coches);
				esperarUsuario();
				break;

			case 5:
				modificarCoche(coches, piezas);
				esperarUsuario();
				break;
				
			case 6:
				crearPieza(piezas);
				esperarUsuario();
				break;
				
			case 7:
				buscarPiezaPorCodigo(piezas);
				esperarUsuario();
				break;
			case 8:
				mostrarPiezasDisponibles(piezas);
				esperarUsuario();
				break;
				
			case 9:
				obtenerTotalCaballos(coches);
				esperarUsuario();
				break;
			case 0:
				System.out.println("Saliendo del garaje...");
				break;

			default:
				System.out.println("Selección no válida. Inténtalo de nuevo.");
				esperarUsuario();
			}
		} while (seleccion != 0);

	}

	private static void crearCoche(List<Coche> coches) {
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

			Coche cocheNuevo = new Coche(matricula, marca, modelo, anyo, cv, manejo);
			conexionCoche.crearCoche(cocheNuevo);
			coches.add(cocheNuevo);

			System.out.println("Has guardado un " + marca + modelo + " en tu garaje!");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static void borrarCoche(List<Coche> coches) {
		Scanner scanner = new Scanner(System.in);

		Coche borrarCoche = buscarCoche(coches);

		if (borrarCoche != null) {
			coches.remove(borrarCoche);
			CocheDAO cocheDAO = new CocheDAO();
			cocheDAO.borrarCoche(borrarCoche);
			System.out.println(
					"El coche con matrícula " + borrarCoche.getMatricula() + " se ha sido eliminado del garaje.");
		} else {
			System.out.println("No se encontró ningún coche con la matrícula introducida.");
		}
	}

	private static void mostrarTodosLosCoches(List<Coche> coches) {
		System.out.println("Tu garaje actual: ");
		for (Coche coche : coches) {
			System.out.println("Matrícula: \033[33m" + coche.getMatricula() + "\033[0m");
			System.out.println("Marca: \033[36m" + coche.getMarca() + "\033[0m");
			System.out.println("Modelo: \033[35m" + coche.getModelo() + "\033[0m");
			System.out.println("Año: \033[32m" + coche.getAnyo() + "\033[0m");
			System.out.println("Caballos: \033[34m" + coche.getCaballos() + "\033[0m");
			System.out.println("Manejo: \033[31m" + coche.getManejo() + "\033[0m");
			System.out.println();
		}
	}

	private static Pieza buscarPiezaPorCodigo(List<Pieza> piezas) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el código de la pieza a buscar:");
		int codigoBuscado = scanner.nextInt();

		for (Pieza pieza : piezas) {
			if (pieza.getCodigo() == codigoBuscado) {
				return pieza;
			}
		}

		System.out.println("No se encontró ninguna pieza con el código introducido.");
		return null;
	}

	private static Coche buscarCoche(List<Coche> coches) {

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

	private static void crearPieza(List<Pieza> pieza) {

		try {
			PiezaDAO conexionPieza = new PiezaDAO();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Introduce el código de la pieza: ");
			int codigo = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Introduce el nombre de la pieza: ");
			String nombrePieza = scanner.nextLine();

			System.out.println("Introduce la calidad de la pieza: ");
			String calidad = scanner.nextLine();

			System.out.println("Introduce los caballos  de la pieza: ");
			double caballosProp = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("Introduce los puntos de manejo de la pieza: ");
			double manejoProp = scanner.nextDouble();
			scanner.nextLine();

			Pieza piezaNueva = new Pieza(codigo, nombrePieza, calidad, caballosProp, manejoProp);
			PiezaDAO.crearPieza(piezaNueva);

			System.out.println("Has guardado una nueva pieza en el almacen");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void recogerPiezasSQL(List<Pieza> piezas) {

		try (Connection conn = Conexion.getConnection();
				PreparedStatement consulta = conn.prepareStatement("SELECT * FROM Pieza");
				ResultSet resultado = consulta.executeQuery()) {

			while (resultado.next()) {
				int codigo = resultado.getInt("Codigo");
				String nombrePieza = resultado.getString("Pieza");
				String calidad = resultado.getString("Calidad");
				double caballosProp = resultado.getDouble("CaballosProp");
				double manejoProp = resultado.getDouble("ManejoProp");

				Pieza pieza = new Pieza(codigo, nombrePieza, calidad, caballosProp, manejoProp);
				piezas.add(pieza);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void recogerCochesSQL(List<Coche> coches) {
		String sql = "SELECT * FROM Coche";
		try (Connection conn = Conexion.getConnection();
				PreparedStatement consulta = conn.prepareStatement(sql);
				ResultSet resultado = consulta.executeQuery()) {

			while (resultado.next()) {
				String matricula = resultado.getString("Matricula");
				String marca = resultado.getString("Marca");
				String modelo = resultado.getString("Modelo");
				String anyo = resultado.getString("Anyo");
				double caballos = resultado.getDouble("Caballos");
				double manejo = resultado.getDouble("Manejo");

				Coche coche = new Coche(matricula, marca, modelo, anyo, caballos, manejo);
				coches.add(coche);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarPiezasDisponibles(List<Pieza> piezas) {
		System.out.println("Piezas disponibles:");
		for (Pieza pieza : piezas) {
			System.out.print("Código: \033[33m" + pieza.getCodigo() + "\033[0m");
			System.out.print(" - Nombre: \033[36m" + pieza.getPieza() + "\033[0m");
			System.out.print(" - Calidad: \033[35m" + pieza.getCalidad() + "\033[0m");
			System.out.print(" - Caballos: \033[32m" + pieza.getCaballosProp() + "\033[0m");
			System.out.println(" - Manejo: \033[34m" + pieza.getManejoProp() + "\033[0m");
		}
	}

	private static void mostrarCocheConPiezas(List<Coche> coches) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce la matrícula del coche:");
		String matriculaBuscada = scanner.nextLine();

		boolean encontrado = false;

		for (Coche coche : coches) {
			if (coche.getMatricula().equalsIgnoreCase(matriculaBuscada)) {
				encontrado = true;
				System.out.println("Información del coche:");
				System.out.println("Matrícula: " + coche.getMatricula());
				System.out.println("Marca: " + coche.getMarca());
				System.out.println("Modelo: " + coche.getModelo());
				System.out.println("Año: " + coche.getAnyo());
				System.out.println("Caballos: " + coche.getCaballos());
				System.out.println("Manejo: " + coche.getManejo());

				List<Pieza> piezas = coche.getPiezas();
				if (!piezas.isEmpty()) {
					System.out.println("Piezas instaladas:");
					for (Pieza pieza : piezas) {
						System.out.print("  - Código: \033[33m" + pieza.getCodigo() + "\033[0m");
						System.out.print(" - Nombre: \033[36m" + pieza.getPieza() + "\033[0m");
						System.out.print(" - Calidad: \033[35m" + pieza.getCalidad() + "\033[0m");
						System.out.print(" - Caballos: \033[32m" + pieza.getCaballosProp() + "\033[0m");
						System.out.println(" - Manejo: \033[34m" + pieza.getManejoProp() + "\033[0m");
					}
				} else {
					System.out.println("No hay piezas instaladas en este coche.");
				}
				break;
			}
		}
		if (!encontrado) {
			System.out.println("No se encontró ningún coche con la matrícula proporcionada.");
		}
	}

	private static void modificarCoche(List<Coche> coches, List<Pieza> piezas) {
		Scanner scanner = new Scanner(System.in);
		CocheDAO cocheDAO = new CocheDAO();
		System.out.println("Introduce la matrícula del coche al que quieres añadir una pieza:");
		String matriculaBuscada = scanner.nextLine();
		Coche coche = null;

		for (Coche coch : coches) {
			if (coch.getMatricula().equalsIgnoreCase(matriculaBuscada)) {
				coche = coch;
				break;
			}
		}

		if (coche == null) {
			System.out.println("No se encontró ningún coche con la matrícula proporcionada.");
			return;
		}

		System.out.println("¿Deseas ver las piezas disponibles antes de instalarlas? (si/no)");
		String respuesta = scanner.nextLine();

		if (respuesta.equalsIgnoreCase("si")) {
			mostrarPiezasDisponibles(piezas);
		}

		System.out.println("Introduce el código de la pieza que quieres añadir:");
		int codigoBuscado = scanner.nextInt();
		Pieza pieza = null;

		for (Pieza pi : piezas) {
			if (pi.getCodigo() == codigoBuscado) {
				pieza = pi;
				break;
			}
		}

		if (pieza == null) {
			System.out.println("No se encontró ninguna pieza con el código proporcionado.");
			return;
		}

		Pieza piezaExistente = obtenerPiezaDelMismoTipo(coche, pieza);

		if (piezaExistente != null) {
			System.out.println("El coche ya tiene instalada una pieza del mismo tipo: " + piezaExistente.getPieza());
			System.out.println("¿Quieres cambiarla por esta? (sí/no)");
			respuesta = scanner.next();
			if (respuesta.equalsIgnoreCase("si")) {
				coche.getPiezas().remove(piezaExistente);
				cocheDAO.eliminarPiezaDeCoche(piezaExistente, coche);
				System.out.println("Has quitado la pieza " + piezaExistente.getPieza());
			} else {
				System.out.println("No se ha añadido la nueva pieza.");
				return;
			}
		}

		coche.añadirPieza(pieza);
		System.out.println("Pieza añadida al coche con matrícula " + coche.getMatricula() + ".");
		cocheDAO.asignarPiezaAlCoche(pieza, coche);
		actualizarCoche(coche);
		cocheDAO.updateCoche(coche);

	}

	private static Pieza obtenerPiezaDelMismoTipo(Coche coche, Pieza nuevaPieza) {
		for (Pieza pieza : coche.getPiezas()) {
			if (sonDelMismoTipo(pieza, nuevaPieza)) {
				return pieza;
			}
		}
		return null;
	}

	private static boolean sonDelMismoTipo(Pieza pieza1, Pieza pieza2) {
		String nombre1 = pieza1.getPieza().toLowerCase();
		String nombre2 = pieza2.getPieza().toLowerCase();

		return (nombre1.contains("motor") && nombre2.contains("motor"))
				|| (nombre1.contains("escape") && nombre2.contains("escape"))
				|| (nombre1.contains("frenos") && nombre2.contains("frenos"))
				|| (nombre1.contains("neumáticos") && nombre2.contains("neumáticos"));
	}

	private static void mensajesDelMenu() {

		System.out.println("1. Añadir coche. ");
		System.out.println("2. Borrar coche. ");
		System.out.println("3. Mostrar todos los coches. ");
		System.out.println("4. Mostrar un coche por matricula y sus piezas. ");
		System.out.println("5. Modificar un coche. ");
		System.out.println("6. Crear pieza. ");
		System.out.println("7. Buscar pieza por ID. ");
		System.out.println("8. Mostrar todas las piezas disponibles. ");
		System.out.println("9. Mostrar el total de CV de tu garaje. ");
	}

	private static void esperarUsuario() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pulsa cualquier tecla para volver al menu principal...");
		scanner.nextLine();
	}

	private static void actualizarCoche(Coche coche) {
	    double caballosOriginales = coche.getCaballos();
	    double manejoOriginal = coche.getManejo();
	    double caballosTotales = caballosOriginales;
	    double manejoTotal = manejoOriginal;

	    List<Pieza> piezas = coche.getPiezas();
	    for (Pieza pieza : piezas) {
	        caballosTotales += pieza.getCaballosProp();
	        manejoTotal += pieza.getManejoProp();
	    }
	    coche.setCaballos(caballosTotales);
	    coche.setManejo(manejoTotal);
	    
	    System.out.println("Estadísticas del coche actualizado:");
	    System.out.println("Matrícula: \033[33m" + coche.getMatricula() + "\033[0m");
	    System.out.println("Marca: \033[36m" + coche.getMarca() + "\033[0m");
	    System.out.println("Modelo: \033[35m" + coche.getModelo() + "\033[0m");
	    System.out.println("Año: \033[32m" + coche.getAnyo() + "\033[0m");
	    System.out.println("Caballos originales: \033[34m" + caballosOriginales + "\033[0m");
	    System.out.println("Manejo original: \033[34m" + manejoOriginal + "\033[0m");
	    System.out.println("Caballos totales con piezas instaladas: \033[31m" + caballosTotales + "\033[0m");
	    System.out.println("Manejo total con piezas instaladas: \033[31m" + manejoTotal + "\033[0m");

	    if (!piezas.isEmpty()) {
	        System.out.println("Piezas instaladas:");
	        for (Pieza pieza : piezas) {
	            System.out.println("  - Código: \033[33m" + pieza.getCodigo() + "\033[0m, Nombre: \033[36m" + pieza.getPieza() + "\033[0m, Caballos: \033[34m" + pieza.getCaballosProp() + "\033[0m, Manejo: \033[34m" + pieza.getManejoProp() + "\033[0m");
	        }
	    } else {
	        System.out.println("No hay piezas instaladas en este coche.");
	    }
	}
	
	private static void obtenerTotalCaballos(List<Coche> coches) {
        double totalCaballos = coches.stream().mapToDouble(Coche::getCaballos).sum();
        System.out.println("La cantidad total de caballos en todos los coches es: " + totalCaballos);
    }
	

}
