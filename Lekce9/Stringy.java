public class Stringy {
	public static void main(String args[]) {
		String str = "Always Look on the Bright Side of Life";
		
		System.out.printf("%b\n", str.startsWith("Al"));
		System.out.printf("%s\n", str.toUpperCase());
		System.out.printf("%s\n", str.substring(7, 11));
		
		String[] casti = str.split("[lL]");
		System.out.printf("%s, %s, %s, %s\n", casti[0], casti[1], casti[2], casti[3]);
		
		String slepenec = String.format("Pay%dWin", 2);
		System.out.printf("%s\n", slepenec);
	}
}