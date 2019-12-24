# Press F
Press F is a tool to do ```ctrl+F``` with multiple sources(f.ex. websites with subsites). This resolves the problem with doing multiple queries of ```ctrl+F``` while clicking yourself through tiresome amount of websites.
## Documentation

[How to use(finnish)](https://github.com/akirataguchi115/pressf/blob/master/dokumentaatio/kayttoohje.md)

[Architecture(finnish)](https://github.com/akirataguchi115/pressf/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testing document(finnish)](https://github.com/akirataguchi115/pressf/blob/master/dokumentaatio/testausdokumentti.md)

[Releases(finnish)](https://github.com/akirataguchi115/presff/releases)

## Terminal commands

### Ohjelman käynnistäminen
Ohjelma käynnistetään suorittamalla polusta _pressf/_ komento
```
mvn compile exec:java -Dexec.mainClass=Main
```
Syötettävä linkki pitää olla muodossa [https:// tai http://](https://tietokantojen-perusteet-19.mooc.fi/osa-3/1-tiedon-kuvaaminen)
### Testaus
Testit suoritetaan kommenolla
```
mvn test
```
Testikattavuusraportti luodaan komennolla
```
mvn jacoco:report
```
Testikattavuusraportia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _pressF-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/akirataguchi115/ot-harjoitustyo/tree/master/pressF/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedoston _target/site/checkstyle.html_
