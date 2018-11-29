## Více argumentů
`function(int... x)`
Dále argumenty používám jako pole pod jménem `x`.

## OOP
Používá objekty, což je speciální datový typ. Říká, že data by měly být blízko kódu, který s nimi manipuluje. Proměnné = atributy, funkce = metody.

Třídy umožňují skrýt implementaci a poskytnout funkčnost. Díky tomu není třeba vědět do podrobna všechny detaily, tomu se vznešeně říká *abstrakce*.

Nejdříve si vždy musím vytvořit samostatnou třídu (ty musí být definované v samostatném souboru, jehož název odpovídá jménu třídy). Dále mohu vytvářet objekty - instance této třídy. Nové objekty vytváříme pomocí `new`. Existují různé viditelnosti - `public, protected, public`. Mohu přidat slovo `static`, což znamená, že nepotřebují vlastní objekt, tedy nepracují s atributy. Jako konstruktor funguje metoda bez return typu se stejným jménem, jako třída. K danému objektu mohu v rámci něj přistupovat pomocí `this`.

Atributy a metody, které jsou označeny jako private, může používat jen třída samotná.