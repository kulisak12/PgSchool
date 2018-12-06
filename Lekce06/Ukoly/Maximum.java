public class Maximum {
	public static void main(String args[]) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		// odfiltruj zvlastni chovani
		if (!sc.hasNextInt()) {
			System.out.println("Zadny vstup");
			return;
		}
		
		int max = sc.nextInt(); // dosavadni maximum
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