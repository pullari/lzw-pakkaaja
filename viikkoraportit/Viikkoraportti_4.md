#Viikkoraportti 4

Tällä viikolla toteutin hajautustaulun ylivuototaulukot dynaamisiksi. Asia ei 
ollut niin suoraviivainen, kuin olin odottanut ja törmäsin myös testaillessani 
muutamaan bugiin, jotka olivat jo olemassa olevassa koodissa. Esimerkiksi 
sanakirjan short-muotoiset koodit "vuosivat yli" ja short-koodit kääntyivät 
miinus merkkisiksi, aiheuttaen ongelmia. 

Sain kuitenkin kaikki löytämäni bugit korjattua ja ylivuototaulukot toimimaan 
oikein. Aloitin myös lisäämään aikaa mittaavia testejä koodiin, jotta aina
eri tiedostolla ajettaessa, tulisi näkyviin edes jonkinlaisia arvoja, millä 
arvioida algoritmien tehokkuutta.

Tällä viikolla eniten olen oppinut koodikatselmoinnista. Katselmoitavani koodi 
pyrki vastaamaan samaan ongelmaan, kuin omani ja vielä samalla algoritmilla 
(Lempel-Ziv-Welch). Oli siis mielenkiintoista nähdä miten joku muu oli toteut-
tanut "saman asian" ja eroja olikin huomattavasti.

Ensi viikolla pyrin saamaan aikaiseksi hyvän joukon tiedostoja, joilla testata
ohjelmaa, sekä graafisen käyttöliittymän, josta testitulokset näkyvät hyvin.

Työtunteja: ~7h 
