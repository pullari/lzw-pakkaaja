#Viikkoraportti 3

Tämän viikon tärkein työtehtävä minulle oli saada oma hajautustaulu toteutus
toimimaan muun ohjelman kanssa. Tämän sainkin tehtyä, ohjelma ei siis käytä
enää ollenkaan Javan valmiiksi toteuttamaa HashMap-luokkaa.

Täysin minimivaatimuksissaan ohjelma siis on valmis tai vähintäänkin hyvässä
vauhdissa. Ongelmia muodostamassani toteutuksessa lienee nämä:

Hajautustaulu toimii pelkästään avain-arvo pareilla, jotka ovat muotoa 
(String, int) tai (short, String). Toinen isompi ongelma lienee fiksattu
ylivuototaulujen koko (10 kpl). Tähän mennessä kuitenkaan <80mb tekstitiedoston
kanssakaan tämä ei ole ollut ongelma.

Voi myös olla, että koska käytän pakkaamisessa short muuttujia, eli 16
bittisiä koodeja ja olen tehnyt hajautustaulun käyttämästä taulukosta
<80 000 kokoisen ja hajautusavaimen laskennasta sellaisen, että se käyttää
hyväkseen koodattavan merkkijonon merkkien ascii arvoa mod taulukon koko,
että ylivuototauluja ei tarvitse suurentaakaan/toteuttaa dynaamisesti, mutta
se lienee kuitenkin järkevintä.

Mietityttämään tällä viikolla on jäänyt se, että onko kurssin läpäisyn 
kannalta ok, jos käytän hajautustaulutoteutusta, joka hyväksyy vain 
kahdenlaiset avain-arvo parit, vaikkakin se riittää tämän ohjelman käyttöön.

Seuraavaksi lähden tekemään ohjelmalle nykyisessä muodossaan suorityskyky-
testausta ja mahdollisesti dynaamisia ylivuototaulukoita. Alan myös miettimään
graafista toteutusta purettavan/pakattavan tiedoston valinnalle.

Työtunteja: ~8h
