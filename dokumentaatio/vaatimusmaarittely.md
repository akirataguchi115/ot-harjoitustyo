# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjien on mahdollista etsiä käyttäjän määrittelemistä dokumenttiryhmästä tietyn merkkijonon sisältämän dokumentin. Sovellusta voi käyttää useampi rekisteröitynyt käyttäjä. Lähtökohtaisena kohderyhmänä opiskelijat, jotka eivät tiedä mistä kaikista käymiensä kurssisivuista/dokumenteista löytyisi ohjeita asiaan x.
## Käyttäjät
Alkuvaiheessa sovelluksella on ainoastaan yksi käyttäjärooli, eli *normaali käyttäjä*. Myöhemmin sovellukseen lisätään suuremmilla oikeuksilla varustettu pääkäyttäjä.
## Perusversion tarjoama toiminnallisuus
### Ennen kirjautumista
* Käyttäjä voi etsiä ennaltamäärätyistä tietokannoista haluttua merkkijonoa
* Käyttäjä voi luoda järjestelmään käyttäjätunnuksen
* Käyttäjä voi valita käyttää "Guest"-tilaa
### Kirjautumisen jälkeen
* Käyttäjä voi lisätä väliaikaiselle -tai pysyvälle listalleen erilaisia dokumentteja sallituissa muodoissa. Aluksi ainoa sallittu muoto on `<.txt>`.
## Jatkokehitysideoita
Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla:
* useampaa tuettua formaattia, esim. `<.pdf`> ja `<.html>`
* tarkempaa tietoa hakutuloksista, esim. sana *rekursoi* ilmestyi eniten dokumentissa y
* verkkotietokanta
* virheilmoitusten -ja datankeräystila pääkäyttäjille
