package manejocolecciones;

import java.util.*;

public class ManejoColecciones {

    public static void main(String args[]) {
        EjemploSet.probarHashSet();
    }

    public static class EjemploList {
        public static void probarArrayList(){
            long inicio1 = System.currentTimeMillis();
            List<Integer> lista = new ArrayList();
            for (int i = 0; i < 10000; i++) {
                lista.add(i);
            }
            long fin1 = System.currentTimeMillis();

            System.out.println(fin1-inicio1);

            //Mejor rendimiento
            long inicio2 = System.currentTimeMillis();
            List<Integer> lista2 = new ArrayList(10000);
            for (int i = 0; i < 10000; i++) {
                lista2.add(i);
            }
            long fin2 = System.currentTimeMillis();

            System.out.println(fin2-inicio2);
        }

        public static void probarLinkedList() {
            /*LinkedList es similar al ArrayList
            * La diferencia resalta en los metodos add, get y remove.
            * LinkedList --> get() mas rápido.
            * ArrayList --> add() y remove() más rapido.
            * */
            List<String> lista = new LinkedList();
            lista.add("Josue");
            lista.add("Bravo");
            lista.add("Huaman");
        }
    }

    public static class EjemploMap {
        public static void probarHashMap() {
            //El resultado que tenemos es el siguiente, en el que vemos que nos da los objetos sin un "orden lógico":
            Map<Integer, String> map = new HashMap<Integer, String>();
            map.put(1, "Casillas");
            map.put(15, "Ramos");
            map.put(3, "Pique");
            map.put(5, "Puyol");
            map.put(11, "Capdevila");
            map.put(14, "Xabi Alonso");
            map.put(16, "Busquets");
            map.put(8, "Xavi Hernandez");
            map.put(18, "Pedrito");
            map.put(6, "Iniesta");
            map.put(7, "Villa");

            // Imprimimos el Map con un Iterador
            Iterator it = map.keySet().iterator();
            while(it.hasNext()){
                Integer key = (Integer) it.next();
                System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
            }
        }

        public static void probarTreeMap(){
            //El resultado que tenemos es el siguiente en el que vemos que nos ordena los objetos por clave en "orden natural":
            Map<Integer, String> treeMap = new TreeMap<Integer, String>();
            treeMap.put(1, "Casillas");
            treeMap.put(15, "Ramos");
            treeMap.put(3, "Pique");
            treeMap.put(5, "Puyol");
            treeMap.put(11, "Capdevila");
            treeMap.put(14, "Xabi Alonso");
            treeMap.put(16, "Busquets");
            treeMap.put(8, "Xavi Hernandez");
            treeMap.put(18, "Pedrito");
            treeMap.put(6, "Iniesta");
            treeMap.put(7, "Villa");

            // Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
            Iterator it = treeMap.keySet().iterator();
            while(it.hasNext()){
                Integer key = (Integer) it.next();
                System.out.println("Clave: " + key + " -> Valor: " + treeMap.get(key));
            }
        }

        public static void probarLinkedHashMap() {
            // El resultado que tenemos es el siguiente en el que vemos que nos ordena los objetos tal y como los hemos ido introduciendo.
            Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
            linkedHashMap.put(1, "Casillas");
            linkedHashMap.put(15, "Ramos");
            linkedHashMap.put(3, "Pique");
            linkedHashMap.put(5, "Puyol");
            linkedHashMap.put(11, "Capdevila");
            linkedHashMap.put(14, "Xabi Alonso");
            linkedHashMap.put(16, "Busquets");
            linkedHashMap.put(8, "Xavi Hernandez");
            linkedHashMap.put(18, "Pedrito");
            linkedHashMap.put(6, "Iniesta");
            linkedHashMap.put(7, "Villa");

            // Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
            Iterator it = linkedHashMap.keySet().iterator();
            while(it.hasNext()){
                Integer key = (Integer) it.next();
                System.out.println("Clave: " + key + " -> Valor: " + linkedHashMap.get(key));
            }
        }
    }

    public static class EjemploSet {
        public static void probarHashSet() {
            //No permite elementos repetidos y tiene un orden impredecible.
            Set<String> set = new HashSet<String>();
            set.add("d");
            set.add("g");
            set.add("a");
            set.add("f");

            for (String letra: set){
                System.out.println(letra);
            }
        }
    }
}
