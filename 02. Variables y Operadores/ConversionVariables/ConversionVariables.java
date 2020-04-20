package conversionvariables;

import java.util.Scanner;

public class ConversionVariables {

    public static void main(String[] args) {
        double valorPi = Double.parseDouble("3.14");
        System.out.println("valorPi = " + valorPi);

        char c = "hola".charAt(0);
        System.out.println("c = " + c);

        Scanner scanner = new Scanner(System.in);
        char caracter = scanner.nextLine().charAt(0);
        System.out.println("caracter = " + caracter);

        String valorPiTexto = String.valueOf(valorPi);
        System.out.println("valorPiTexto = " + valorPiTexto);

        String valorPiTexto2 = "" + valorPi;
        System.out.println("valorPiTexto2 = " + valorPiTexto2);

        byte b = 10;
        short s = b;

        short s2 = 15;
        byte b2 = (byte) (s2 + 1);
    }
    
}
