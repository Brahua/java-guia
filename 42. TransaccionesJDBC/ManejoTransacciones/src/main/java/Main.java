import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = ConnectionSQL.getConnection();
            //Revisamos si la conexion esta en modo autocommit, por default es autocommit == true
            if (connection.getAutoCommit()) { connection.setAutoCommit(false); }

            AlumnoJDBC alumnoJDBC = new AlumnoJDBC(connection);
            //alumnoJDBC.update("ROLANDO", "CASTILLO", 5683245, 3);
            //alumnoJDBC.insert("JHORMANNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", 985634782, 71234587, "HUAMAN");
            //alumnoJDBC.delete(4);
            alumnoJDBC.select();

            connection.commit();
        } catch (SQLException e) {
            try {
                System.out.println("::::::::: ROLLBACK :::::::::");
                e.printStackTrace();
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        // alumnoJDBC.insert("ANTONIO", 985634782, 75614835, "VELARDE");
        // alumnoJDBC.update("MIGUEL", "CASTILLO", 5683245, 2);
        //alumnoJDBC.delete(2);
        //System.out.println("------------------");
        //alumnoJDBC.select();
    }
}
