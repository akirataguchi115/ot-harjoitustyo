# Arkkitehtuurikuvaus

## Rakenne
Ohjelman rakenne tulee noudattamaan kolmitasoista kerrosarkkitehtuuria(DAO vielä lisää), ja koodin pakkausrakenne on seuraava:

![pakkausrakenne](pakettikaavio2.png)

Pakkaus _pressf.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän ja _pressf.domain_ sovelluslogiikan.

### Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona.

#### käyttäjän uuden tunnuksen luominen

Kun kirjautumisnäkymässä on syötekenttään kirjoitettu käyttäjätunnus ja klikataan painiketta _createButton_ etenee sovelluksen kontrolli seuraavasti:

<img src="pressfsekvenssi.png">

## Käyttöliittymä

Käyttöliittymä sisältää kolme kaksi erillistä näkymää
- kirjautuminen
- haku

jokainen näistä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona.

## Sovelluslogiikka

## Tietojen pysyväistallennus

### Tiedostot

Sovellus tallettaa käyttäjätiedot yhteen tietokantatauluun. Taulun sarakkeita ovat ```id(auto increment), käyttäjätunnus(merkkijono),salasana(merkkijono)```

## Ohjelman rakenteeseen jääneet heikkoudet

Tietokantoja voisi vielä hyödyntää vielä enemmän. Tällä hetkellä ainoa tietokantoihin kohdistuva "haku" on käyttäjänimen etsiminen ja sillä tervehtiminen.

### käyttöliittymä

Käyttöliittymän sisennyksiä voisi parannella käytetävyyden parantamiseksi.

### DAO-luokat

Clutteria ja refaktorointia voisi harjoittaa ajan puitteissa. Ohjelmaa olisi tällöin helpompi kehittää eteenpäin.
