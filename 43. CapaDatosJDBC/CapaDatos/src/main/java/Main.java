import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = ConnectionSQL.getConnection();
            AlumnoDao alumnoDao = new AlumnoDaoImpl(connection);

            //AlumnoDto alumnoDto = new AlumnoDto("MIGUEL", "SIFUENTES", 54539744, 75413856);

            //alumnoDao.insert(alumnoDto);
            alumnoDao.select();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // alumnoJDBC.insert("ANTONIO", 985634782, 75614835, "VELARDE");
        // alumnoJDBC.update("MIGUEL", "CASTILLO", 5683245, 2);
        //alumnoJDBC.delete(2);
        //System.out.println("------------------");
        //alumnoJDBC.select();
    }
}
