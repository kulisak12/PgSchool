/* Pouziti:
java Graf >graf.svg
[hodnoty]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graf {
	public static final int maxVyskaSloupce = 60;
	public static final int sirkaSloupce = 20;
	public static final int mistoKolemSloupce = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> hodnoty = new ArrayList<Integer>();
		
		// zadny vstup
		if (!sc.hasNextInt()) {
			System.out.println("Zadny vstup");
			sc.close();
			return;
		}

		// zapis vsechny hodnoty na vstupu do listu
		while (sc.hasNextInt()) {
			hodnoty.add(sc.nextInt());
		}
		
		
		generujSvgGraf(hodnoty);
		sc.close();
	}
	
	// vytiskni graf
	public static void generujSvgGraf(List<Integer> hodnoty) {
		// hlavicka
		System.out.printf("<?xml version=\"1.0\"?>\n" + 
				"<svg xmlns=\"http://www.w3.org/2000/svg\"\n" + 
				"    width=\"%d\" height=\"%d\">\n",
				hodnoty.size() * (sirkaSloupce + mistoKolemSloupce), // width
				maxVyskaSloupce + mistoKolemSloupce); // height
		
		// sloupce
		double k = koeficient(hodnoty);
		for (int i = 0; i < hodnoty.size(); i++) {
			// vytvor kod pro sloupec prepocitane vysky
			generujSloupec((int)(hodnoty.get(i) * k), i);
		}
		// ukonceni
		System.out.println("</svg>");
	}
	
	public static void generujSloupec(int vyska, int poradi) {
		System.out.printf("    <rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\"\n",
			poradi * (sirkaSloupce + mistoKolemSloupce), // x
			maxVyskaSloupce - vyska, // y
			sirkaSloupce, // width
			vyska); // height
		System.out.println("        fill=\"blue\" stroke=\"black\" stroke-width=\"2\"/>");
	}
	
	// jak moc se maji hodnoty zmensit
	public static double koeficient(List<Integer> seznam) {
		return (double)maxVyskaSloupce / max(seznam);
	}
	
	// najdi nejvetsi prvek seznamu
	public static int max(List<Integer> seznam) {
		int max = 0;
		for (int i = 0; i < seznam.size(); i++) {
			if (seznam.get(i) > max) {
				max = seznam.get(i);
			}
		}
		return max;
	}
}
