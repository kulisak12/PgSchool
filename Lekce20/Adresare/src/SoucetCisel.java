import java.io.IOException;
import java.util.Scanner;
 
public class SoucetCisel {
 
    private static long sectiSoubor(String jmeno) {
        try {
            Scanner sc = new Scanner(java.nio.file.Paths.get(jmeno));
            long suma = 0;
            while (sc.hasNextLong()) {
                long cislo = sc.nextLong();
                if (cislo < 0) {
                	sc.close();
                    throw new NumberFormatException("Musi byt kladne!");
                }
                suma += cislo;
            }
            sc.close();
            return suma;
        } catch (IOException e) {
            return 0;
        }
    }
 
    public static void main(String args[]) {
        try {
            long celkovaSuma = 0;
            for (String soubor : args) {
                celkovaSuma += sectiSoubor(soubor);
            }
            System.out.printf("Celkovy soucet je %d.\n", celkovaSuma);
        } catch (NumberFormatException e) {
            System.out.printf("Nelze dokoncit: %s\n", e.getMessage());
        }
    }
}