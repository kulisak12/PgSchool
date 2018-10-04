public class Desetiny {
	public static void main(String args[]) {
		int i = 12;
		double d = 0.53;
		d += 4.2;
		System.out.printf("%f\n", d);
		
		System.out.printf("%4d\n", i); // doplní zleva mezerami
		System.out.printf("%04d\n", i); // doplní zleva nulami
		System.out.printf("%6.2f\n", d); // celkem 6 znaků, z toho 2 za tečkou
		double input = Double.parseDouble(args[0]);
		//i = d; // chyba
		i = (int)input; // explicitní přetypování, zahození desetinné části
		System.out.printf("%d\n", i);
	}
}