public class Konstanty {
	
	public static final double pi = 3.141592653;
	
    public static void main(String[] args) {
		double polomer = Double.parseDouble(args[0]);
		System.out.printf("Obvod: %f\n", 2 * pi * polomer);
		System.out.printf("Obsah: %f\n", pi * polomer * polomer);
	}
}
