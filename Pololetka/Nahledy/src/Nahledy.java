/* Ukazka pouziti:
 * java -cp ../../../awh.jar;. Nahledy obrazek1.jpg vystup.jpg
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
	public static awh.Color barvaPozadi = awh.Color.GRAY;
	
	public static String vystupniSoubor = "nahledy-%03d.jpg";
	
	public static void main(String[] args) {
		List<String> vstupniObrazky = zpracujVstup(args);
		
		
		// vytvor nahled
		awh.Image obr = zmensiObrazek(awh.Image.loadFromFile(vstupniSoubor), pozadovanaSirka, pozadovanaVyska, roztahnout);
        awh.Image nahled = pridejPozadi(obr, pozadovanaSirka, pozadovanaVyska);
        nahled.saveToFile(vystupniSoubor);
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
			vystupniSoubor = hodnota;
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
				hodnota = hodnota.substring(hodnota.length() - 1);
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
	
	public static void nastavBarvuPozadi(String hexCode) {
		final int codeOf0 = "0".charAt(0);
		final int codeOfa = "a".charAt(0);
		
		int rgbCode = 0;
		for (int i = hexCode.length() - 1; i >= 0; i++) {
			rgbCode *= 16;
			
			int charCode = hexCode.charAt(i); // ciselny kod znaku
			if (charCode >= codeOf0 && charCode < codeOf0 + 10) { // cislo
				rgbCode += charCode - codeOf0; // nech cislo samotne
			}
			else if (charCode >= codeOfa && charCode < codeOfa + 6) { // a-f
				rgbCode += charCode - codeOfa + 10; // preved z sestnactkove do desitkove
			}
		}
		
		barvaPozadi = awh.Color.fromMergedRgb(rgbCode);
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
		awh.Image pozadi = awh.Image.createEmpty(sirka, vyska, barvaPozadi);
        pozadi.pasteFrom(obrazek, (sirka - obrazek.getWidth()) / 2, (vyska - obrazek.getHeight()) / 2);
        return pozadi;
	}

}
