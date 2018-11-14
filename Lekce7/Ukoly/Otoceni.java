public class Otoceni {
    public static void main(String[] args) {
        awh.IntList vstup = awh.IntList.create();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // nacitej vstup
        while (sc.hasNextInt()) {
            vstup.add(sc.nextInt());
        }

        // vypis zpet v opacnem poradi
        for (int i = vstup.size() - 1; i >= 0; i--) {
            System.out.printf("%d ", vstup.get(i));
        }
    }
}