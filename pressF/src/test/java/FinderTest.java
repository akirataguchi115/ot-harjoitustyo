
import java.io.IOException;
import org.junit.Before;
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
    public void loytaaSivulta() throws IOException {
        String link = "https://mooc.fi";
        assertTrue(this.f.etsi("yliopisto", link));
    }

    @Test
    public void eiLoydaSivulta() throws IOException {
        String link = "https://mooc.fi";
        assertFalse(this.f.etsi("peruna", link));
    }

    @Test
    public void addNonExistingSite() {
        String link = "qwhirqwfahsjdklhrethlhasfdö.com";
        assertFalse(this.f.add(link));
    }

    @Test
    public void lisaaOikein() throws IOException {
        String link = "https://uef.fi";
        f.add(link);
        assertTrue(f.etsi("yliopisto", link));
    }
}
