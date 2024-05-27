package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PiezasCocheDAO {
    
    public void crearPiezas(String matricula) throws SQLException {
        String sql = "INSERT INTO PiezasCoche (Matricula, Pieza, Calidad, CaballosPieza, ManejoPieza) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
        	
        	String[] piezas = new String[4];
        	piezas[0] = "Motor";
        	piezas[1] = "Escape";
        	piezas[2] = "Neumaticos";
        	piezas[3] = "Frenos";
        	
        	for(int i = 0 ; i < piezas.length ; i++) {
        		
        		sentencia.setString(1, matricula);
            	sentencia.setString(2, piezas[i]);
            	sentencia.setString(3, "de serie");
            	sentencia.setDouble(4, 0);
            	sentencia.setDouble(5, 0);
            	sentencia.executeUpdate();
        	}
        	
        	
        }
    }

    
}
