import cz.alisma.alej.prog.QuadraticEquationGenerator;
import cz.alisma.alej.prog.QuadraticEquationPrinter;

public class KvadratickaRovnice {
	public static class HtmlPrinter implements QuadraticEquationPrinter {
		public void printHeader(int count) {
			System.out.print("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<meta lang=\"cs\">\n"
					+ "<title>Kvadraticke rovnice</title>\n"
					+ "</head>\n\n"
					+ "<body>\n"
					+ "<table>\n"
					+ "<tr><th>Zadání</th><th>Øešení 1</th><th>Øešení 2</th></tr>\n");
		}
	    public void printEquation(int a, int b, int c, int x1, int x2) {
	    	System.out.printf("<tr><td>%s</td><td>%d</td><td>%d</td></tr>\n",
	    			polynomial(a, b, c), x1, x2);
	    }
	    public void printFooter() {
	    	System.out.print("</table>\n"
	    			+ "</body>\n"
	    			+ "</html>\n");
	    }
	    
	    private static String polynomial(int a, int b, int c) {
	    	return term(a, 2, false) + term (b, 1) + term (c, 0);
	    }
	    
	    private static String term(int coefficient, int power, boolean forceSign) {
	    	String term = "";
	    	if (coefficient == 0) {
	    		return "";
	    	}
	    	// znamenko
	    	else if (coefficient < 0) {
	    		term = "- ";
	    		coefficient *= -1;
	    	}
	    	else if (forceSign) {
	    		term = "+ ";
	    	}
	    	
	    	// cislo
	    	if (coefficient != 1) {
	    		term += Integer.toString(coefficient);
	    	}
	    	
	    	// x
	    	if (power == 0) {
	    		return term + " ";
	    	}
	    	else if (power == 1) {
	    		return term + "x ";
	    	}
	    	else {
	    		return term + String.format("x<sup>%d</sup> ", power);
	    	}
	    }
	    
	    private static String term(int coefficient, int power) {
	    	return term(coefficient, power, true);
	    }
	}
	
	public static class ScreenPrinter implements QuadraticEquationPrinter {
		private static final int polynomialLength = 20;
		private static final int solutionLength = 10;
		
		public void printHeader(int count) {
			System.out.printf("%s %s %s\n",
					rightPad("Zadani", polynomialLength),
					rightPad("Reseni1", solutionLength), "Reseni2");
		}
	    public void printEquation(int a, int b, int c, int x1, int x2) {
	    	System.out.printf("%s %s %s\n",
	    			rightPad(polynomial(a, b, c), polynomialLength),
	    			rightPad(x1, solutionLength), x2);
	    }
	    public void printFooter() {
	    	// nic
	    }
	    
	    private static String rightPad(int num, int totalLength) {
	    	return rightPad(Integer.toString(num), totalLength);
	    }
	    
	    private static String rightPad(String str, int totalLength) {
	    	return String.format("%1$-" + Integer.toString(totalLength) + "s", str);
	    }
	    
	    private static String polynomial(int a, int b, int c) {
	    	return term(a, 2, false) + term (b, 1) + term (c, 0);
	    }
	    
	    private static String term(int coefficient, int power, boolean forceSign) {
	    	String term = "";
	    	if (coefficient == 0) {
	    		return "";
	    	}
	    	// znamenko
	    	else if (coefficient < 0) {
	    		term = "- ";
	    		coefficient *= -1;
	    	}
	    	else if (forceSign) {
	    		term = "+ ";
	    	}
	    	
	    	// cislo
	    	if (coefficient != 1) {
	    		term += Integer.toString(coefficient);
	    	}
	    	
	    	// x
	    	if (power == 0) {
	    		return term + " ";
	    	}
	    	else if (power == 1) {
	    		return term + "x ";
	    	}
	    	else {
	    		return term + String.format("x^%d ", power);
	    	}
	    }
	    
	    private static String term(int coefficient, int power) {
	    	return term(coefficient, power, true);
	    }
	}
	
    public static void main(String[] args) {
        QuadraticEquationPrinter printer;
        // printer = new HtmlPrinter();
        printer = new ScreenPrinter();
 
        QuadraticEquationGenerator.generate(10, printer);
    }
}