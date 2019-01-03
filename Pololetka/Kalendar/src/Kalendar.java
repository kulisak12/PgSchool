import java.util.Calendar;

public class Kalendar {

	public static void main(String[] args) {
		Calendar datum = Calendar.getInstance(); // ziskej dnesni datum
		datum.set(Calendar.DAY_OF_MONTH, 1);
		
		if (args.length > 0) {
			int mesic = Integer.parseInt(args[0]);
			datum.set(Calendar.MONTH, mesic);
		}
		if (args.length == 2) {
			int rok = Integer.parseInt(args[1]);
			datum.set(Calendar.YEAR, rok);
		}
		
		vypisKalendarProMesic(datum);
	}
	
	public static void vypisKalendarProMesic(Calendar datum) {
		System.out.println("+----------------------+");
		String hlavicka = nazevMesice(datum.get(Calendar.MONTH)) + " " + datum.get(Calendar.YEAR);
		System.out.printf("| %s |\n", doplnMezerami(hlavicka, 20));
		System.out.println("+----------------------+");
		System.out.println("| Po Ut St Ct Pa So Ne |");
		
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
	
	public static String doplnMezerami(String s, int celkovaDelka) {
		return String.format("%1$-" + celkovaDelka + "s", s); 
	}

}
