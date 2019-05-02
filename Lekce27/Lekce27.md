## Git workflow

Obecnì platí, že commity by mìly být malé a mìly by být uskupeny do logických celkù.

### Jeden poèítaè
Jenom pro historii zmìn. Používá pøíkazy jako `git init`, `git add`, `git commit`.

### Více poèítaèù
Umožòuje sdílení mezi vícero poèítaèi, využívá sdílený server. Navíc používá `git clone`, `git push`, `git pull`.

### Vìtve
Užiteèné, pokud na projektu pracuje více lidí naráz. Vedle vìtve master lze vytvoøit další vìtve. Každý vývojáø mùže pracovat ve své vìtvi na své èásti, a když je hotov, spojí vìtev s masterem.

Pokud chceme pracovat jen na malé èásti, která nepotøebuje mìnit zbytek, opìt staèí vytvoøit novou vìtev. Tím se zlepšuje organizace.

Novou vìtev vytvoøíme pomocí `git branch`. Pøes `git checkout` mohu pøepínat mezi vìtvemi. Když chci vìtve slít, pøepnu se do nadøazené vìtve a napíšu `git merge`.

#### Merge conflict
Mùže se stát, že ve dvou vìtvích bude zmìnìn stejný soubor. Pokud se záplaty nepøekrývají, Git to zvládne. Pokud se jedná o zmìnu na stejném místì, je tøeba ruènì vybrat jednu možnost.

Slití vìtví je vlastnì taky commit. Pokud neprojde, vlastní zmìny musíme commitnout ruènì.

### Velké týmy
Typickým pøíkladem je fork (v zásadì nová vìtev). Uživatelé mají vlastním repozitáø. Do hlavního projektu *(upstream)* se pak dají zmìny pøelít pomocí pull requestù. Pokud si chci vlastní fork udržovat aktuální, pøidám si jej jako remote (jako origin). Pak za pøíkazy jako `git fetch` pøidám název remotu, tedy upstream. Vìtve mùžu slívat i opaèným smìrem, právì tím si stáhnu zmìny v upstreamu.

## Historie

Když se chci vrátit do pøedchozích commitù a vzít si nìco z daného souboru, je nejlepší celý repozitáø naklonovat, tam se posunout o pár commitù a zpìt a otevøít ti druhou kopii souboru.

Pokud chci obnovit celý soubor, postaèí `git revert`.