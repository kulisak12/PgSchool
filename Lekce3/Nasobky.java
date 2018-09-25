public class Nasobky {
    public static void main(String args[]) {
        for (int i = 3; i <= 100; i += 3) {
            System.out.printf("%d ", i);
            if (i % (3 * 4) == 0) {
                System.out.println();
            }
        }
    }
}