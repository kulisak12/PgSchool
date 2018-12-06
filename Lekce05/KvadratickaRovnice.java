public class KvadratickaRovnice {
    public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double c = Double.parseDouble(args[2]);
		
		double eps = 0.0000001;
		
		double disk = b*b - 4*a*c;
		if (disk < 0) {
			System.out.println("Reseni neexistuje");
		}
		else if (disk < eps && disk > -eps) {
			System.out.printf("x = %f\n", -b / (2 * a));
		}
		else {
			double diskOdmocnina = Math.sqrt(disk);
			System.out.printf("x1 = %f, x2 = %f\n", (-b + diskOdmocnina) / (2 * a), (-b - diskOdmocnina) / (2 * a));
		}
    }
}