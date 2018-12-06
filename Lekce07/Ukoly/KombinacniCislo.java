public class KombinacniCislo {
    public static void main(String[] args) {
        // K = n! / (k! * (n-k)!)
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int kombinace = faktorial(n) / (faktorial(k) * faktorial(n - k));
        System.out.printf("Existuje %d kombinaci\n", kombinace);
    }

    // n! = n * (n-1) * ... * 2 * 1
    public static int faktorial(int n) {
        int vysledek = 1;
        while (n > 0) {
            vysledek *= n;
            n--;
        }
        return vysledek;
    }
}