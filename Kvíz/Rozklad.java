
public class Rozklad {
	public static void main(String[] args) {
		int cislo = Integer.parseInt(args[0]);
		
		boolean[] sito = new boolean[cislo + 1];
		java.util.List<Integer> prvocisla = new java.util.ArrayList<Integer>();
		
		for (int i = 0; i <= cislo; i++) {
			sito[i] = true;
		}
		// najdi prvocisla
		int nejvyssiPrvocislo = 2;
		while (nejvyssiPrvocislo <= cislo) {
			System.out.printf("%d \n", nejvyssiPrvocislo);
			prvocisla.add(nejvyssiPrvocislo);
			for (int j = 2 * nejvyssiPrvocislo; j <= cislo; j += nejvyssiPrvocislo) {
				sito[j] = false;
			}
			
			nejvyssiPrvocislo++;
			while (nejvyssiPrvocislo <= cislo && sito[nejvyssiPrvocislo] == false) {
				nejvyssiPrvocislo++;
			}
		}
		
		
		// rozklad samotny
		int indexPrvocisla = 0;
		while (cislo > 1) {
			if (cislo % prvocisla.get(indexPrvocisla) == 0) {
				System.out.printf("%d,", prvocisla.get(indexPrvocisla));
				cislo /= prvocisla.get(indexPrvocisla);
			}
			else {
				indexPrvocisla++;
			}
		}
	}
}