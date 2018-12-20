import java.util.ArrayList;
import java.util.List;

public class Cetnost {
	public static void main(String[] args) {

		java.util.Scanner vstup = new java.util.Scanner(System.in);
		
		// Cetnost kazdeho cisla bude ulozena v listu "cetnosti" 
		// na stejnem indexu jako samotne cislo v listu "cisla"
		List<Integer> cisla = new ArrayList<Integer>();
		List<Integer> cetnosti = new ArrayList<Integer>();
		
		// Postupne cti jednotliva cisla na vstupu
		cteniVstupu:
		while (vstup.hasNextInt()) {
			int dalsiCislo = vstup.nextInt();
			// Pokud jiz cislo nekde v listu je, zvys jeho cetnost o 1
			for (int i = 0; i < cisla.size(); i++) {
				if (dalsiCislo == cisla.get(i)) {
					cetnosti.set(i, cetnosti.get(i) + 1);
					// Pokud jiz cislo v listu bylo a zvysili jsme jeho cetnost,
					// muzeme zbytek while cyklu preskocit a pokracovat s dalsim cislem na vstupu
					continue cteniVstupu;
				}
			}
			
			// Pokud zatim cislo v listu nebylo,
			// pridej ho na konec listu a nastav jeho cetnost na 1
			cisla.add(dalsiCislo);
			cetnosti.add(1);
		}
		
		vstup.close();
		
		while (cisla.size() > 0) {
			// Projdi list "cetnosti" a najdi index, na nemz se nachazi nejcetnejsi cislo
			int nejvyssiCetnost = 0;
			int indexNejcetnejsiho = 0;
			for (int i = 0; i < cetnosti.size(); i++) {
				if (cetnosti.get(i) > nejvyssiCetnost) {
					nejvyssiCetnost = cetnosti.get(i);
					indexNejcetnejsiho = i;
				}
			}
			
			// Vytiskni cislo na indexu s nejvyssi cetnosti
			System.out.printf("%dx %d\n", cetnosti.get(indexNejcetnejsiho), cisla.get(indexNejcetnejsiho));
			
			// Prave vytisknute cislo i jeho cetnost smaz z listu,
			// aby while cyklus v pristim prubehu nasel dalsi nejcetnejsi cislo v poradi
			cisla.remove(indexNejcetnejsiho);
			cetnosti.remove(indexNejcetnejsiho);
		}

	}
}