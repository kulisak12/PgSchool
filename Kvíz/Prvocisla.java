
public class Prvocisla {
	public static void main(String[] args) {
		int dolniLimit = Integer.parseInt(args[0]);
		int horniLimit = Integer.parseInt(args[1]);
		boolean[] cisla = new boolean[horniLimit + 1];
		
		for (int i = 0; i <= horniLimit; i++) {
			cisla[i] = true;
		}
		
		int nejvyssiPrvocislo = 2;
		while (nejvyssiPrvocislo <= horniLimit) {
			System.out.printf("%d \n", nejvyssiPrvocislo);
			for (int j = 2 * nejvyssiPrvocislo; j <= horniLimit; j += nejvyssiPrvocislo) {
				cisla[j] = false;
			}
			
			nejvyssiPrvocislo++;
			while (nejvyssiPrvocislo <= horniLimit && cisla[nejvyssiPrvocislo] == false) {
				nejvyssiPrvocislo++;
			}
		}
		
		int pocetPrvocisel = 0;
		// spocti pocet
		for (int i = dolniLimit; i <= horniLimit; i++) {
			if (cisla[i] == true) {
				pocetPrvocisel++;
			}
		}
		
		System.out.printf("%d", pocetPrvocisel);
	}
}