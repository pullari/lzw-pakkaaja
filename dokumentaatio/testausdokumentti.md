#Testausdokumentti

Testauksessani käytän kokonaisuudessaan kahdeksaa erillistä tekstitiedostoa. Neljä
näistä ovat ihmisen kirjoittamia tarinoita ja toiset neljä taas algoritmilla au-
tomaattisesti generoituja mitä tahansa ASCII-merkkejä sisältäviä tiedostoja.
Kokonaisuuten ne siis antavat kuvan algoritmin toimivuudesta sekä teoksissa,
joissa merkkijonot toistuvat useasti ja teoksissa joissa ei. Tietokone generoidut 
tiedostot tein samankokoisiksi, kuin ihmisen kirjoittamat tiedostot.

Luettelo tiedostoista koostuu nimestä, pakkamattomasta koosta, pakatusta 
koosta, sekä ajoista, jotka kestivät pakkaamiseen ja purkuun, tässä 
järjestyksessä. Ajat ovat mitattu laskemalla keskiarvo kymmenestä saman 
tiedoston pakkaamisesta ja purusta, joita ennen on ohjelma on ko. syötteellä
ajettu kahteen kertaan, jotta ensimmäisen kerran hitaus jäisi tuloksista.

Ihmisen kirjoittamat tiedostot:
nimi | koko pakkaamattomana | koko pakattuna | pakkausaika (ms) | purkuaika (ms)
 
testiTiedosto.txt | 257 kt | 106 kt | 136,9 ms | 91,5 ms

test2.txt | 580 kt | 292 kt | 236,9 ms | 157,4 ms

2city11.txt | 770 kt | 382 kt | 273,6 ms | 173,3 ms

kjv.txt | 80630 kt | 33 845 kt | 15 123,5 ms | 6519,4 ms


Näissä tuloksissa keskimääräisesti algoritmi onnistuu pakkaamaan tiedoston noin 40-50 %
kokoon verrattuna alkuperäiseen kokoon. Tällaisessa tekstissä siis pakkaus onnistuu
tekstin koosta riippumatta noin hieman alle puoleen alkuperäisestä.

Tiedoston koon kasvaessa pakkaukseen ja purkamiseen kulutettu aika taas ei kasva 
samassa suhteessa kuin tiedoston koko. Koon tuplautuessa aika sekä purkuun ja
pakkaamiseen kasvaa vain noin 1,73 kertaiseksi ja kolminkertaistuessa noin 
1,9 - 2 kertaiseksi. Vastaavasti taas tiedostokoon 313,7 kertautuessa kulutettu 
aika pakkaamiseen kertautuu 110-kertaiseksi ja aika purkamiseen kertautuu vain 
70-kertaiseksi.

Tietokone generoidut tiedostot:
nimi | koko pakkaamattomana | koko pakattuna | pakkausaika (ms) | purkuaika (ms)
 
testFile1.txt | 257 kt | 286 kt | 170,2 ms | 124,4 ms

testFile2.txt | 580 kt | 640 kt | 232,9 ms | 190,4 ms

testFile3.txt | 770 kt | 852 kt | 253,6 ms | 217,7 ms

testFile4.txt | 80630 kt | 98953 kt | 17 312,5 ms | 15924,5 ms


Automaattisesti generoiduissa tiedostoissa pakkaukseen ja purkuun kulutetussa 
ajassa ei näy varsinaisesti merkittävää muutosta aiempiin testituloksiin 
verrattuna. Tekstin laadun vuoksi kuitenkin kaikki käytetyt ajat ovat hieman 
korkeampia, mutta kokoon suhteutettu kasvu esimerkiksi ei muutu merkittävästi.

Mielenkiintoisempi osa tuloksia ovatkin "pakkauksen" onnistuminen, jota mitataan
"pakatun" tiedoston kokona. Nyt nimittäin jokainen tiedosto pakkaamisen jälkeen 
onkin noin 10-11 % isompi, kuin ei pakattuna. Tämä aiheutuu siitä että, jotta 
pakkausalgoritmi säästäisi tilaa niin tulisi koodattavan merkkijonon pituuden 
olla yli 2 merkkiä, koska yksi kirjain on 8 bittiä ja käyttämäni koodit ovat 16 
bittiä. Nyt kuitenkin autogeneraatiossa erilaisia kahden merkin jonoja on 
255x255 = 65 025 kappaletta. Algoritmissa käyttämäni sanakirja voi sisältää 
vain noin 36 000 merkkijonoa ennen tyhjennystä. Siispä on huomattavasti epä-
todennäköisempää, että merkkijono, joka sinne lisätään on yli 2 merkkiä pitkä 
ja monet 8 bitin yksittäiset merkit koodataan 16 bittisiksi ja 16 bittiset 
merkkijonot säilyttävät pituutensa ja koko kasvaa. Algoritmi ei siis ole 
tehokas täysin satunnaisella syötteellä, ellei sanakirjan kokoa kasvata 
huikeasti.


