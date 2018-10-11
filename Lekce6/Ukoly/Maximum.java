public class Maximum {
	public static void main(String args[]) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int max;
		if (sc.hasNextInt()) {
			max = sc.nextInt(); // dosavadni maximum
		}
		else {
			System.out.println("Zadny vstup");
			return;
		}
		while (sc.hasNextInt()) {
			int cislo = sc.nextInt();
			// nastav nove maximum
			if (cislo > max) {
				max = cislo;
			}
		}
		System.out.printf("%d\n", max);
	}
}