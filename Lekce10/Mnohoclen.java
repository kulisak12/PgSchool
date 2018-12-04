public class Mnohoclen {
    private int koeficienty[];
    public Mnohoclen(int ... koeficienty) {
        this.koeficienty = koeficienty;
    }

    public int ziskejKoeficient(int stupen) {
        return koeficienty[stupen];
    }

    public int ziskejStupen() {
        int stupen = koeficienty.length - 1;
        while (koeficienty[stupen] == 0) {
            stupen--;
        }
        return stupen;
    }

    public String ziskejZapis() {
        String zapis = "";
        for (int i = ziskejStupen(); i >=0;  i--) {
            zapis += String.format("%dx^%d ", koeficienty[i], i);
        }
        return zapis;
    }

    public void secti(Mnohoclen m) {
        // vytvor pole pro uchovani vysledku
        int pocetClenuVysledku = max(this.ziskejStupen(), m.ziskejStupen()) + 1;
        int vysledek[] = new int[pocetClenuVysledku];
        for (int i = 0; i < pocetClenuVysledku; i++) {
            vysledek[i] = 0;
        }
        
        // pricti oba mnohocleny
        for (int i = 0; i <= this.ziskejStupen(); i++) {
            vysledek[i] += this.ziskejKoeficient(i);
        }
        for (int i = 0; i <= m.ziskejStupen(); i++) {
            vysledek[i] += m.ziskejKoeficient(i);
        }
        koeficienty = vysledek;
    }

    public void odecti(Mnohoclen m) {
        // vytvor pole pro uchovani vysledku
        int pocetClenuVysledku = max(this.ziskejStupen(), m.ziskejStupen()) + 1;
        int vysledek[] = new int[pocetClenuVysledku];
        for (int i = 0; i < pocetClenuVysledku; i++) {
            vysledek[i] = 0;
        }
        
        // pricti prvni, odecti druhy mnohoclen
        for (int i = 0; i <= this.ziskejStupen(); i++) {
            vysledek[i] += this.ziskejKoeficient(i);
        }
        for (int i = 0; i <= m.ziskejStupen(); i++) {
            vysledek[i] -= m.ziskejKoeficient(i);
        }
        koeficienty = vysledek;
    }

    public void vynasob(Mnohoclen m) {
        // vytvor pole pro uchovani vysledku
        int pocetClenuVysledku = this.ziskejStupen() * m.ziskejStupen + 1;
        int vysledek[] = new int[pocetClenuVysledku];
        for (int i = 0; i < pocetClenuVysledku; i++) {
            vysledek[i] = 0;
        }
        
        // kazdy clen prvniho mnohoclenu vynasob celym druhym mnohoclenem
        for (int i = 0; i <= this.ziskejStupen(); i++) {
            for (int j = 0; j <= m.ziskejStupen(); j++) {
                vysledek[i + j] += this.ziskejKoeficient(i) + m.ziskejKoeficient(j);
            }
        }
        koeficienty = vysledek;
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
