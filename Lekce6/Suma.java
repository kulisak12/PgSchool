public class Suma {
	public static void main(String args[]) {
		int suma = 0;
		// vytvor objekt scanneru
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (sc.hasNextInt()) { // dokud je dalsi vstup int
			int vstup = sc.nextInt();
			// zastav pri zadani 0
			if (vstup == 0) {
				break; // ukonci loop
			}
			// preskoc pokud je cislo zaporne
			else if (vstup < 0) {
				continue; // prejdi na dalsi iteraci
			}
			// pricti k vysledku
			else {
				suma += vstup;
			}
		}
		System.out.printf("Suma je %d.\n", suma);
	}
}
// existuje i hasNextDouble, nextDouble atd.