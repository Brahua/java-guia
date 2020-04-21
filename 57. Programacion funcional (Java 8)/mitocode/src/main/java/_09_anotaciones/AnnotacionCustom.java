package _09_anotaciones;

public @interface AnnotacionCustom {

    String nombre();

    boolean habilitado() default true;
}
