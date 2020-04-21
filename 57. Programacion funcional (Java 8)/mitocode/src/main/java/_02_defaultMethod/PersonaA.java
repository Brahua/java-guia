package _02_defaultMethod;

public interface PersonaA {

    public void caminar();

    default public void hablar() {
        System.out.println("Saludos Coders - PersonaA");
    }

}
