public class Sude {
    public static void main(String args[]) {
        int input = Integer.parseInt(args[0]); // cislo z argumentu prikazu
        if (input % 2 == 0) {
            System.out.println("Sude!");
        }
        else {
            System.out.println("Liche!");
        }
    }
}