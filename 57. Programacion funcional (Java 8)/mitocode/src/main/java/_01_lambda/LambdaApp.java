package _01_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LambdaApp {

    public void ordernar() {
        List<String> lista = new ArrayList<>();
        lista.add("MitoCode");
        lista.add("Code");
        lista.add("Mito");

        // JDK < 1.
//        Collections.sort(lista, new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//
//        });
//        
//        int contador = 0;
//        for (String elemento : lista) {
//            contador++;
//            System.out.println(contador + ". " + elemento);
//        }
        // Lambda
        Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

        AtomicInteger contador = new AtomicInteger(0);
        lista.stream().forEach((String elemento) -> {
            contador.set(contador.get() + 1);
            System.out.println(contador + ". " + elemento);
        });
    }

    public void calcular() {
        /*Operacion operacion = new Operacion() {
			@Override
			public double calcularPromedio(double n1, double n2) {
				return (n1 + n2) / 2;
			}
		};

		System.out.println(operacion.calcularPromedio(2, 3));*/

        Operacion operacion = (double x, double y) -> (x + y) / 2;
        System.out.println(operacion.calcular(2, 3));
    }

    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        app.ordernar();
        app.calcular();
    }

}
