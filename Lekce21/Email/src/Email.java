import java.util.Scanner;

public class Email {

	public static String getHeader(String emailText) {
		Scanner sc = new Scanner(emailText);
		String output = "";
		
		int state = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (state == 0) { // before sender
				if (line.startsWith("From:")) {
					state = 1;
				}
			}
			
			if (state == 1) { // sender
				output += line.substring("From: ".length()) + "\n";
				state = 2;
				continue;
			}
			
			if (state == 2) { // subject start
				output += line.substring("Subject: ".length()) + "\n";
				state = 3;
				continue;
			}
			
			if (state == 3) {
				if (line.startsWith("To:")) {
					break;
				}
			}
		}
		
		
		sc.close();
		return output;
	}
}
