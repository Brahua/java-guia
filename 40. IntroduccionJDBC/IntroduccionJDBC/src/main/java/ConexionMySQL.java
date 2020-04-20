import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    //Datos de conexion
    public static final String DATABASE = "PRUEBA";
    public static final String URL  = "jdbc:mysql://localhost:3306/" + DATABASE;
    public static final String USER = "root";
    public static final String PASSWORD = "admin";

    private Connection conexion;

    public ConexionMySQL() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
