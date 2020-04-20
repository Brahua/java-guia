package com.company;

public class Main {

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("hilo1");
        hilo1.start();

        Hilo hilo2 = new Hilo("hilo2");
        hilo2.start();
    }

    public static class Hilo extends Thread {
        private String name;

        public Hilo(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }
}
