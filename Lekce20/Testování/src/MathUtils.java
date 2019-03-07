public class MathUtils {
    public static int min(int... numbers) {
        int min = numbers[0];
        for (int num : numbers) {
        	if (num < min) {
        		min = num;
        	}
        }
        return min;
    }
}