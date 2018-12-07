
public class PohybFigurky {
	
	public static final int pohyby[] = new int[] {3, 5};
	public static int potrebnePoctyTahu[];
	
	public static void main(String[] args) {
		int konecnePolicko = Integer.parseInt(args[0]) - 1;
		// vytvor pole pro uchovavani poctu kroku, ktere potrebuji,
		// abych se dostal na dane pole
		// nikdy se nemusim dostat prilis daleko za pozadovane pole
		potrebnePoctyTahu = new int[konecnePolicko + delkaNejdelsihoTahu() + 1];
		vynulujPole();
		
		// zacinam na prvnim poli
		potrebnePoctyTahu[0] = 0;
		int cisloTahu = 0;
		// rozsiruj dosah
		while (potrebnePoctyTahu[konecnePolicko] == -1) {
			cisloTahu++;
			dalsiTah(cisloTahu);
		}
		
		System.out.printf("%d tahu\n", cisloTahu);
	}

	public static void vynulujPole() {
		for (int i = 0; i < potrebnePoctyTahu.length; i++) {
			potrebnePoctyTahu[i] = -1;
		}
	}
	
	public static void dalsiTah(int cisloTahu) {
		for (int i = 0; i < potrebnePoctyTahu.length; i++) {
			if (potrebnePoctyTahu[i] == cisloTahu - 1) {
				zapisMozneTahy(i, cisloTahu);
			}
		}
	}
	
	public static void zapisMozneTahy(int odkud, int cisloTahu) {
		for (int i = 0; i < pohyby.length; i++) {
			if (odkud - pohyby[i] >= 0 && potrebnePoctyTahu[odkud - pohyby[i]] == -1) {
				potrebnePoctyTahu[odkud - pohyby[i]] = cisloTahu;
			}
			if (odkud + pohyby[i] < potrebnePoctyTahu.length && potrebnePoctyTahu[odkud + pohyby[i]] == -1) {
				potrebnePoctyTahu[odkud + pohyby[i]] = cisloTahu;
			}
		}
	}
	
	public static int delkaNejdelsihoTahu() {
		int nejdelsi = 0;
		for (int i = 0; i < pohyby.length; i++) {
			if (pohyby[i] > nejdelsi) {
				nejdelsi = pohyby[i];
			}
		}
		return nejdelsi;
	}

}
