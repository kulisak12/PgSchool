public class Prazdny {
    public static void main(String[] args) {
        awh.Image obr = awh.Image.createEmpty(50, 50, awh.Color.GREEN);
        obr.saveToFile("zeleny.png");
    }
}