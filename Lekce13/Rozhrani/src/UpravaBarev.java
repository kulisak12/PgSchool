public class UpravaBarev {
	// obecna sablona
    private static interface Prevod {
        public awh.Color preved(awh.Color vstup);
    }
    
    // implementace - cernobila
    private static class Sediva implements Prevod {
        public awh.Color preved(awh.Color vstup) {
            int sediva = (int)(
                0.299 * vstup.getRed()
                + 0.587 * vstup.getGreen()
                + 0.114 * vstup.getBlue()
            );
            return awh.Color.fromRgb(sediva, sediva, sediva);
        }
    }
    
    // implementace - svetlost
    private static class Zesvetleni implements Prevod {
        private final double pomer;
 
        public Zesvetleni(double pomer) {
            this.pomer = pomer;
        }
 
        private int slozka(int a) {
            long nova = Math.round(pomer * a);
            if (nova < 0) {
                return 0;
            } else if (nova > 255) {
                return 255;
            } else {
                return (int) nova;
            }
        }
 
        public awh.Color preved(awh.Color vstup) {
            return awh.Color.fromRgb(
                slozka(vstup.getRed()),
                slozka(vstup.getGreen()),
                slozka(vstup.getBlue())
            );
        }
    }
 
    public static void main(String[] args) {
        String typ = args[0];
        Prevod prevod; // objekt rozhrani
        // vyber podle argumentu
        if (typ.equals("sediva")) {
            prevod = new Sediva();
        } else if (typ.equals("svetlo")) {
            prevod = new Zesvetleni(2.0);
        } else if (typ.equals("tma")) {
            prevod = new Zesvetleni(0.5);
        } else {
            awh.Sys.die("Neznamy prevod.");
            return;
        }
 
        awh.Image obr = awh.Image.loadFromFile(args[1]);
        int sirka = obr.getWidth();
        int vyska = obr.getHeight();
 
 
        // projdi vsechny pixely a aplikuj zmenu
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                awh.Color puvodni = obr.getPixel(x, y);
                awh.Color nova = prevod.preved(puvodni);
                obr.setPixel(x, y, nova);
            }
        }
 
        obr.saveToFile(args[2]);
    }
}