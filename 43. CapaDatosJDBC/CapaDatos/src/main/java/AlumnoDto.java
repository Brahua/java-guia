
public class AlumnoDto {
    private int id;
    private String nombre;
    private String apellidos;
    private int telefono;
    private int dni;

    public AlumnoDto() {
    }

    public AlumnoDto(String nombre, String apellidos, int telefono, int dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
    }

    public AlumnoDto(int id, String nombre, String apellidos, int telefono, int dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno: " + this.id + ". " + this.nombre + " " + this.apellidos + " - " + this.dni;
    }
}
