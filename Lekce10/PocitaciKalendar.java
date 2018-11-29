/*
Vypise datum, ktere nasleduje dany pocet dni po vstupnim datu.
*/

public class PocitaciKalendar {
    public static void main(String args[]) {
        if (args.length != 2) {
            awh.Sys.die("Spatne volani.");
        }
 
        String datum = args[0];
        int posun = Integer.parseInt(args[1]);
 
        if (datum.length() != 4 + 1 + 2 + 1 + 2) {
            awh.Sys.die("Pouzijte format RRRR-MM-DD.");
        }
 
        if (posun < 0) {
            awh.Sys.die("Umime pouze kladny posun.");
        }
 
        int rok = Integer.parseInt(datum.substring(0, 4));
        int mesic = Integer.parseInt(datum.substring(5, 7));
        int den = Integer.parseInt(datum.substring(8, 10));
 
        System.out.printf("%04d-%02d-%02d + %d dni = ", rok, mesic, den, posun);
 
        while (posun > 0) {
            int doKonce = dnuVMesici(rok, mesic) - den + 1;
            if (posun >= doKonce) {
                mesic++;
                if (mesic > 12) {
                    mesic = 1;
                    rok++;
                }
                den = 1;
                posun -= doKonce;
            } else {
                den += posun;
                posun = 0;
            }
        }
 
        System.out.printf("%04d-%02d-%02d.\n", rok, mesic, den);
    }
 
    public static boolean jePrestupny(int rok) {
        boolean delitelny4 = (rok % 4) == 0;
        boolean delitelny100 = (rok % 100) == 0;
        boolean delitelny400 = (rok % 400) == 0;
 
        if (delitelny400) {
            return true;
        } else if (delitelny100) {
            return false;
        } else {
            return delitelny4;
        }
    }
 
    /* mesic je číslo 1..12 */
    public static int dnuVMesici(int rok, int mesic) {
        int[] dny = new int[] { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mesic == 2) {
            if (jePrestupny(rok)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return dny[mesic - 1];
        }
    }
}