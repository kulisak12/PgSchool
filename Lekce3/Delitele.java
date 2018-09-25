public class Delitele {
    public static void main(String args[]) {
        int cislo = Integer.parseInt(args[0]);
        for (int i = 1; i <= cislo; i++) {
            if (cislo % i == 0) {
                System.out.printf("%d, ", i);
            }
        }
    }
}