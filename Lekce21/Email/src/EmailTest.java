import static org.junit.Assert.*;
 
import org.junit.Test;

import java.util.Map;

public class EmailTest {
	@Test
    public void rozdeleni() {
        String email = "a: alpha\nb: bravo\nc: charlie\n\n...";
        Map<String, String> vysl = Email.nactiHlavicku(email);
        
        assertEquals("alpha", vysl.get("a"));
        assertEquals("bravo", vysl.get("b"));
        assertEquals("charlie", vysl.get("c"));
    }
	
	@Test
	public void rozdilneKlice() {
        String email = "a: zulu\nd: x-ray\n\n...";
        Map<String, String> vysl = Email.nactiHlavicku(email);
        
        assertEquals("zulu", vysl.get("a"));
        assertEquals("x-ray", vysl.get("d"));
    }
	
	@Test
	public void viceRadku() {
        String email = "a: zulu\n  pokracovanid: x-ray\n\n...";
        Map<String, String> vysl = Email.nactiHlavicku(email);
        
        assertEquals("zulu pokracovani", vysl.get("a"));
        assertEquals("x-ray", vysl.get("d"));
    }
}