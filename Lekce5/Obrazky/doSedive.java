public class doSedive {
    public static void main(String[] args) {
        awh.Image obr = awh.Image.loadFromFile(args[0]);
        int sirka = obr.getWidth();
        int vyska = obr.getHeight();
		
		// pro kazdi pixel
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                awh.Color puvodni = obr.getPixel(x, y); // zjisti barvu pixelu
                int sediva = (int)(0.299 * puvodni.getRed() + 0.587 * puvodni.getGreen() + 0.114 * puvodni.getBlue());
				// zachovej jen modrou slozku
                awh.Color nova = awh.Color.fromRgb(
                    sediva,
                    sediva,
                    sediva
                );
                obr.setPixel(x, y, nova);
            }
        }
 
        obr.saveToFile(args[1]);
    }
}