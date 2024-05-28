package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CocheDAO {

    public void crearCoche(Coche coche) {
        String sql = "INSERT INTO Coche (Matricula, Marca, Modelo, Anyo, Caballos, Manejo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement consulta = conn.prepareStatement(sql)) {
        	consulta.setString(1, coche.getMatricula());
        	consulta.setString(2, coche.getMarca());
        	consulta.setString(3, coche.getModelo());
        	consulta.setString(4, coche.getAnyo());
        	consulta.setDouble(5, coche.getCaballos());
        	consulta.setDouble(6, coche.getManejo());
        	consulta.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void actualizarCoche(Coche coche) throws SQLException {
        String sql = "UPDATE Coche SET Marca = ?, Modelo = ?, Anyo = ?, Caballos = ?, Manejo = ? WHERE Matricula = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, coche.getMarca());
            pstmt.setString(2, coche.getModelo());
            pstmt.setString(3, coche.getAnyo());
            pstmt.setDouble(4, coche.getCaballos());
            pstmt.setDouble(5, coche.getManejo());
            pstmt.setString(6, coche.getMatricula());
            pstmt.executeUpdate();
        }
    }

}