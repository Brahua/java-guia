import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoJDBC {
    private Connection connection;
    private final String SQL_INSERT = "INSERT INTO ALUMNOS VALUES (?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ALUMNOS SET NOMBRE=?, APELLIDOS=?, TELEFONO=? WHERE ID=?";
    private final String SQL_DELETE = "DELETE FROM ALUMNOS WHERE ID=?";
    private final String SQL_SELECT = "SELECT * FROM ALUMNOS ORDER BY ID";

    public AlumnoJDBC() {
    }

    public AlumnoJDBC(Connection connection) {
        this.connection = connection;
    }

    public void insert(String nombre, int telefono, int dni, String apellidos){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            int index = 1;
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);

            preparedStatement.setString(index++, nombre);
            preparedStatement.setInt(index++, telefono);
            preparedStatement.setInt(index++, dni);
            preparedStatement.setString(index++, apellidos);

            System.out.println("EXECUTE :::: " + SQL_INSERT);
            preparedStatement.executeUpdate();
            System.out.println("Successful operation!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.close(preparedStatement);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }

    public void update(String nombre, String apellidos, int telefono, int idAlumno) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            int index = 1;
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(index++, nombre);
            preparedStatement.setString(index++, apellidos);
            preparedStatement.setInt(index++, telefono);
            preparedStatement.setInt(index++, idAlumno);

            System.out.println("EXECUTE :::: " + SQL_UPDATE);
            preparedStatement.executeUpdate();
            System.out.println("Successful operation!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.close(preparedStatement);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }

    public void delete(int idAlumno){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            int index = 1;
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);

            preparedStatement.setInt(index, idAlumno);

            System.out.println("EXECUTE :::: " + SQL_DELETE);
            preparedStatement.executeUpdate();
            System.out.println("Successful operation!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.close(preparedStatement);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }

    public void select() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            System.out.println("EXECUTE :::: " + SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Alumno alumno = new Alumno();
                alumno.setId(resultSet.getInt("ID"));
                alumno.setNombre(resultSet.getString("NOMBRE"));
                alumno.setApellidos(resultSet.getString("APELLIDOS"));
                alumno.setDni(resultSet.getInt("DNI"));
                alumno.setTelefono(resultSet.getInt("TELEFONO"));
                alumnos.add(alumno);
            }

            for (Alumno alumno: alumnos) {
                System.out.println(alumno);
            }
            System.out.println("Successful operation!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.close(preparedStatement);
            ConnectionSQL.close(resultSet);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }
}
