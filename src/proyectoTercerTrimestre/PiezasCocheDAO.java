package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PiezasCocheDAO {
	
	public void asignarPiezaAlCoche(Pieza pieza, Coche coche) {
        String sql = "INSERT INTO PiezasCoche (Matricula, Codigo) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement consulta = conn.prepareStatement(sql)) {
        	consulta.setString(1, coche.getMatricula());
        	consulta.setInt(2, pieza.getCodigo());
        	consulta.executeUpdate();
        } catch (SQLException e) {
			
			e.printStackTrace();
		}
    }

}
