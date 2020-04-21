package _02_defaultMethod;

public interface PersonaB {

    default public void hablar() {
        System.out.println("Saludos Coders - PersonaB");
    }
}
