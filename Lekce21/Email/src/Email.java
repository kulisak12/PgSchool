import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class Email {

	public static Map<String, String> nactiHlavicku(String emailText) {
		Scanner sc = new Scanner(emailText);
		
		Map<String, String> polozky = new HashMap<>();
		while (sc.hasNextLine()) {
			String radek = sc.nextLine();
			if (radek.isEmpty()) {
				break;
			}
			
			String casti[] = radek.split(": ", 2);
			if (casti.length != 2) {
				continue; // tise ignoruj, TODO nejake chybove hlaseni
			}
			
			polozky.put(casti[0], casti[1]);
		}
		
		sc.close();
		return polozky;
	}
}
