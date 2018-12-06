public class Median {
    public static void main(String[] args) {
        // Prazdny seznam
        awh.IntList cisla = awh.IntList.create();
 
        // Nacteme vsechna cisla.
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextInt()) {
            cisla.add(sc.nextInt());
        }
 
        // Setridime a precteme prostredni prvek
        cisla.sort();
        int pulka = cisla.size() / 2;
        int median = cisla.get(pulka);
 
        System.out.printf("Median je %d.\n", median);
    }
}