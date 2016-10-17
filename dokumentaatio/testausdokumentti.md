#Testausdokumentti

Testaukseeni tähän asti kuuluu kolme tekstitiedostoa, jotka löytyvät kansiosta 
"tiedostot" projektini rootista. 

Tällä hetkellä tiedostot ovat kaikki ihmisten kirjoittamia teoksia eri kokoisina
tiedostoina. Tämän on tarkoitus testata algoritmin toimivuutta erikokoisissa 
samankaltaisissa tiedostoissa ja etenkin sitä, kuinka sen kuluttama aika 
skaalautuu.

Luettelo tiedostoista koostuu nimestä, pakkamattomasta koosta, pakatusta 
koosta, sekä ajoista, jotka kestivät pakkaamiseen ja purkuun, tässä 
järjestyksessä. Ajat ovat mitattu laskemalla keskiarvo kymmenestä saman 
tiedoston pakkaamisesta ja purusta, joita ennen on ohjelma on ko. syötteellä
ajettu kahteen kertaan, jotta ensimmäisen kerran hitaus jäisi tuloksista.

Tiedostot:
nimi | koko pakkaamattomana | koko pakattuna | pakkausaika (ms) | purkuaika (ms)
 
testiTiedosto.txt | 257 kt | 106 kt | 136,9 ms | 91,5 ms \n
test2.txt | 580 kt | 292 kt | 236,9 ms | 157,4 ms \n
2city11.txt | 770 kt | 382 kt | 273,6 ms | 173,3 ms \n
kjv.txt | 80630 kt | 33 845 kt | 15 123,5 ms | 6519,4 ms

