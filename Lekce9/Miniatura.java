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
            String rozmery = args[1].split("x");
			
			// rozdel instrukce
			if (rozmery.length != 2) {
				System.out.println("Spatne zadane rozmery. Format je SIRKAxVYSKA(!)");
			}
			else {
				if (rozmery[1].endsWith("!")) {
					roztahnout = true;
					rozmery[1] = rozmery[1].substring(rozmery.length - 2);
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
 
 
		// preskaluj obrazek
        int novaSirka = pozadovanaSirka;
        int novaVyska = pozadovanaVyska;
        double pozadovanyPomer = (double)pozadovanaSirka / pozadovanaVyska; // double deleni
        
        awh.Image obr = awh.Image.loadFromFile(vstupniSoubor);
        int staraSirka = obr.getWidth();
        int staraVyska = obr.getHeight();
        double staryPomer = (double)staraSirka / staraVyska;
        
        if (pozadovanyPomer < staryPomer) { // obrazek je moc siroky
            novaVyska = (int)(novaSirka / staryPomer);
        }
        else { // obrazek je moc vysoky
            novaSirka = (int)(novaVyska * staryPomer);
        }
        
        // zmenseni na pozadovanou velikost
        obr.rescale(novaSirka, novaVyska);
        // vytvoreni sediveho pozadi
        awh.Image pozadi = awh.Image.createEmpty(pozadovanaSirka, pozadovanaVyska, awh.Color.GRAY);
        pozadi.pasteFrom(obr, (pozadovanaSirka - novaSirka) / 2, (pozadovanaVyska - novaVyska) / 2);
        pozadi.saveToFile(vystupniSoubor);
    }
}