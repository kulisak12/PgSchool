// parsing and storing of parameters
public class Prepinace {
	String jmenoSouboru;
	boolean vypsatSoubory = false;
	boolean zobrazitExtraInfo = false;
	boolean odzipovat = false;
	int zpusobOdzipovani = 0; // 0 = here, 1 = folder here, 2 = custom
	String mistoOdzipovani;
	
	Prepinace(String[] prepinace) {
		jmenoSouboru = prepinace[0];
		int typNasledujihoPrepinace = 0; // 0 = parameter, 1 = value
		for (int i = 1; i < prepinace.length; i++) {
			typNasledujihoPrepinace = naparsujPrepinac(prepinace[i], typNasledujihoPrepinace);
		}
	}
	
	private int naparsujPrepinac(String prepinac, int typPrepinace) {
		if (typPrepinace == 0) {
			if (prepinac.equals("-t")) {
				vypsatSoubory = true;
				return 0;
			}
			else if (prepinac.equals("-l")) {
				zobrazitExtraInfo = true;
				return 0;
			}
			else if (prepinac.equals("-x")) {
				odzipovat = true;
				return 0;
			}
			else if (prepinac.equals("-D")) {
				zpusobOdzipovani = 1;
				return 0;
			}
			else if (prepinac.equals("-d")) {
				zpusobOdzipovani = 2;
				return 1;
			}
		}
		if (typPrepinace == 1) {
			mistoOdzipovani = prepinac;
		}
		return 0;
	}
}