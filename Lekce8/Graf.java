public class Graf {
    public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		awh.IntList hodnoty = awh.IntList.create();
		
		// zapis vsechny hodnoty na vstupu
		while (sc.hasNextInt()) {
			hodnoty.add(sc.nextInt());
		}
		
		graf(hodnoty);
	}
	
	// vytiskni graf
	public static void graf(awh.IntList hodnoty) {
		for (int i = 0; i < hodnoty.size(); i++) {
			vytiskniRadek()
		}
	}
	
	public static void vytiskniRadek(int delka) {
		for (int i = 0; i < delka; i++) {
			System.out.print("#");
		}
		System.out.println();
	}
	
	public static int max(awh.IntList seznam) {
		int max = seznam.get(0);
		for (int i = 1; i < seznam.size(); i++) {
			if (seznam.get(i) > max) {
				max = seznam.get(i);
			}
		}
	}
	
	public static double koeficient(awh.IntList seznam, int limit) {
		int max = max(seznam);
		if (max > limit) {
			return (double)max / limit;
		}
		return 1;
	}
}