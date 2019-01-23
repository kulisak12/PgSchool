import cz.alisma.alej.prog.QuadraticEquationGenerator;
import cz.alisma.alej.prog.QuadraticEquationPrinter;

public class KvadratickaRovnice {
	public static class HtmlPrinter implements QuadraticEquationPrinter {
		public void printHeader(int count) {
			System.out.println("Header");
		}
	    public void printEquation(int a, int b, int c, int x1, int x2) {
	    	
	    }
	    public void printFooter() {
	    	System.out.println("Footer");
	    }
	}
	
    public static void main(String[] args) {
        QuadraticEquationPrinter printer = new HtmlPrinter();
        // QuadraticEquationPrinter printer = new ScreenPrinter();
 
        QuadraticEquationGenerator.generate(10, printer);
    }
}