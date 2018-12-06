public class Odmocnina {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        System.out.printf("sqrt(%.5f) = %.5f", a, odmocnina(a, 1e-5));
    }

    public static double odmocnina(double a, double e) {
        double odhad = a;
        double posledni = 0;
        while (!jePresne(odhad - posledni, e)) {
            posledni = odhad;
            odhad = zpresni(odhad, a);
        }
        return odhad;
    }

    public static double zpresni(double x, double S) {
        return ((S / x) + x) / 2;
    }

    public static boolean jePresne(double rozdil, double e) {
        return (rozdil <= e && rozdil >= -e);
    }
}