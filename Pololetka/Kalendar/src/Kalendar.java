import java.util.Calendar;
/* Poznamky pro sebe sama:
 * Calendar cisluje dny v mesici od 1, ale mesice od 0
 * Dny jsou cislovany od 1 od nedele
 * Pri pridani dne se sam pretoci na dalsi mesic, pokud to je treba
 */

public class Kalendar {
	
	public static final String nadpisyDnu =    "| Po Ut St Ct Pa So Ne |";
	public static final String vodorovnaCara = "+----------------------+";
	public static final int znakuNaCislo = 3;
	public static final int sirkaKalendare = 20; // bez okraju
	
	public static void main(String[] args) {
		Calendar datum = Calendar.getInstance(); // ziskej dnesni datum
		datum.set(Calendar.DAY_OF_MONTH, 1); // nastav prvniho
		datum.setFirstDayOfWeek(Calendar.MONDAY); // prvnim dnem v tydnu je pondeli
		
		if (args.length > 0) {
			int mesic = Integer.parseInt(args[0]) - 1; // mesice jsou cislovany od 0
			datum.set(Calendar.MONTH, mesic);
		}
		if (args.length == 2) {
			int rok = Integer.parseInt(args[1]);
			datum.set(Calendar.YEAR, rok);
		}
		
		vypisKalendarProMesic(datum);
	}
	
	public static void vypisKalendarProMesic(Calendar datum) {
		System.out.println(vodorovnaCara);
		String hlavicka = nazevMesice(datum.get(Calendar.MONTH)) + " " + datum.get(Calendar.YEAR);
		System.out.printf("| %s |\n", doplnMezeramiZezadu(hlavicka, sirkaKalendare));
		System.out.println(vodorovnaCara);
		System.out.println(nadpisyDnu);
		
		int mesic = datum.get(Calendar.MONTH);
		while (datum.get(Calendar.MONTH) == mesic) { // dokud jsem na stejnem mesici
			vypisTyden(datum);
		}
		
		System.out.println(vodorovnaCara);
	}
	
	public static void vypisTyden(Calendar datum) {
		int mesic = datum.get(Calendar.MONTH);
		System.out.print("|");
		
		for (int i = 0; i < 7; i++) {
			// dny pred zacatkem mesice
			if ((datum.get(Calendar.DAY_OF_WEEK) + 5) % 7 > i) { // konverze na ceske cislovani dnu v tydnu
				System.out.print("   ");
			}
			// dny po konci mesice
			else if (datum.get(Calendar.MONTH) != mesic) {
				System.out.print("   ");
			}
			// normalni dny
			else {
				int den = datum.get(Calendar.DAY_OF_MONTH);
				System.out.printf(doplnMezeramiZepredu(den, znakuNaCislo));
				datum.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		
		System.out.println(" |");
	}
	
	public static String nazevMesice(int poradiMesice) {
		String mesice[] = {
			"Leden",
			"Unor",
			"Brezen",
			"Duben",
			"Kveten",
			"Cerven",
			"Cervenec",
			"Srpen",
			"Zari",
			"Rijen",
			"Listopad",
			"Prosinec"};
		return mesice[poradiMesice];
	}
	
	public static String doplnMezeramiZezadu(String s, int celkovaDelka) {
		return String.format("%1$-" + celkovaDelka + "s", s); 
	}
	
	public static String doplnMezeramiZepredu(int cislo, int celkovaDelka) {
		return String.format("%1$" + celkovaDelka + "d", cislo); 
	}

}
