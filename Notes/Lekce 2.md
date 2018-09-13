
# Příkazový řádek

## Obecné

Automatické doplnění pomocí `Tab`\
Výběh pomocí Upravy -> Označit, zkopírování pomocí `Enter`\
`<příkaz> > file.txt` uloží výstup do souboru místo zobrazení do konzole

## Základní příkazy

`dir` vypíše obsah adresáře\
. = současný adresář\
.. = o úroveň výš\
mezi složkami se přechází pomocí `\`\
- `dir /w` = zobrazení bez informací o poslední změně souborů

`cd` - změna adresáře\
`type`- zobrazení obsahu souboru

> alej.alisma.cz
```
dir "C:\Program Files\java\bin\*.exe" > C:\Users\student2\Documents\log.txt
```

# Programování
Pro Javu je potřeba compiler JDK\
`javac -version` vypíše verzi compileru\
Z kompilace vypadne soubor .class - kód, který lze spustit v programu JVM (Java Virtual Machine), respektive JRE (Java Runtime Environment) pomocí příkazu `java`
