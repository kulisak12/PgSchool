
public class Mocniny {
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		
		int soucet = 0;
		
		int x = 3;
		while (x * x < limit) {
			soucet += x * x;
			x += 3;
		}
		
		System.out.printf("%d", soucet);
	}
}