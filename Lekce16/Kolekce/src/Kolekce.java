import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Kolekce {

	public static void main(String[] args) {
		// List
		Scanner sc = new Scanner(System.in);
		List<String> radky = new ArrayList<>();
		
		while (sc.hasNextLine()) {
			radky.add(sc.nextLine());
		}
		sc.close();
		
		for (int i = radky.size() - 1; i >= 0; i--) {
			System.out.println(radky.get(i));
		}
	}

}
