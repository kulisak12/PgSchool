public class Ramecek {
    // rada X
    public static void vypisZnaky(int pocet) {
        for (int i = 0; i < pocet; i++) {
            System.out.print("X");
        }
    }

    // mezery pro vypln
    public static void vypisPrazdno(int pocet) {
        for (int i = 0; i < pocet; i++) {
            System.out.print(" ");
        }
    }

    // horni a dolni okraj
    public static void vykresliOkraj(int sirka, int velikostOkraje) {
        for (int i = 0; i < velikostOkraje; i++) {
            vypisZnaky(sirka);
            System.out.println();
        }
    }

    // jeden radek vnitrni casti
    public static void vykresliVnitrek(int sirka, int velikostOkraje) {
        vypisZnaky(velikostOkraje);
        vypisPrazdno(sirka);
        vypisZnaky(velikostOkraje);
    }

    public static void main(String args[]) {
        int vyska = 3;
        int sirka = 20;
        int velikostOkraje = 2;

        vykresliOkraj(sirka + 4, velikostOkraje);
        for (int i = 0; i < vyska; i++) {
            vykresliVnitrek(sirka, velikostOkraje);
            System.out.println();
        }
        vykresliOkraj(sirka + 4, velikostOkraje);
    }
}