package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PiezaDAO {
	
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
