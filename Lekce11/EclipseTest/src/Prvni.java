
public class Prvni {

	public static void main(String[] args) {
		System.out.println("Ahoj svete");
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		if (sc.hasNextInt()) {
			int vstup = sc.nextInt();
			System.out.printf("Napsal jsi %d\n", vstup);
		}
		
	}
}
