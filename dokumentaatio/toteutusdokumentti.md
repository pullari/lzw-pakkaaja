#Toteutusdokumentti

Ohjelman perusosat, joista se koostuu ovat hajautustaulu, sanakirja ja purku- 
sekä pakkausalgoritmit.

##Hajautustaulu
Hajautustaulu on toteutettu staattisen kokoisena (32768, short:n maksimiarvo)
taulukko, joka sisältää ylivuototaulukoita, joihin avain-arvoparit laitetaan.
Ylivuototaulukot ovat dynaamisesti kasvavia.

Hajautusavaimena käytetään joko short muuttujaa, joka käytön jälkeen kasvaa
yhdellä (purku sanakirjassa), tai Integer muuttujaa, joka lasketaan lisäämällä
kyseessä olevan merkkijonon merkkien ascii-arvot yhteen ja ottamalla jakojään-
nös luvusta 32768. Jos jakojäännös palautuu negatiivisena se kerrotaan -1:llä.

Parin lisääminen, hakeminen ja tietyn avaimen olemassaolon tarkistamisen aika-
vaativuudet ovat kaikki sidonnaisia ylivuotolistan koosta. Periaatteessa siis
vaativuus on luokkaa O(laske hash + käy läpi listaa, kunnes löytyy oikea).
Parhaassa tapauksessa siis ne ovat luokkaa O(1) ja huonoimmassa O(n), mutta
todellisesti ne ovat yleensä huomattavasti lähempänä luokkaa O(1).

##Sanakirja
Sanakirja vastaa hajautustaulun ylläpidosta ja sinne asioiden lisäämisestä.
Sanakirja tyhjentää hajautustaulun, jos sen alkioiden määrä kasvaa liian 
isoksi ja alussa se alustaa hajautustauluun ASCII-aakkoston 255 merkkiä.

Kaikki sen operaatiot ovat joko luokkaa O(1) tai samaa luokkaa kuin hajautus-
taululla.

##Purku- ja pakkausalgoritmit
Nämä ovat toteutettu omina luokkinaan. Molemmissa luokissa konstruktorissa
hoidetaan tiedostojen ja lukijoiden avaaminen ja sanakirjojen tekeminen ja
alustaminen.

Muutoin ne sisältävät vain yhden metodin, jotka ovat compress tai decompress.

Nämä metodit käyvät läpi syötteen merkki kerrallaan ja operoivat sanakirjaa 
samalla. Ne ovat siis aikavaativuusluokka O(n).

##Muuta

Tilavaativuuksista sanottakoon, että ainoa asia, joka vaatii tilaa dynaami-
sesti, ovat ylivuotolistat. Kaikki muu tilaa vievä on joko ennaltamäärätyn
kokoista tai yksittäisiä muuttujia. Täten tilavaativuus koko ohjelmalla 
on luokkaa O(n), mutta se ei reaalitilanteessa kasva valtavaksi.

Mitä tulee aika- ja tilavaativuuteen olen mielestäni päässyt kurssin alussa 
asettamiini tavoitteisiin melko hyvin.

Hiottavaa ohjelmassa vielä on. Suorituskykytestausta on tehtävä enemmän ja 
olisi mukava saada graafinen käyttöliittymä aikaiseksi. Voisin myös yrittää 
miettiä, että voisiko hajautustaulun tyhjennyksestä tehdä "viisaampaa" tai
onko vielä asioita mistä voisi hioa millisekunteja pois.
