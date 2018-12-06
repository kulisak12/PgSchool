public class Mocniny {
    public static void main(String args[]) {
        int limit = Integer.parseInt(args[0]);
        for (int i = 1; i * i < limit; i++) {
            System.out.printf("%d ", i * i);
        }
    }
}