import java.math.BigInteger;

public class Power {
	public static void main(String[] args) {
		int base = Integer.parseInt(args[0]);
		int exp = Integer.parseInt(args[1]);
		BigInteger largeNum = power(BigInteger.valueOf(base), exp);
		System.out.print(largeNum.toString());
	}
	
	public static BigInteger power(BigInteger base, int exp) {
		BigInteger result = BigInteger.ONE;
		while (exp > 0) {
			if (exp % 2 == 1) {
				result = result.multiply(base);
			}
			
			base = base.multiply(base);
			exp /= 2;
		}
		
		return result;
	}
}
