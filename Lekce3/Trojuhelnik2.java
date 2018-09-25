public class Trojuhelnik2 {
    public static void main(String args[]) {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}