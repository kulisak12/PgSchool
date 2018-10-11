public class Prvocislo {
	public static void main(String args[]) {
		int cislo = Integer.parseInt(args[0]);
		int i = 2;
		while (i < cislo) {
			if (cislo % i == 0) {
				System.out.println("Slozene cislo");
				return;
			}
			i++;
		}
		System.out.println("Prvocislo");
	}
}