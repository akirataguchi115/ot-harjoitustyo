# Käyttöohje

Lataa tiedosto [pressf.jar](https://github.com/akirataguchi115/ot-harjoitustyo/releases/download/viikko5/pressf.jar)

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto _config.properties_, joka määrittelee käyttäjät ja todot tallettavien tiedostojen nimet. Tiedoston muoto on seuraava

```
userFile=users.txt
```
Samassa hakemistossa pitää olla myös tyhjät(tai täytetyt) tekstitiedostot _links.txt_ ja _userFile.txt_.
## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar pressf.jar
```

