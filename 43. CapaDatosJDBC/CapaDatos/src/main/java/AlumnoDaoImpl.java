import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDaoImpl implements AlumnoDao{

    private Connection connection;
    private final String SQL_INSERT = "INSERT INTO ALUMNOS VALUES (?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ALUMNOS SET NOMBRE=?, APELLIDOS=?, TELEFONO=? WHERE ID=?";
    private final String SQL_DELETE = "DELETE FROM ALUMNOS WHERE ID=?";
    private final String SQL_SELECT = "SELECT * FROM ALUMNOS ORDER BY ID";

    public AlumnoDaoImpl() {
    }

    public AlumnoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insert(AlumnoDto alumno) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            int index = 1;
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);

            preparedStatement.setString(index++, alumno.getNombre());
            preparedStatement.setInt(index++, alumno.getTelefono());
            preparedStatement.setInt(index++, alumno.getDni());
            preparedStatement.setString(index++, alumno.getApellidos());

            System.out.println("EXECUTE :::: " + SQL_INSERT);
            preparedStatement.executeUpdate();
            System.out.println("Successful operation!");

        } finally {
            ConnectionSQL.close(preparedStatement);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }

    public void update(AlumnoDto alumno) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            int index = 1;
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(index++, alumno.getNombre());
            preparedStatement.setString(index++, alumno.getApellidos());
            preparedStatement.setInt(index++, alumno.getTelefono());
            preparedStatement.setInt(index++, alumno.getId());

            System.out.println("EXECUTE :::: " + SQL_UPDATE);
            preparedStatement.executeUpdate();
            System.out.println("Successful operation!");

        } finally {
            ConnectionSQL.close(preparedStatement);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }

    public void delete(int idAlumno) throws SQLException {
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

        } finally {
            ConnectionSQL.close(preparedStatement);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }

    public void select() throws SQLException {
        List<AlumnoDto> alumnos = new ArrayList<AlumnoDto>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.connection != null ? this.connection : ConnectionSQL.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            System.out.println("EXECUTE :::: " + SQL_SELECT);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                AlumnoDto alumno = new AlumnoDto();
                alumno.setId(resultSet.getInt("ID"));
                alumno.setNombre(resultSet.getString("NOMBRE"));
                alumno.setApellidos(resultSet.getString("APELLIDOS"));
                alumno.setDni(resultSet.getInt("DNI"));
                alumno.setTelefono(resultSet.getInt("TELEFONO"));
                alumnos.add(alumno);
            }

            for (AlumnoDto alumno: alumnos) {
                System.out.println(alumno);
            }
            System.out.println("Successful operation!");

        } finally {
            ConnectionSQL.close(preparedStatement);
            ConnectionSQL.close(resultSet);
            if (this.connection == null) {
                ConnectionSQL.close(connection);
            }
        }
    }
}
