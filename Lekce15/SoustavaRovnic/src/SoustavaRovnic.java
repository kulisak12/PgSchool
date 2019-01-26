// zadani[cislo radku][cislo sloupce]
import java.util.Scanner;

public class SoustavaRovnic {

	public static void main(String[] args) {
		int pocetNeznamych = Integer.parseInt(args[0]);
		int matice[][] = nactiVstup(pocetNeznamych);
		//vytiskniMatici(matice);
		
		for (int i = 0; i < pocetNeznamych - 1; i++) {
			pridejSloupecNul(matice, i);
		}
		
		int[] reseni = spoctiNezname(matice);
		vypisReseni(reseni);
	}
	
	public static void pridejSloupecNul(int matice[][], int promenna) {
		int pocetNeznamych = matice.length;
		int hlavniRovnice[] = matice[promenna];
		
		for (int i = promenna + 1; i < pocetNeznamych; i++) {
			int aktualniRovnice[] = matice[i];
			int delitel = nsd(hlavniRovnice[promenna], aktualniRovnice[promenna]);
			int koeficientHlavni = hlavniRovnice[promenna] / delitel;
			int koeficientAktualni = aktualniRovnice[promenna] / delitel;
			
			for (int j = 0; j < pocetNeznamych + 1; j++) {
				aktualniRovnice[j] = koeficientHlavni * aktualniRovnice[j] -
						koeficientAktualni * hlavniRovnice[j];
			}
		}
	};
	
	// nejvetsi spolecny delitel - Euklid
	public static int nsd(int a, int b) {
		// vem absolutni hodnotu cisel
		if (a < 0) {
			a *= - 1;
		}
		if (b < 0) {
			b *= -1;
		}
		
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static int[] spoctiNezname(int[][] matice) {
		int pocetNeznamych = matice.length;
		int[] nezname = new int[pocetNeznamych];
		for (int i = 0; i < pocetNeznamych; i++) {
			nezname[i] = 0;
		}
		
		for (int i = pocetNeznamych - 1; i >= 0; i--) {
			int soucetRovnice = 0;
			// secti zname hodnoty leve strany
			for (int j = 0; j < pocetNeznamych; j++) {
				if (j != i) {
					soucetRovnice += nezname[j] * matice[i][j];
				}
			}
			// pridej pravou stranu
			soucetRovnice = matice[i][pocetNeznamych] - soucetRovnice;
			// spocti neznamou
			nezname[i] = soucetRovnice / matice[i][i];
		}
		
		return nezname;
	}
	
	public static int[][] nactiVstup(int pocetNeznamych) {
		Scanner sc = new Scanner(System.in);
		int vstup[][] = new int[pocetNeznamych][pocetNeznamych + 1];
		// nacti cisla do matice
		for (int i = 0; i < pocetNeznamych; i++) {
			for (int j = 0; j < pocetNeznamych + 1; j++) {
				vstup[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		return vstup;
	}
	
	public static void vytiskniMatici(int[][] matice) {
		System.out.println("###");
		int pocetNeznamych = matice.length;
		for (int i = 0; i < pocetNeznamych; i++) {
			for (int j = 0; j < pocetNeznamych + 1; j++) {
				System.out.printf("%d ", matice[i][j]);
			}
			System.out.println();
		}
	}

	public static void vypisReseni(int[] reseni) {
		System.out.println("Reseni:");
		for (int i = 0; i < reseni.length; i++) {
			System.out.printf("x_%d = %d\n", i, reseni[i]);
		}
	}
}
