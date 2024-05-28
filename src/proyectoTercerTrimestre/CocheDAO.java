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
    
    public void borrarCoche(Coche coche) {
        String sql = "DELETE FROM Coche WHERE Matricula = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement consulta = conn.prepareStatement(sql)) {
            consulta.setString(1, coche.getMatricula());
            consulta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void asignarPiezaAlCoche(Pieza pieza, Coche coche) {
        String sql = "INSERT INTO PiezaCoche (Matricula, Codigo) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement consulta = conn.prepareStatement(sql)) {
            consulta.setString(1, coche.getMatricula());
            consulta.setInt(2, pieza.getCodigo());
            consulta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	 public void eliminarPiezaDeCoche(Pieza pieza, Coche coche) {
	        String sql = "DELETE FROM PiezasCoche WHERE Matricula = ? AND Codigo = ?";
	        try (Connection conn = Conexion.getConnection();
	             PreparedStatement consulta = conn.prepareStatement(sql)) {
	            consulta.setString(1, coche.getMatricula());
	            consulta.setInt(2, pieza.getCodigo());
	            consulta.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 public void updateCoche(Coche coche) {
	        String sql = "UPDATE Coche SET Marca = ?, Modelo = ?, Anyo = ?, Caballos = ?, Manejo = ? WHERE Matricula = ?";
	        try (Connection conn = Conexion.getConnection();
	             PreparedStatement consulta = conn.prepareStatement(sql)) {
	            consulta.setString(1, coche.getMarca());
	            consulta.setString(2, coche.getModelo());
	            consulta.setString(3, coche.getAnyo());
	            consulta.setDouble(4, coche.getCaballos());
	            consulta.setDouble(5, coche.getManejo());
	            consulta.setString(6, coche.getMatricula());
	            consulta.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 

}