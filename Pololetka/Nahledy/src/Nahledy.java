/* Ukazka pouziti:
 * java -cp ../../../awh.jar;. Nahledy --matice=2x3 --vystup=matice_%d.jpg --nahled=50x50!
 * --pozadi=44ccff obr1.jpg obr2.jpg obr3.jpg obr4.png obr5.png obr6.png obr7.png
 */

import java.util.ArrayList;
import java.util.List;

public class Nahledy {
	// defautni hodnoty
	public static int pozadovanaSirka = 300;
	public static int pozadovanaVyska = 150;
	public static boolean roztahnout = false;
	
	public static int pocetSloupcuMatice = 4;
	public static int pocetRadkuMatice = 6;
	public static awh.Color barvaPozadi = awh.Color.BLACK;
	
	public static String vystupniFormat = "nahledy-%03d.jpg";
	
	public static void main(String[] args) {
		List<String> vstupniObrazky = zpracujVstup(args);
		
		int pocetMatic = podilZaokrouhlenNahoru(vstupniObrazky.size(), pocetSloupcuMatice * pocetRadkuMatice);
		for (int i = 0; i < pocetMatic; i++) {
			vytvorMatici(i, vstupniObrazky);
		}
	}
	
	// zpracuj prepinace a dej vstupni obrazky do listu
	public static List<String> zpracujVstup(String[] args) {
		List<String> vstupniObrazky = new ArrayList<String>();
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("--")) { // prepinac
				zpracujPrepinac(args[i].substring(2));
			}
			else {
				vstupniObrazky.add(args[i]);
			}
		}
		
		return vstupniObrazky;
	}
	
	public static void zpracujPrepinac(String prepinac) {
		String hodnota = prepinac.substring(prepinac.indexOf("=") + 1);
		
		if (prepinac.startsWith("vystup")) {
			vystupniFormat = hodnota;
		}
		
		else if (prepinac.startsWith("matice")) {
			int poziceX = hodnota.indexOf("x");
			pocetSloupcuMatice = Integer.parseInt(
				hodnota.substring(0, poziceX));
			pocetRadkuMatice = Integer.parseInt(
				hodnota.substring(poziceX + 1));
		}
		
		else if (prepinac.startsWith("nahled")) {
			if (hodnota.endsWith("!")) {
				roztahnout = true;
				hodnota = hodnota.substring(0, hodnota.length() - 1);
			}
			int poziceX = hodnota.indexOf("x");
			pozadovanaSirka = Integer.parseInt(
				hodnota.substring(0, poziceX));
			pozadovanaVyska = Integer.parseInt(
				hodnota.substring(poziceX + 1));
		}
		
		else if (prepinac.startsWith("pozadi")) {
			nastavBarvuPozadi(hodnota);
		}
		
		else {
            awh.Sys.die("Neplatny prepinac %s", hodnota);
        }
	}
	
	public static void nastavBarvuPozadi(String hexKod) {
		// ASCII kody znaku 0, a, A
		final int kod_0 = "0".charAt(0);
		final int kod_a = "a".charAt(0);
		final int kod_A = "a".charAt(0);
		
		int rgbKod = 0;
		for (int i = 0; i < 6; i++) {
			rgbKod *= 16;
			int charCode = hexKod.charAt(i); // ASCII kod daneho znaku
			
			if (charCode >= kod_0 && charCode < kod_0 + 10) { // pokud to je cislo
				rgbKod += charCode - kod_0; // nech cislo samotne
			}
			else if (charCode >= kod_a && charCode < kod_a + 6) { // a-f
				rgbKod += charCode - kod_a + 10; // preved z sestnactkove do desitkove
			}
			else if (charCode >= kod_A && charCode < kod_A + 6) { // A-F
				rgbKod += charCode - kod_A + 10;
			}
		}
		
		barvaPozadi = awh.Color.fromMergedRgb(rgbKod);
	}
	
	public static void vytvorMatici(int poradi, List<String> vstupniObrazky) {
		awh.Image matice = awh.Image.createEmpty(
			pocetSloupcuMatice * pozadovanaSirka, pocetRadkuMatice * pozadovanaVyska, barvaPozadi);
		
		// pridej upravene obrazky
		for (int i = 0; i < pocetRadkuMatice; i++) {
			for (int j = 0; j < pocetSloupcuMatice; j++) {
				int indexObrazku = indexObrazku(poradi, i, j);
				// nedostatek obrazku pro matici, do zbytku nic nevkladej
				if (indexObrazku >= vstupniObrazky.size()) {
					break;
				}
				
				awh.Image obr = awh.Image.loadFromFile(vstupniObrazky.get(indexObrazku));
				obr = zmensiObrazek(obr, pozadovanaSirka, pozadovanaVyska, roztahnout);
				obr = pridejPozadi(obr, pozadovanaSirka, pozadovanaVyska);
				matice.pasteFrom(obr, j * pozadovanaSirka, i * pozadovanaVyska);
			}
		}
		
		matice.saveToFile(String.format(vystupniFormat, poradi + 1));
	}
	
	public static int indexObrazku(int cisloMatice, int cisloRadku, int cisloSloupce) {
		int index = cisloMatice * pocetRadkuMatice;
		index += cisloRadku;
		index *= pocetSloupcuMatice;
		return index + cisloSloupce;
	}
	
	public static double min(double a, double b) {
		return (a < b) ? a : b;
	}
	
	public static int podilZaokrouhlenNahoru(int x, int y) {
		if (x % y == 0) {
			return x / y;
		}
		return x / y + 1;
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
		awh.Image pozadi = awh.Image.createEmpty(sirka, vyska, barvaPozadi);
        pozadi.pasteFrom(obrazek, (sirka - obrazek.getWidth()) / 2, (vyska - obrazek.getHeight()) / 2);
        return pozadi;
	}

}
