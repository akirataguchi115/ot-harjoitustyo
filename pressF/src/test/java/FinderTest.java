
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pressf.domain.Finder;

public class FinderTest {

    Finder f;

    @Before
    public void setUp() {
        this.f = new Finder();
    }

    @Test
    public void loytaaMerkkijonon() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Tietokannan normalisointi tehdään olemassaolevalle tietokannalle. Tietokannan normalisoinnissa etsimme tietokantatauluista tunnettuja epäkohtia, jonka jälkeen näitä epäkohtia korjataan.");
        lista.add("Tunnettujen epäkohtien tunnistaminen tapahtuu askeleittain valmiita \"säännöstöjä\" eli normaalimuotoja seuraamalla.");
        lista.add("Ensimmäisessä normaalimuodossa otetaan ensiaskeleet tietokannan rakenteen lineaarisoitumiseen");
        assertEquals("lineaari", f.etsi(lista, "lineaari"));
    }

}
