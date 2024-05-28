package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla Coche y la relación PiezaCoche de la base de datos.
 */
public class CocheDAO {
	/**
     * Crea un nuevo coche en la base de datos.
     *
     * @param coche El coche que se va a crear.
     */
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
    /**
     * Elimina un coche de la base de datos.
     *
     * @param coche El coche que se va a eliminar.
     */
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

    /**
     * Elimina todas las filas relacionadas con un coche de la tabla PiezaCoche.
     *
     * @param coche El coche del que se eliminarán las piezas.
     */
        public void eliminarPiezasDeCoche(Coche coche) {
            String sql = "DELETE FROM piezacoche WHERE Matricula = ?";
            
            try (Connection conn = Conexion.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                // Establecer el valor del parámetro Matricula en la consulta SQL
                statement.setString(1, coche.getMatricula());
                
                // Ejecutar la consulta para eliminar las filas relacionadas
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        /**
         * Asigna una pieza a un coche en la base de datos.
         *
         * @param pieza La pieza que se va a asignar al coche.
         * @param coche El coche al que se le va a asignar la pieza.
         */
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
	/**
     * Elimina una pieza de un coche en la base de datos.
     *
     * @param pieza La pieza que se va a eliminar del coche.
     * @param coche El coche del que se va a eliminar la pieza.
     */
	 public void eliminarPiezaDeCoche(Pieza pieza, Coche coche) {
	        String sql = "DELETE FROM PiezaCoche WHERE Matricula = ? AND Codigo = ?";
	        try (Connection conn = Conexion.getConnection();
	             PreparedStatement consulta = conn.prepareStatement(sql)) {
	            consulta.setString(1, coche.getMatricula());
	            consulta.setInt(2, pieza.getCodigo());
	            consulta.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 /**
	     * Actualiza los datos de un coche en la base de datos.
	     *
	     * @param coche El coche con los datos actualizados.
	     */
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