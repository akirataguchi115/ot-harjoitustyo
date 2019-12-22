# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjien on mahdollista etsiä käyttäjän määrittelemistä dokumenttiryhmästä tietyn merkkijonon sisältämän dokumentin. Sovellusta voi käyttää useampi rekisteröitynyt käyttäjä. Lähtökohtaisena kohderyhmänä opiskelijat, jotka eivät tiedä mistä kaikista käymiensä kurssisivuista/dokumenteista löytyisi ohjeita asiaan x.
## Käyttäjät
Alkuvaiheessa sovelluksella on ainoastaan yksi käyttäjärooli, eli *normaali käyttäjä*. Myöhemmin sovellukseen lisätään suuremmilla oikeuksilla varustettu pääkäyttäjä.
## Perusversion tarjoama toiminnallisuus
### Ennen kirjautumista
Toiminnallisuus | Status
--------------- | ------
Käyttäjä voi etsiä merkkijonoa halutun linkin viittaamasta nettisivusta | tehty
Käyttäjä voi etsiä merkkijonoa useista linkkien viittaamista nettisivuista | tehty
Sovellus huutaa, jos salasana on liian lyhyt | tehty
Sovellus huutaa, jos tunnusta luotaessa käyttäjätunnus löytyy jo tiedostosta | tehty
Käyttäjä voi luoda järjestelmään käyttäjätunnuksen | tehty
Käyttäjä voi tallettaa useat linkkinsä pysyvästi tekstitiedostoon | tehty

### Kirjautumisen jälkeen
* Käyttäjä voi lisätä väliaikaiselle -tai pysyvälle listalleen erilaisia dokumentteja sallituissa muodoissa. Aluksi ainoa sallittu muoto on nettisivu.
## Jatkokehitysideoita
Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla:
* useampaa tuettua formaattia, esim. `<.pdf`> ja `<.html>`
* tarkempaa tietoa hakutuloksista, esim. sana *rekursoi* ilmestyi eniten dokumentissa y
* verkkotietokanta
* virheilmoitusten -ja datankeräystila pääkäyttäjille
