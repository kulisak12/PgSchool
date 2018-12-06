public class Kalkulacka {
	public static void main(String args[]) {
		System.out.printf("%d\n", naparsujSoucet(args[0]));
	}
	
	public static int naparsujSoucet(String vyraz) {
		String[] casti = vyraz.split("\\+");
		int vysledek = 0;
		for (int i = 0; i < casti.length; i++) {
			vysledek += naparsujNasobeni(casti[i]);
		}
		return vysledek;
	}
	
	public static int naparsujNasobeni(String vyraz) {
		String[] casti = vyraz.split("x");
		int vysledek = 1;
		for (int i = 0; i < casti.length; i++) {
			vysledek *= Integer.parseInt(casti[i]);
		}
		return vysledek;
	}
}