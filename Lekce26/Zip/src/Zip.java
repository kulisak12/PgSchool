import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Zip {

	public static void main(String[] args) throws IOException {
		Prepinace prepinace = new Prepinace(args);
		ZipFile zipSoubor = new ZipFile(prepinace.jmenoSouboru);
		
		if (prepinace.vypsatSoubory) {
			vypisObsah(zipSoubor, prepinace.zobrazitExtraInfo);
		}
		
	}
	
	public static void vypisObsah(ZipFile zipSoubor, boolean zobrazitExtraInfo) {
		Enumeration<? extends ZipEntry> obsah = zipSoubor.entries();
		while (obsah.hasMoreElements()) {
			vypisInfoSouboru(obsah.nextElement(), zobrazitExtraInfo);
		}
	}
	
	public static void vypisInfoSouboru(ZipEntry soubor, boolean zobrazitExtraInfo) {
		System.out.print(soubor.getName());
		if (zobrazitExtraInfo) {
			Date datumZmeny = new Date(soubor.getTime());
			System.out.printf(" - %s", datumZmeny.toString());
			double velikost = (double) soubor.getSize();
			System.out.printf(" - %s", formatujVelikost(velikost));
			
		}
		System.out.println();
	}
	
	public static String formatujVelikost(double velikost) {
		final double krok = 1000;
		String[] jednotky = {"B", "kB", "MB", "GB", "TB"};
		int indexPredpony = 0;
		while (velikost > krok && indexPredpony < 4) {
			velikost /= krok;
			indexPredpony++;
		}
		
		return String.format("%.2f %s", velikost, jednotky[indexPredpony]);
	}
}
