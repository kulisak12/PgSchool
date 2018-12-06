
public class PohybFigurky {
	
	public static final int pohyby[] = new int[] {3, 5};
	public static int vzdalenostPoli[];
	
	public static void main(String[] args) {
		int konecnePolicko = Integer.parseInt(args[0]) - 1;
		vzdalenostPoli = new int[2 * konecnePolicko];
		for (int i = 0; i < vzdalenostPoli.length; i++) {
			vzdalenostPoli[i] = -1;
		}
		
		vzdalenostPoli[0] = 0;
		int cisloTahu = 0;
		while (vzdalenostPoli[konecnePolicko] == -1) {
			dalsiTah(cisloTahu);
		}
		System.out.printf("%d tahu\n", cisloTahu - 1);
	}
	
	public static void dalsiTah(int cisloTahu) {
		for (int i = 0; i < vzdalenostPoli.length; i++) {
			if (vzdalenostPoli[i] == cisloTahu) {
				zapisMozneTahy(i, cisloTahu);
			}
		}
		cisloTahu++;
	}
	
	public static void zapisMozneTahy(int odkud, int cisloTahu) {
		for (int i = 0; i < pohyby.length; i++) {
			if (odkud - pohyby[i] >= 0 && vzdalenostPoli[odkud - pohyby[i]] == -1) {
				vzdalenostPoli[odkud - pohyby[i]] = cisloTahu + 1;
			}
			if (odkud + pohyby[i] < vzdalenostPoli.length && vzdalenostPoli[odkud + pohyby[i]] == -1) {
				vzdalenostPoli[odkud + pohyby[i]] = cisloTahu + 1;
			}
		}
	}

}
