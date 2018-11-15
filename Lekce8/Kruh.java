public class Kruh {
    public static void main(String[] args) {
		int r = Integer.parseInt(args[0]); // polomer
		kruh(r);
    }
	
	public static boolean jeVKruhu(int x, int y, int r) {
		return (x*x + y*y <= r*r);
	}
	
	// vytiskni kruh
	public static void kruh(int r) {
		// souradnicovy system, stred = [0; 0]
		for (int x = -r; x <= r; x++) {
			for (int y = -r; y <= r; y++) {
				if (jeVKruhu(x, y, r)) {
					System.out.print("X");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}