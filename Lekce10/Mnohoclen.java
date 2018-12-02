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
        int vysledek[] = new int[max(this.ziskejStupen(), m.ziskejStupen()) + 1];
        for (int i = 0; i < vysledek.length; i++) {
            vysledek[i] = 0;
        }

        for (int i = 0; i <= this.ziskejStupen(); i++) {
            vysledek[i] += this.koeficienty[i];
        }
        for (int i = 0; i <= m.ziskejStupen(); i++) {
            vysledek[i] += m.ziskejKoeficient(i);
        }
        koeficienty = vysledek;
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}