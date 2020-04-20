public class Main {
    public static void main(String[] args) {
        AlumnoJDBC alumnoJDBC = new AlumnoJDBC();
        // alumnoJDBC.insert("ANTONIO", 985634782, 75614835, "VELARDE");
        // alumnoJDBC.update("MIGUEL", "CASTILLO", 5683245, 2);
        alumnoJDBC.delete(2);
        System.out.println("------------------");
        alumnoJDBC.select();
    }
}
