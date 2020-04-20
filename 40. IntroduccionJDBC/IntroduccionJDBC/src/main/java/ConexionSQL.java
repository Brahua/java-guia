import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    //Datos de conexion
    public static final String DATABASE = "PRUEBA";
    public static final String URL  = "jdbc:sqlserver://localhost:1433;database=" + DATABASE;
    public static final String USER = "sa";
    public static final String PASSWORD = "solmit2019**";

    private Connection conexion;

    public ConexionSQL() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
