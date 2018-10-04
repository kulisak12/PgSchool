public class Prevod {
    public static void main(String[] args) {
        awh.Image obr = awh.Image.loadFromFile(args[0]); // obrazek v argumentech
        System.out.printf("Velikost %s: %dx%d\n",
                args[0],
                obr.getWidth(),
                obr.getHeight()
        );
 
        obr.saveToFile(args[1]); // jmeno noveho obrazku
    }
}

// java -cp awh.jar;. Prevod zeleny.png novy.jpg