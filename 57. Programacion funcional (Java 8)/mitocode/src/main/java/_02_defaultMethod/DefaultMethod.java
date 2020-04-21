package _02_defaultMethod;

public class DefaultMethod implements PersonaA, PersonaB {
    // Al implementarse dos interfaces con el mismo metodo default obligatoriamente se tiene que implementar ese metodo.
    @Override
    public void caminar() {
        System.out.println("Hola Coders");
    }

    @Override
    public void hablar() {
        //PersonaB.super.hablar();
        System.out.println("Suscribanse Coders");
    }

    public static void main(String[] args) {
        DefaultMethod app = new DefaultMethod();
        app.hablar();
    }

}


