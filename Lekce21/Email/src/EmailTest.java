import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class EmailTest {
	@Test
    public void onlySenderAndSubject() {
        String text = "From: Odesilatel XY <XY@gmail.com>\r\n" + 
        		"Subject: Predmet e-mailu\r\n";
        assertEquals(Email.getHeader(text), "Odesilatel XY <XY@gmail.com>\nPredmet e-mailu");
    }
 
    @Test
    public void withoutMessage() {
        String text = "Delivered-To: vojtech.horky@alej.cz\r\n" + 
        		"Received: by 10.220.194.1 with SMTP id dw1csp292254vcb;\r\n" + 
        		"        Wed, 7 May 2014 03:53:25 -0700 (PDT)\r\n" + 
        		"From: Odesilatel XY <XY@gmail.com>\r\n" + 
        		"Subject: Predmet e-mailu\r\n" + 
        		"To: vojtech.horky@alej.cz\r\n" + 
        		"...\r\n" + 
        		"Content-Type: multipart/mixed; boundary=001a1134aa0e73b84704f8cd2ca0\r\n" + 
        		" \r\n" + 
        		" \r\n" + 
        		"--001a1134aa0e73b84704f8cd2ca0\r\n" + 
        		"Content-Type: text/plain; charset=UTF-8\r\n" + 
        		"Content-Transfer-Encoding: quoted-printable\r\n" + 
        		"...";
        assertEquals(Email.getHeader(text), "Odesilatel XY <XY@gmail.com>\nPredmet e-mailu");
    }
    
    @Test
    public void fullBlock() {
        String text = "Delivered-To: vojtech.horky@alej.cz\r\n" + 
        		"Received: by 10.220.194.1 with SMTP id dw1csp292254vcb;\r\n" + 
        		"        Wed, 7 May 2014 03:53:25 -0700 (PDT)\r\n" + 
        		"From: Odesilatel XY <XY@gmail.com>\r\n" + 
        		"Subject: Predmet e-mailu\r\n" + 
        		"To: vojtech.horky@alej.cz\r\n" + 
        		"...\r\n" + 
        		"Content-Type: multipart/mixed; boundary=001a1134aa0e73b84704f8cd2ca0\r\n" + 
        		" \r\n" + 
        		"Ahoj kamaráde! Jak se máš?" +
        		" \r\n" +
        		"Mìj se nejlépe." +
        		" \r\n" + 
        		"--001a1134aa0e73b84704f8cd2ca0\r\n" + 
        		"Content-Type: text/plain; charset=UTF-8\r\n" + 
        		"Content-Transfer-Encoding: quoted-printable\r\n" + 
        		"...";
        assertEquals(Email.getHeader(text), "Odesilatel XY <XY@gmail.com>\nPredmet e-mailu");
    }
    
    @Test
    public void longSubject() {
        String text = "From: Odesilatel XY <XY@gmail.com>\r\n" + 
        		"Subject: Prvni cast\r\n" +
        		"Druha cast" +
        		"To: vojtech.horky@alej.cz";
        assertEquals(Email.getHeader(text), "Odesilatel XY <XY@gmail.com>\nPrvni cast\nDruha cast");
    }
}