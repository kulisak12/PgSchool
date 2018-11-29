public class Miniatura {
    public static void main(String[] args) {
        String vstupniSoubor;
        String vystupniSoubor;
        int pozadovanaSirka = 300;
        int pozadovanaVyska = 150;
		boolean roztahnout = false;
		
		// bez zadani rozmeru
        if (args.length == 2) {
            vstupniSoubor = args[0];
            vystupniSoubor = args[1];
        }
		// s rozmery
		else if (args.length == 3) {
            vstupniSoubor = args[0];
            vystupniSoubor = args[2];
            String[] rozmery = args[1].split("x");
			
			// rozdel instrukce
			if (rozmery.length != 2) {
				System.out.println("Spatne zadane rozmery. Format je SIRKAxVYSKA(!)");
			}
			else {
				if (rozmery[1].endsWith("!")) {
					roztahnout = true;
					rozmery[1] = rozmery[1].substring(0, rozmery[1].length() - 1);
				}
				pozadovanaSirka = Integer.parseInt(rozmery[0]);
				pozadovanaVyska = Integer.parseInt(rozmery[1]);
			}
		}
		// spatny pocet argumentu
        else {
            awh.Sys.die("Pouziti: vstup.jpg [SxV] vystup.jpg");
            // Bez returnu si bude prekladac stezovat
            return;
        }
		
		// vytvor nahled
		awh.Image obr = zmensiObrazek(awh.Image.loadFromFile(vstupniSoubor), pozadovanaSirka, pozadovanaVyska, roztahnout);
        awh.Image nahled = pridejPozadi(obr, pozadovanaSirka, pozadovanaVyska);
        nahled.saveToFile(vystupniSoubor);
    }
	
	public static double min(double a, double b) {
		return (a < b) ? a : b;
	}
	
	public static awh.Image zmensiObrazek(awh.Image obrazek, int sirka, int vyska, boolean roztahnout) {
		if (!roztahnout) {
			// zmen sirku a vysku, aby byl zachovan pomer stran
			double koeficientSkalovani = min((double)sirka / obrazek.getWidth(), (double)vyska / obrazek.getHeight());
			sirka = (int)(obrazek.getWidth() * koeficientSkalovani);
			vyska = (int)(obrazek.getHeight() * koeficientSkalovani);
		}
		
		obrazek.rescale(sirka, vyska);
		return obrazek;
	}
	
	public static awh.Image pridejPozadi(awh.Image obrazek, int sirka, int vyska) {
		awh.Image pozadi = awh.Image.createEmpty(sirka, vyska, awh.Color.GRAY);
        pozadi.pasteFrom(obrazek, (sirka - obrazek.getWidth()) / 2, (vyska - obrazek.getHeight()) / 2);
        return pozadi;
	}
}