
public class Seq {

	public static void main(String[] args) {
		String oddelovac = " ";
		int zacatek = 1;
		int konec;
		int krok = 1;
		int indexArgumentu = 0;
		
		// naparsuj parametry
		if (args[0].equals("-s")) {
			oddelovac = args[1];
			indexArgumentu = 2; // dalsi argumenty se posouvaji o 2
		}
		
		if (args.length == indexArgumentu + 1) {
			konec = Integer.parseInt(args[indexArgumentu]);
		}
		else {
			zacatek = Integer.parseInt(args[indexArgumentu]);
			if (args.length == indexArgumentu + 3) {
				krok = Integer.parseInt(args[indexArgumentu + 1]);
			}
			konec = Integer.parseInt(args[args.length - 1]);
		}
		
		vypisSekvenci(zacatek, krok, konec, oddelovac);
	}
	
	
	public static void vypisSekvenci(int zacatek, int krok, int konec, String oddelovac) {
		if (krok > 0) {
			for (int i = zacatek; i <= konec; i += krok) {
				if (i != zacatek) {
					System.out.printf("%s", oddelovac);
				}
				System.out.printf("%d", i);
			}
		}
		
		else if (krok < 0) {
			for (int i = zacatek; i >= konec; i += krok) {
				if (i != zacatek) {
					System.out.printf("%s", oddelovac);
				}
				System.out.printf("%d", i);
			}
		}
		
		else {
			System.out.println("Krok nemuze byt 0!");
		}
	}
}
