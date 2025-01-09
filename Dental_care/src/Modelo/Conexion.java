
package Modelo;
import java.sql.*;

public class Conexion {
    
    public static Connection conectarBD(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_dc", "root", "");
            return cn;
        } catch (SQLException e){
            System.out.println("Error en conexión local "+e);
        }
        return (null);
    }
    
}
