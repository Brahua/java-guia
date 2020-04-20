package com.mitocode.tema10;

public class StringApp {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("MitoCode");
		/* Existe otra clase similar llamada StringBuffer que a diferencia
		del StringBuilder es usado para evitar la concurrencia es decir, solo
		se ejecuta en un hilo de ejecucion cuando StringBuilder podria ejecutarse
		en varios hilos. */
		
		//sb.append("MitoCode").append(" Tutos");
		
		//System.out.println(sb.toString());
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		System.out.println(sb.reverse());
		sb.setLength(0);
		System.out.println(sb.toString());
		
	}
}
