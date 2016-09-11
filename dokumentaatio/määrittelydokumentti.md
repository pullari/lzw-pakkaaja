# Määrittelydokumentti

Työn aiheena on Lempel-Ziv-Welch tiedostonpakkaaja. Tavoitteena on saada se
pakkaamaan pitkiäkin tekstitiedostoja nopeasti pienempään kokoon. Syötteenä
ohjelma siis saa tavallisen .txt tiedoston.

Tiedoston ohjelma lukee tavu kerrallaan ja mikäli sikäli tavu löytyy jo
muistista se lukee uuden tavun niin pitkään kunnes tavujen yhdistelmää
ei löydy muistista. Tässä tilanteessa ohjelma merkitsee uuteen tiedostoon
muistista löytyneelle osalle sitä vastaavan osan ja merkkaa uuden aiemmin 
tuntemattoman osan muistiin. Täten muistista löytyy loppuvaiheessa useita 
eri pituisia merkkijonoja joilla on kaikilla yhtä pitkät tunnisteet muistissa.

Työn toteutan javalla ja tunnisteina käytän 16 bittisiä short muuttujia. Tämä
siis mahdollistaa 65 535 mittaisen listan tunnettuja merkkijonoja, joita
pakatessa ja purkaessa käyttää. Listaan tunnettuja merkkijonoja alustetaan
ASCII koodiston ensimmäiset 255 merkkiä niitä vastaavilla tavuilla.

Ratkaistava ongelma on siis tiedoston koon pienentäminen. Tietorakenteina
käytän vähintäänkin HashMap:ia, tunnisteiden ja kirjainten pareina 
säilyttämiseen. HashMappia käytän sen aikavaativuus mahdollisuuksien vuoksi.
Tavoitteenani on saada HashMapin find-operaatio toimimaan vähintäänkin
aikavaativuudella O(n), mutta keskimääräisessä tapauksessa aikavaativuudella
O(1). Samoin uuden avain-arvo parin lisäämisen pyrin toteuttamaan huonoimmalla
aikavaativuudella O(n), mutta keskimääräisellä aikavaativuudella O(1).

HashMapin ja sen perusoperaatioiden lisäksi ohjelmassa on toteutava sekä
tiedoston pakkaus ja tiedoston purku algoritmit. Ne molemmat toimivat 
lukien joka tavun/16 bittisen short muuttujan kerran ja tehden tälle vakio-
aikaisen operaation. Täten niiden aikavaativuus on O(n) + vakioaikainen 
operaatio, jossa n on syötteen koko.

Tietorakenteita toteutettavana on siis vähintäänkin HashMap ja algoritmeina
sen perusoperaatiot sekä Lempel-Ziv-Welch:n pakkaus- ja purkualgoritmi. 
Nämä algoritmit ja tietorakenteet eivät vaadi rekursiivisuutta ja muistissa
pidettävällä listalla on aina määrätty maksimikoko sovitun bittimäärän mukaan, 
joten tähän tiettyyn kokoon asti HashMapin voi ajatella vaativan tilaa 
pahimmassa tapauksessa O(n) verran.

Lähteet:
https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch
http://www.fileformat.info/mirror/egff/ch09_04.htm
https://www.youtube.com/watch?v=j2HSd3HCpDs
http://algs4.cs.princeton.edu/55compression/LZW.java.html
