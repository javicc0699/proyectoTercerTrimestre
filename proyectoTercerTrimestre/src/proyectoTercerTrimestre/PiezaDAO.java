package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla Pieza de la base de datos.
 */
public class PiezaDAO {
	/**
     * Crea una nueva pieza en la base de datos.
     *
     * @param pieza La pieza que se va a crear.
     */
	public static void crearPieza(Pieza pieza) {
        String sql = "INSERT INTO Pieza (Codigo, Pieza, Calidad, CaballosProp, ManejoProp) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement consulta = conn.prepareStatement(sql)) {
        	consulta.setInt(1, pieza.getCodigo());
        	consulta.setString(2, pieza.getPieza());
        	consulta.setString(3, pieza.getCalidad());
        	consulta.setDouble(4, pieza.getCaballosProp());
        	consulta.setDouble(5, pieza.getManejoProp());
        	consulta.executeUpdate();
        } catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
	
	

}
