# Záplaty

Pokud soubor změním a změna není příliš velká, místo celé kopie souboru stačí uchovat jen záplatu.
```batch
diff -u file1.txt file2.txt // vypsání změn
diff -u file1.txt file2.txt >zaplata.patch // uložení záplaty
patch -p0 <zaplata.patch // aplikování záplaty
```