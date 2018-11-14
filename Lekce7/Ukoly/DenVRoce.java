public class DenVRoce {
    public static void main(String[] args) {
        int rok = Integer.parseInt(args[0]);
        int mesic = Integer.parseInt(args[1]) - 1; // uchovej jako index v rozmezi 0-11
        int den = Integer.parseInt(args[2]);
        int[] dnyMesicu = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (jePrestupny(rok)) {
            dnyMesicu[1]++; // zvetsi pocet dnu v unoru
        }

        // osetri spravnost vstupu
        if (mesic < 0 || mesic >= 12) {
            System.out.println("Nespravny mesic.");
            return;
        }
        if (den <= 0 || den > dnyMesicu[mesic]) {
            System.out.println("Nespravny den");
            return;
        };

        // secti dny
        int vysledek = 0;
        for (int i = 0; i < mesic; i++) {
            vysledek += dnyMesicu[i];
        }
        vysledek += den;
        System.out.printf("%d", vysledek);
    }

    public static boolean jePrestupny(int rok) {
        if (rok % 400 == 0) {return true;}
        if (rok % 100 == 0) {return false;}
        return (rok % 4 == 0);
    }
}