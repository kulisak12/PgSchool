
public class Pascal { // ja teda radsi Javu nez Pascal

	public static final int pocetZnakuNaCislo = 4;
	
	public static void main(String[] args) {
		int vyska = Integer.parseInt(args[0]);
		int vrstva[] = new int[vyska];
		for (int i = 0; i < vyska; i++) {
			vrstva[i] = 0;
		}
		
		for (int i = 0; i < vyska; i++) {
			rozsirVrstvu(vrstva, i);
			vytiskniVrstvu(vrstva, i + 1);
		}

	}
	
	public static void rozsirVrstvu(int[] vrstva, int velikostVrstvy) {
		if (velikostVrstvy == 0) {
			vrstva[0] = 1;
		}
		// vytvor dalsi vrstvu sectenim koeficientu
		else {
			for (int i = velikostVrstvy; i > 0; i--) {
				vrstva[i] += vrstva[i - 1];
			}
		}
	}
	
	public static void vytiskniVrstvu(int[] vrstva, int velikostVrstvy) {
		int celkovaSirka = vrstva.length;
		// zarovnani na stred
		for (int i = 0; i < celkovaSirka - velikostVrstvy; i++) {
			System.out.print("  ");
		}
		
		// cisla
		for (int i = 0; i < velikostVrstvy; i++) {
			System.out.printf("%s", pridejMezery(Integer.toString(vrstva[i]), pocetZnakuNaCislo));
		}
		
		System.out.println();
	}
	
	public static String pridejMezery(String cislo, int celkemZnaku) {
		int mezerPred = (celkemZnaku - cislo.length()) / 2;
		int mezerZa = celkemZnaku - cislo.length() - mezerPred;
		
		String vystup = "";
		for (int i = 0; i < mezerPred; i++) {
			vystup += " ";
		}
		vystup += cislo;
		for (int i = 0; i < mezerZa; i++) {
			vystup += " ";
		}
		return vystup;
	}
}
