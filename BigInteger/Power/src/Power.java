import java.math.BigInteger;

public class Power {
	public static void main(String[] args) {
		BigInteger largeNum = power(BigInteger.valueOf(3), 2);
		System.out.print(largeNum.toString());
	}
	
	public static BigInteger power(BigInteger base, int exp) {
		BigInteger result = base;
		
		while (exp > 1) {
			result = result.multiply(result);
			exp /= 2;
			
			if (exp % 2 == 1) {
				result = result.multiply(base);
			}
			
		}
		
		return result;
	}
}
