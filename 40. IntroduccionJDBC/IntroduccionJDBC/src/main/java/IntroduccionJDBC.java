import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IntroduccionJDBC {
    public static void main(String[] args) {
        ConexionSQL conexionSQL = new ConexionSQL();

        try {
            List<Alumno> listaAlumnos = new ArrayList<Alumno>();

            String query = "SELECT * FROM ALUMNOS";
            Statement statement = conexionSQL.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Alumno alumno = new Alumno();
                alumno.setId(resultSet.getInt("ID"));
                alumno.setNombre(resultSet.getString("NOMBRE"));
                alumno.setApellidos(resultSet.getString("APELLIDOS"));
                alumno.setDni(resultSet.getInt("DNI"));
                alumno.setTelefono(resultSet.getInt("TELEFONO"));
                listaAlumnos.add(alumno);
            }

            for (Alumno alumno: listaAlumnos) {
                System.out.println(alumno);
            }

            //Cerrar las conexiones
            statement.close();
            resultSet.close();
            conexionSQL.cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
