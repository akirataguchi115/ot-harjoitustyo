
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
        String link = "https://ohjelmointi-19.mooc.fi/osa-1/1-johdanto";
        assertTrue(this.f.etsi("digi", link));
    }

    @Test
    public void eiLoydaSivulta() throws IOException {
        String link = "https://ohjelmointi-19.mooc.fi/osa-1/1-johdanto";
        assertFalse(this.f.etsi("peruna", link));
    }
}
