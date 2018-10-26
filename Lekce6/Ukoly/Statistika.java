public class Statistika {
	public static void main(String args[]) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		// odfiltruj prazdny vstup
		if (!sc.hasNextDouble()) {
			System.out.println("Zadny vstup");
			return;
		}
		
		// prvni cislo
		int pocet = 1;
		double soucet = sc.nextDouble();
		double min = soucet;
		double max = soucet;
		// dalsi cisla
		while(sc.hasNextDouble()) {
			double cislo = sc.nextDouble();
			soucet += cislo;
			if (cislo < min) {
				min = cislo;
			}
			if (cislo > max) {
				max = cislo;
			}
			pocet++;
		}

		// vypis vysledky
		System.out.printf("Soucet = %f\n", soucet);
		System.out.printf("Minimum = %f\n", min);
		System.out.printf("Maximum = %f\n", max);
		System.out.printf("Prumer = %f\n", soucet / pocet);
	}
}