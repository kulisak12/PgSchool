import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Zip {

	public static void main(String[] args) throws IOException {
		Prepinace prepinace = new Prepinace(args);
		ZipFile zipSoubor = new ZipFile(prepinace.jmenoSouboru);
		
		if (prepinace.vypsatSoubory) {
			vypisObsah(zipSoubor, prepinace.zobrazitExtraInfo);
		}
		
		if (prepinace.odzipovat) {
			String mistoOdzipovani = ".";
			if (prepinace.zpusobOdzipovani == 1) {
				mistoOdzipovani = ziskejJmenoSouboru(zipSoubor.getName());
			}
			if (prepinace.zpusobOdzipovani == 2) {
				mistoOdzipovani = prepinace.mistoOdzipovani;
			}
			File cilovaSlozka = new File(mistoOdzipovani);
			odzipuj(zipSoubor, cilovaSlozka);
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
	
	public static void odzipuj(ZipFile zipSoubor, File cilovaSlozka) throws IOException {
		if (!cilovaSlozka.exists()) {
			cilovaSlozka.mkdirs();
		}
		
		byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipSoubor.getName()));
        ZipEntry souborVZipu = zis.getNextEntry();
        
        while (souborVZipu != null) {
            File novySoubor = new File(cilovaSlozka, souborVZipu.getName());
            new File(novySoubor.getParent()).mkdirs();
            novySoubor.createNewFile();
            FileOutputStream fos = new FileOutputStream(novySoubor);
            int delka;
            while ((delka = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, delka);
            }
            fos.close();
            souborVZipu = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
	}
	
	public static String ziskejJmenoSouboru(String cesta) {
		int indexLomitka = cesta.lastIndexOf("\\"); // muze byt i nenalezeno
		int indexTecky = cesta.lastIndexOf(".");
		return cesta.substring(indexLomitka + 1, indexTecky);
	}
}
