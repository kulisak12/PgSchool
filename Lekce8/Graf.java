public class Graf {
    public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		awh.IntList hodnoty = awh.IntList.create();
		
		// error handling
		if (!sc.hasNextInt()) {
			System.out.println("Zadny vstup");
			return;
		}

		// zapis vsechny hodnoty na vstupu
		while (sc.hasNextInt()) {
			hodnoty.add(sc.nextInt());
		}
		
		graf(hodnoty);
	}
	
	// vytiskni graf
	public static void graf(awh.IntList hodnoty) {
		double k = koeficient(hodnoty, 60);
		for (int i = 0; i < hodnoty.size(); i++) {
			vytiskniRadek((int)(hodnoty.get(i) * k));
		}
	}
	
	public static void vytiskniRadek(int delka) {
		for (int i = 0; i < delka; i++) {
			System.out.print("#");
		}
		System.out.println();
	}
	
	// jak moc se maji hodnoty zmensit
	public static double koeficient(awh.IntList seznam, int limit) {
		int max = max(seznam);
		if (max > limit) {
			return (double)limit / max;
		}
		return 1;
	}
	
	// najdi nejvetsi prvek seznamu
	public static int max(awh.IntList seznam) {
		int max = 0;
		for (int i = 0; i < seznam.size(); i++) {
			if (seznam.get(i) > max) {
				max = seznam.get(i);
			}
		}
		return max;
	}
}