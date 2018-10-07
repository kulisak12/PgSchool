public class nahledObrazku {
    public static void main(String[] args) {
        int pozadovanaSirka = 150;
        int pozadovanaVyska = 100;
        int novaSirka = pozadovanaSirka;
        int novaVyska = pozadovanaVyska;
        double pozadovanyPomer = (double)pozadovanaSirka / pozadovanaVyska; // double deleni
        
        awh.Image obr = awh.Image.loadFromFile(args[0]);
        int staraSirka = obr.getWidth();
        int staraVyska = obr.getHeight();
        double staryPomer = (double)staraSirka / staraVyska;
        
        if (pozadovanyPomer < staryPomer) { // obrazek je moc siroky
            novaVyska = (int)(novaSirka / staryPomer);
        }
        else { // obrazek je moc vysoky
            novaSirka = (int)(novaVyska * staryPomer);
        }
        
        // zmenseni na pozadovanou velikost
        obr.rescale(novaSirka, novaVyska);
        // vytvoreni sediveho pozadi
        awh.Image pozadi = awh.Image.createEmpty(pozadovanaSirka, pozadovanaVyska, awh.Color.GRAY);
        pozadi.pasteFrom(obr, (pozadovanaSirka - novaSirka) / 2, (pozadovanaVyska - novaVyska) / 2);
        pozadi.saveToFile(args[1]);
    }
}