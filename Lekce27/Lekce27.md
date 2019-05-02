## Git workflow

Obecn� plat�, �e commity by m�ly b�t mal� a m�ly by b�t uskupeny do logick�ch celk�.

### Jeden po��ta�
Jenom pro historii zm�n. Pou��v� p��kazy jako `git init`, `git add`, `git commit`.

### V�ce po��ta��
Umo��uje sd�len� mezi v�cero po��ta�i, vyu��v� sd�len� server. Nav�c pou��v� `git clone`, `git push`, `git pull`.

### V�tve
U�ite�n�, pokud na projektu pracuje v�ce lid� nar�z. Vedle v�tve master lze vytvo�it dal�� v�tve. Ka�d� v�voj�� m��e pracovat ve sv� v�tvi na sv� ��sti, a kdy� je hotov, spoj� v�tev s masterem.

Pokud chceme pracovat jen na mal� ��sti, kter� nepot�ebuje m�nit zbytek, op�t sta�� vytvo�it novou v�tev. T�m se zlep�uje organizace.

Novou v�tev vytvo��me pomoc� `git branch`. P�es `git checkout` mohu p�ep�nat mezi v�tvemi. Kdy� chci v�tve sl�t, p�epnu se do nad�azen� v�tve a nap�u `git merge`.

#### Merge conflict
M��e se st�t, �e ve dvou v�tv�ch bude zm�n�n stejn� soubor. Pokud se z�platy nep�ekr�vaj�, Git to zvl�dne. Pokud se jedn� o zm�nu na stejn�m m�st�, je t�eba ru�n� vybrat jednu mo�nost.

Slit� v�tv� je vlastn� taky commit. Pokud neprojde, vlastn� zm�ny mus�me commitnout ru�n�.

### Velk� t�my
Typick�m p��kladem je fork (v z�sad� nov� v�tev). U�ivatel� maj� vlastn�m repozit��. Do hlavn�ho projektu *(upstream)* se pak daj� zm�ny p�el�t pomoc� pull request�. Pokud si chci vlastn� fork udr�ovat aktu�ln�, p�id�m si jej jako remote (jako origin). Pak za p��kazy jako `git fetch` p�id�m n�zev remotu, tedy upstream. V�tve m��u sl�vat i opa�n�m sm�rem, pr�v� t�m si st�hnu zm�ny v upstreamu.

## Historie

Kdy� se chci vr�tit do p�edchoz�ch commit� a vz�t si n�co z dan�ho souboru, je nejlep�� cel� repozit�� naklonovat, tam se posunout o p�r commit� a zp�t a otev��t ti druhou kopii souboru.

Pokud chci obnovit cel� soubor, posta�� `git revert`.