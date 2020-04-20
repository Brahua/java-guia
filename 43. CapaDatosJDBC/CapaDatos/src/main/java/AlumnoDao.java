import java.sql.SQLException;

public interface AlumnoDao {
    public void insert(AlumnoDto alumno) throws SQLException;
    public void update(AlumnoDto alumno) throws SQLException;
    public void delete(int idAlumno) throws SQLException;
    public void select() throws SQLException;
}
