## Packages
= balíčky
Další stupeň rozdělení po metodě a třídě. Několik souvisejích tříd nasypu do balíčku, který bude zajišťovat danou funkčnost.

Balíček si pojmenuju tak, aby nedošlo ke kolizi. Konvence říká, že je jméno odvozeno od domovské stránky, takže třeba `cz.kulisak.pgu.obrazky`. Když je v balíčku více tříd, stále má každá vlastní soubor, které mají hlavičku.
```java
package cz.kulisak.pgu.obrazky

class Nahledy {
}
```

Základy jazyka jsou v balíčku `java.lang`, který je automaticky importován. Ostatní lze importovat přes `import java.util.Scanner` (java.util je package, Scanner je třída).

Při spouštění třídy definované v balíčku musím napsat celou cestu `java cz.kulisak.pgu.obrazky.Nahledy`. Kompilovat lze normálně.

## Vnořené třídy
Maličká třída, kterou chci používat pouze v rámci vnější třídy. Je vhodné ji uvést jako `private static`.

## Rozhraní
U programu chci, aby pouze nějak pracoval s uživatelem, ale implementace je skrytá. Při programování nemusím vědět, kam se data zapíšou, jenom bych rád řekl, že se *někam mají zapsat*. Podobně mohu udělat program, který bude modifikovat každý pixel obrázku, co definuju odděleně, klidně i pro více možností.

Místo třídy vytvořím interface. V něm jen zadefinuju nějakou metodu, kterou mohu poté implementovat několika různými způsoby *(je to něco jako virtuální třída, která využívá polymorfismu)*.
Rozhraní mohou mít i více metod.

### Použití místo dědění
Podle mistra Horkého nikdy není dědění nejlepším řešením, vždy se to dá lépe implementovat pomocí rozhraní. Jedno rozhraní v sobě bude mít proměnnou podřazeného rozhraní. Tím pádem se nestane, že by třídy dědily mnoho metod, které by vlastně neměly mít. Umožňuje mi to i lépe vyřešit případ, kdy bych rád vytvořil objekt, který je kombinací vícero rozhraní.