// zadani[cislo sloupce][cislo radku]
import java.util.Scanner;

public class SoustavaRovnic {

	public static void main(String[] args) {
		int pocetNeznamych = Integer.parseInt(args[0]);
		int koeficientyNeznamych[][] = new int[pocetNeznamych][pocetNeznamych];
		int vysledkyRovnic[] = new int[pocetNeznamych];
		Scanner sc = new Scanner(System.in);
		
		// nacti cisla do matice
		for (int i = 0; i < pocetNeznamych; i++) {
			for (int j = 0; j < pocetNeznamych; j++) {
				koeficientyNeznamych[j][i] = sc.nextInt(); // prohozeno, abych mohl izolovat sloupec
			}
			vysledkyRovnic[i] = sc.nextInt();
		}
		
		int matice[][] = new int[pocetNeznamych][pocetNeznamych];
		matice = koeficientyNeznamych.clone();
		int hlavniDeterminant = determinant(matice);
		System.out.printf("%d", hlavniDeterminant);
		
		sc.close();
	}
	
	public static int determinant(int[][] matice) {
		int determinant = 0;
		int velikost = matice.length;
		
		// smerem \ 
		for (int i = 0; i < velikost; i++) {
			int soucinUhlopricky = 1;
			for (int j = 0; j < velikost; j++) {
				soucinUhlopricky *= matice[j][(i + j) % velikost];
			}
			determinant += soucinUhlopricky;
		}
		
		// smerem /
		for (int i = 0; i < velikost; i++) {
			int soucinUhlopricky = 1;
			for (int j = 0; j < velikost; j++) {
				soucinUhlopricky *= matice[j][(i - j + velikost) % velikost];
			}
			determinant -= soucinUhlopricky;
		}
		return determinant;
	}

}
