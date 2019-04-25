import java.util.Scanner;


public class ZalomeniTextu {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String zalomeno = zalomRadky(sc, 25);
		sc.close();
		System.out.print(zalomeno);
	}
	
	public static String zalomRadky(Scanner vstup, int maxDelka) {
		String vystup = "";
		String cache = "";
		
		while (vstup.hasNextLine()) {
			String radek = vstup.nextLine();
			if (radek.isEmpty()) {
				vystup += cache.trim() + "\n\n";
				cache = "";
			}
			else {
				Scanner slova = new Scanner(radek);
				while (slova.hasNext()) {
					String slovo = slova.next();
					if (cache.length() + slovo.length() <= maxDelka) {
						cache += " " + slovo;
					}
					else {
						vystup += cache.trim() + "\n";
						cache = slovo;
					}
				}
				slova.close();
			}
			
		}
		vystup += cache.trim();
		
		return vystup;
	}

}
