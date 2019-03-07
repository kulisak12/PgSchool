import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class MathUtilsTest {
 
    @Test
    public void singleNumber() {
        assertEquals(2, MathUtils.min(2));
    }
 
    @Test
    public void sortedNumbers() {
        assertEquals(3, MathUtils.min(3, 4, 5));
    }
 
    @Test
    public void unsortedNumbers() {
        assertEquals(1, MathUtils.min(4, 3, 7, 1, 5));
    }
 
    @Test
    public void zeroIsTheMinimum() {
        assertEquals(0, MathUtils.min(3, 0, 2));
    }
 
    @Test
    public void negativeNumbers() {
        assertEquals(-3, MathUtils.min(-1, -2, -3));
    }
 
    @Test
    public void multipleMinimums() {
        assertEquals(-42, MathUtils.min(-17, -42, -3, -42, 34));
    }
}