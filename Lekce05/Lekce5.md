## Double
Datový typ pro desetinná čísla. Převod na int je pomocí `(int)d`.

Jelikož jsou čísla reprezentována jako zlomky, mohou vznikat malé chyby. Při porovnávání tak nepoužíváme `==`, ale povolujeme malou chybu.

## Classpath
Dříve se nám ze souboru Prvni.java vytvořil Prvni.class. Pokud se posunu o adresář výš, nemůžu program spustit. Pokud to stejně potřebuju udělat, mohu použít příkaz `java -cp adresa\programu Prvni`.

Pomocí tohoto mohu použít externí knihovny, např. awh.jar. Tu pak přidám pomocí `javac -cp awh.jar;. Prvni` (tečka říká, že to pak hledá v tomhle adresáři). Program spustím pomocí `java -cp awh.jar;. Prvni`.

## AWH
Knihovna, pomocí které mohu jednoduše pracovat s obrázky.