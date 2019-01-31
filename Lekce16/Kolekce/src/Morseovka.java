import java.util.Map;
import java.util.HashMap;

public class Morseovka {

	public static void main(String[] args) {
		Map<Character, String> abeceda = new HashMap<>();
		abeceda.put('a', ".-");
		abeceda.put('b', "-...");
		abeceda.put('c', "-.-.");
		
		if (args.length == 0) {
			System.out.println("Chci argument");
			return;
		}
		String zprava = args[0];
		for (char c : zprava.toCharArray()) {
			System.out.printf("%s/", abeceda.get(c));
		}
	}

}
