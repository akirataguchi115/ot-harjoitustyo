# Press F, Ohjelmistotekniikan harjoitustyö
## Dokumentaatio
[Vaatimusmäärittely](https://github.com/akirataguchi115/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/akirataguchi115/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/akirataguchi115/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Releaset](https://github.com/akirataguchi115/ot-harjoitustyo/releases)

## Komentorivitoiminnot

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
