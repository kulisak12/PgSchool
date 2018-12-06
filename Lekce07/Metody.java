public class Metody {
    public static void main(String[] args) {
        // jiny pristup k tisku pyramidy
        int vyska = 5;
        for (int v = 1; v <= vyska; v++) {
            opakujZnak(' ', vyska - v);
            opakujZnak('X', v);
            System.out.println();
        }
    }

    // jeden cyklus v ramci metody
    public static void opakujZnak(char znak, int kolikrat) {
        while (kolikrat > 0) {
            System.out.printf("%c", znak);
            kolikrat--;
        }
    }
}