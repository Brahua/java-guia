import java.sql.*;

public class ConnectionSQL {

    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Driver driver = null;

    public static final String DATABASE = "PRUEBA";
    public static final String URL  = "jdbc:sqlserver://localhost:1433;database=" + DATABASE;
    public static final String USER = "sa";
    public static final String PASSWORD = "solmit2019**";

    //Para que no haya problemas al obtener la conexion de manera concurrente, se usa la palabra synchronized.
    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null) {
            try {
                driver = (Driver) Class.forName(JDBC_DRIVER).newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void close(ResultSet resultSet){
        try {
            if (resultSet != null) { resultSet.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement preparedStatement){
        try {
            if (preparedStatement != null) { preparedStatement.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection){
        try {
            if (connection != null) { connection.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
