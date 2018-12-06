public class Dvojobrazek {
    public static void main(String[] args) {
		// rozmery jednoho obrazku
        int sirka = 300;
        int vyska = 150;
 
        awh.Image levy = awh.Image.loadFromFile(args[0]);
        awh.Image pravy = awh.Image.loadFromFile(args[1]);
 
		// oba potrebuju mit stejne velike
        levy.rescale(sirka, vyska);
        pravy.rescale(sirka, vyska);
 
        awh.Image vysledek = awh.Image.createEmpty(sirka * 2, vyska, awh.Color.BLACK);
        vysledek.pasteFrom(levy, 0, 0);
        vysledek.pasteFrom(pravy, sirka, 0);
 
        vysledek.saveToFile(args[2]);
    }
}

// java -cp awh.jar;. Dvojobrazek obrazek1.jpg obrazek2.jpg novy.jpg