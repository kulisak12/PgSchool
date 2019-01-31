import java.util.Scanner;
 
public class Faktura {
    private static final String[] ADRESA_PRODEJCE = {
        "Prodejna a.s.",
        "Horni dolni 42",
        "123 45"
    };
 
    
    private static interface Tisk {
    	public void hlavicka();
    	public void zapati();
    	public void nadpis(String s);
    	public void text(String s);
    	public void zacniPolozky();
    	public void polozka(String nazev, int cena);
    	public void ukonciPolozky();
    }
    
    private static class DoKonzole implements Tisk {
    	@Override
    	public void hlavicka() {} // nic
    	
    	@Override
    	public void zapati() {} // nic
    	
    	@Override
    	public void nadpis(String s) {
    		System.out.printf("\n>>>> %s\n\n", s);
    	}
    	
    	@Override
    	public void text(String s) {
    		System.out.printf(" %s\n", s);
    	}

		@Override
		public void zacniPolozky() {} // nic
		
		@Override
		public void polozka(String nazev, int cena) {
			System.out.printf("%s", pridejTeckyZa(nazev, 30));
			System.out.printf("%s\n", pridejTeckyPred(Integer.toString(cena), 5));
		}

		@Override
		public void ukonciPolozky() {} // nic
		
		
		private String pridejTeckyZa(String s, int celkemZnaku) {
			for (int i = s.length(); i < celkemZnaku; i++) {
				s += ".";
			}
			return s;
		}
		
		private String pridejTeckyPred(String s, int celkemZnaku) {
			String tecky = "";
			for (int i = s.length(); i < celkemZnaku; i++) {
				tecky += ".";
			}
			return tecky + s;
		}
    }
    
    private static class DoHtml implements Tisk {
    	@Override
    	public void hlavicka() {
    		System.out.print("<!DOCTYPE html>\n"
    				+ "<html>\n"
    				+ "<head>\n"
    				+ "<title>Faktura</title>\n"
    				+ "<style>"
    				+ "td.cena {text-align: right;}"
    				+ "</style>"
    				+ "</head>\n\n"
    				+ "<body>\n");
    	}
    	
    	@Override
    	public void zapati() {
    		System.out.print("</body>\n"
    				+ "</html>\n");
    		
    	}
    	
    	@Override
    	public void nadpis(String s) {
    		System.out.printf("\n<h2>%s</h2>\n", s);
    	}
    	
    	@Override
    	public void text(String s) {
    		System.out.printf("<p>%s</p>\n", s);
    	}
    	
    	@Override
    	public void polozka(String nazev, int cena) {
    		System.out.printf("<tr><td>%s</td> <td class=\"cena\">%d</td></tr>\n", nazev, cena);
    	}

		@Override
		public void zacniPolozky() {
			System.out.print("<table>\n");
		}

		@Override
		public void ukonciPolozky() {
			System.out.print("</table>\n");
		}
    }
    
    
    
    public static void main(String args[]) {
    	Tisk tisk = new DoKonzole();
    	if (args.length > 0 && args[0].equals("html")) {
    		tisk = new DoHtml();
    	}
    	
        Scanner sc = new Scanner(System.in);
        
        tisk.hlavicka();
        tisk.nadpis("Informace o zakaznikovi");
        while (sc.hasNextLine()) {
            String radka = sc.nextLine().trim();
            if (radka.isEmpty()) {
                break;
            }
            tisk.text(radka);
        }
        sc.close();
 
        tisk.nadpis("Informace o prodejci");
        for (String s : ADRESA_PRODEJCE) {
            tisk.text(s);
        }
 
        tisk.nadpis("Zakoupene zbozi");
        tisk.zacniPolozky();
        int suma = 0;
        while (sc.hasNextLine()) {
            String radka = sc.nextLine().trim();
            if (radka.isEmpty()) {
            	continue;
            }
            
            String[] casti = radka.split(";", 2);
            int cena = Integer.parseInt(casti[0]);
            String nazev = casti[1];
            tisk.polozka(nazev, cena);
            suma += cena;
        }
        tisk.polozka("SOUCET", suma);
        tisk.ukonciPolozky();
        tisk.zapati();
    }
}